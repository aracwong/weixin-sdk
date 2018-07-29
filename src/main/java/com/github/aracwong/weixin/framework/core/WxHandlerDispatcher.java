package com.github.aracwong.weixin.framework.core;

import com.github.aracwong.weixin.dto.accesstoken.WxAccountDto;
import com.github.aracwong.weixin.framework.annotation.WxHandler;
import com.github.aracwong.weixin.framework.constant.WxConstant;
import com.github.aracwong.weixin.framework.handler.event.*;
import com.github.aracwong.weixin.framework.handler.file.DefaultWxFileRequestHandler;
import com.github.aracwong.weixin.framework.handler.image.DefaultWxImageRequestHandler;
import com.github.aracwong.weixin.framework.handler.link.DefaultWxLinkRequestHandler;
import com.github.aracwong.weixin.framework.handler.location.DefaultWxLocationRequestHandler;
import com.github.aracwong.weixin.framework.handler.text.DefaultWxTextRequestHandler;
import com.github.aracwong.weixin.framework.handler.video.DefaultWxVideoRequestHandler;
import com.github.aracwong.weixin.framework.handler.voice.DefaultWxVoiceRequestHandler;
import com.github.aracwong.weixin.utils.ClassUtil;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.thoughtworks.xstream.XStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 微信消息核心处理器
 *
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class WxHandlerDispatcher extends HttpServlet {


    private WxConfigStorage wxConfigStorage;


    private List<WxRequestFilter> handlerList = Collections.emptyList();

    public WxHandlerDispatcher() {}

    public WxHandlerDispatcher(WxConfigStorage wxConfigStorage) {
        this.wxConfigStorage = wxConfigStorage;
    }

    public WxHandlerDispatcher(WxConfigStorage wxConfigStorage, String handlerAnnotationPacakge) {
        this.wxConfigStorage = wxConfigStorage;
        // 注册消息处理器
        registWxMsgHandlers(handlerAnnotationPacakge);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqMethod = req.getMethod();
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String signature = req.getParameter("signature");

        req.setCharacterEncoding(Charsets.UTF_8.name());
        resp.setCharacterEncoding(Charsets.UTF_8.name());
        String url = req.getRequestURL().toString();
        try {
            /** 微信认证请求处理 */
            if ("GET".equals(reqMethod)) {
                String echoStr = req.getParameter("echostr");
                List<String> list = new ArrayList<>();
                list.add(timestamp);
                list.add(nonce);

                // 获取 token
                WxAccountDto wxAccountDto = this.wxConfigStorage.getWxAccount(url);
                if (null != wxAccountDto) {
                    list.add(wxAccountDto.getToken());
                }
                log.info("====== 微信认证请求 url: {}, 微信账户配置：{}", url, wxAccountDto);
                StringBuffer sb = new StringBuffer();
                list.forEach(str -> sb.append(str));

                String encryptStr = DigestUtils.sha1Hex(sb.toString());
                if (encryptStr.equals(signature)) {
                    log.info("========== 认证成功！");
                    resp.getWriter().print(echoStr);
                    resp.getWriter().flush();
                } else {
                    log.info("========== 认证失败！");
                }

            }

            /** 微信数据请求处理 */
            else if ("POST".equals(reqMethod)) {
                String openid = req.getParameter("openid");
                ByteArrayOutputStream result = new ByteArrayOutputStream();
                InputStream reqIs = req.getInputStream();
                byte[] buff = new byte[1024];
                int index;
                while ((index = reqIs.read(buff)) != -1) {
                    result.write(buff, 0, index);
                }

                reqIs.close();

                String reqBody = result.toString(Charsets.UTF_8.name());

                log.info("========== 微信POST请求: \r\n{}", reqBody);
                if (!Strings.isNullOrEmpty(reqBody)) {
                    WxDefaultRequest wxRequest = new WxDefaultRequest(reqBody);
                    WxResponse wxResponse = new WxDefaultResponse(wxRequest);

                    this.doDispatch(wxRequest, wxResponse);

                    String KEY_RESPONSE_BODY = "body";
                    Object responseBody = wxResponse.getAttribute(KEY_RESPONSE_BODY);
                    if (null != wxResponse.getAttribute(KEY_RESPONSE_BODY)) {
                        XStream xStream = new XStream();
                        xStream.autodetectAnnotations(true);
                        String xml = xStream.toXML(responseBody);
                        log.info("响应报文：\r\n{}", xml);
                        resp.getWriter().print(xml);
                        resp.getWriter().flush();
                    }
                }
            }
        } catch (Exception e) {
            log.error("处理微信请求异常!", e);
        }
    }

    /**
     * 微信消息核心处理器
     *
     * @param request  请求对象
     * @param response 响应对象
     */
    public void doDispatch(WxRequest request, WxResponse response) {
        WxRequestFilterChain wxHandlerChain = null;
        List<WxRequestFilter> handlers = this.handlerList;
        if (null != handlers && handlers.size() != 0) {
            wxHandlerChain = new WxRequestFilterChain();
            for (WxRequestFilter handler : handlers) {
                wxHandlerChain.addHandler(handler);
            }
        }

        if (null == wxHandlerChain) {
            log.warn("暂不支持的消息类型: {}", request.getMsgType());
        }
        log.info("===== 调用处理器链处理消息类型：{}", request.getMsgType());
        wxHandlerChain.doFilter(request, response, wxHandlerChain);
    }

    public void registWxMsgHandlers(String handlerAnnotationPacakge) {
        List<WxRequestFilter> handlerList = new ArrayList<>();

        Map<String, WxRequestFilter> defaultHandlerMapping = new ConcurrentHashMap<>();

        /** 注册默认消息处理器 */
        defaultHandlerMapping.put(WxConstant.HANDLER_TEXT, new DefaultWxTextRequestHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_IMAGE, new DefaultWxImageRequestHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_VOICE, new DefaultWxVoiceRequestHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_VIDEO, new DefaultWxVideoRequestHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_LINK, new DefaultWxLinkRequestHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_LOCATION, new DefaultWxLocationRequestHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_FILE, new DefaultWxFileRequestHandler());

        defaultHandlerMapping.put(WxConstant.HANDLER_EVENT_FOLLOW, new DefaultWxFollowEventHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_EVENT_QRCODE, new DefaultWxQrCodeEventHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_EVENT_LOCATION, new DefaultWxLocationEventHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_EVENT_MENU_DEFAULT, new DefaultWxMenuEventHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_EVENT_MENU_SCANCODE_PUSH, new DefaultWxScanCodeEventHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_EVENT_MENU_PIC_PHOTO, new DefaultWxPicPhotoEventHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_EVENT_MENU_LOCATION_SELECT, new DefaultWxLocationSelectEventHandler());

        /** 注册消息处理器 */
        if (Strings.isNullOrEmpty(handlerAnnotationPacakge)) {
            handlerAnnotationPacakge = "com.github.aracwong.weixin";
        }
        List<Class<?>> classes = ClassUtil.getClasses(handlerAnnotationPacakge);
        for (Class<?> aClass : classes) {
            Annotation annotation = aClass.getAnnotation(com.github.aracwong.weixin.framework.annotation.WxHandler.class);
            if (null != annotation && annotation instanceof WxHandler) {
                WxHandler wxHandler = (WxHandler)annotation;
                String handlerType = wxHandler.forType();
                try {
                    WxRequestFilter wxRequestFilter = (WxRequestFilter)aClass.newInstance();
                    log.info("===注册消息处理器：handlerType={}, 处理器类名：{}", handlerType, aClass.getSimpleName());
                    defaultHandlerMapping.put(handlerType, wxRequestFilter);
                } catch (Exception e) {
                    throw new RuntimeException("register implementation WxHandler exception!", e);
                }
            }
        }

        defaultHandlerMapping.forEach((key, value) -> handlerList.add(value));
    }

}
