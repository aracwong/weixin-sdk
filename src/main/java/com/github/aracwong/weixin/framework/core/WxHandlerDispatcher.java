package com.github.aracwong.weixin.framework.core;

import com.github.aracwong.weixin.dto.accesstoken.WxAccountDto;
import com.github.aracwong.weixin.framework.context.WxAppContext;
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
import java.util.ArrayList;
import java.util.List;

/**
 * 微信消息核心处理器
 *
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class WxHandlerDispatcher extends HttpServlet {


    private WxConfigHolder wxConfigHolder;

    public WxHandlerDispatcher() {}

    public WxHandlerDispatcher(WxConfigHolder wxConfigHolder) {
        this.wxConfigHolder = wxConfigHolder;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqMethod = req.getMethod();
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String signature = req.getParameter("signature");

        String url = req.getRequestURL().toString();
        req.setCharacterEncoding(Charsets.UTF_8.name());
        resp.setCharacterEncoding(Charsets.UTF_8.name());
        try {
            /** 微信认证请求处理 */
            if ("GET".equals(reqMethod)) {
                String echoStr = req.getParameter("echostr");
                List<String> list = new ArrayList<>();
                list.add(timestamp);
                list.add(nonce);
                WxAccountDto wxAccountDto = this.wxConfigHolder.getWxAccount(url);
                if (null != wxAccountDto) {
                    list.add(wxAccountDto.getToken());
                }
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
        List<WxRequestFilter> handlers = WxAppContext.getWxMsgHandlers();
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
}
