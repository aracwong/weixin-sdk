package com.github.kotall.weixin.framework.core;

/**
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/4/30 0030 上午 7:55
 */
public interface WxRequestFilter {

    /**
     * 微信消息处理器链
     *
     * @param request
     * @param response
     * @param chain
     */
    void doFilter(WxRequest request, WxResponse response, WxRequestFilterChain chain);
}
