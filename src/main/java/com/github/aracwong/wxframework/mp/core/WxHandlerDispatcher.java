package com.github.aracwong.wxframework.mp.core;

import com.github.aracwong.wxframework.mp.core.filter.WxRequestFilter;
import com.github.aracwong.wxframework.mp.core.filter.WxRequestFilterChain;
import com.github.aracwong.wxframework.mp.core.request.WxDefaultRequest;
import com.github.aracwong.wxframework.mp.core.request.WxRequest;
import com.github.aracwong.wxframework.mp.core.response.WxDefaultResponse;
import com.github.aracwong.wxframework.mp.core.response.WxResponse;
import com.github.aracwong.wxframework.mp.dto.token.WxAccountDto;
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


    private WxConfigStorage wxConfigStorage;

    private WxMsgHandlerRegistration wxHandlerRegistration;

    public WxHandlerDispatcher() {
    }

    public WxHandlerDispatcher(WxConfigStorage wxConfigStorage) {
        this.wxConfigStorage = wxConfigStorage;
    }

    public WxHandlerDispatcher(WxConfigStorage wxConfigStorage, WxMsgHandlerRegistration wxHandlerRegistration) {
        this.wxConfigStorage = wxConfigStorage;
        this.wxHandlerRegistration = wxHandlerRegistration;
    }

    /**
     * 处理微信服务器认证请求
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(Charsets.UTF_8.name());
        resp.setCharacterEncoding(Charsets.UTF_8.name());
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String signature = req.getParameter("signature");
        String echoStr = req.getParameter("echostr");
        List<String> list = new ArrayList<>();
        list.add(timestamp);
        list.add(nonce);

        // 获取 token
        String url = req.getRequestURL().toString();
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(Charsets.UTF_8.name());
        resp.setCharacterEncoding(Charsets.UTF_8.name());
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
            try {
                WxDefaultRequest wxRequest = new WxDefaultRequest(reqBody);
                WxResponse wxResponse = new WxDefaultResponse(wxRequest);

                this.doDispatch(wxRequest, wxResponse);

                String respBody = "body";
                Object responseBody = wxResponse.getAttribute(respBody);
                if (null != wxResponse.getAttribute(respBody)) {
                    XStream xStream = new XStream();
                    xStream.autodetectAnnotations(true);
                    String xml = xStream.toXML(responseBody);
                    log.info("响应报文：\r\n{}", xml);
                    resp.getWriter().print(xml);
                    resp.getWriter().flush();
                }
            } catch (Exception e) {
                log.error("处理微信端消息异常", e);
            }
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
        List<WxRequestFilter> handlers = this.wxHandlerRegistration.getHandlerFilters();
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
