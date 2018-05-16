package com.github.kotall.weixin.framework.core;

import com.github.kotall.weixin.framework.context.WxAppContext;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 单例对象
 *
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class WxHandlerDispatcher {

    /**
     * 微信消息核心处理器
     *
     * @param request
     *        请求对象
     * @param response
     *        响应对象
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
