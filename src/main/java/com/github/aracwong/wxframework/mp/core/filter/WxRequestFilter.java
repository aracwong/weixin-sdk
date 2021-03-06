package com.github.aracwong.wxframework.mp.core.filter;

import com.github.aracwong.wxframework.mp.core.request.WxRequest;
import com.github.aracwong.wxframework.mp.core.response.WxResponse;

/**
 * @author aracwong
 * @version 1.0.0
 */
public interface WxRequestFilter {

    /**
     * 微信消息处理器链
     *
     * @param request
     *       请求
     * @param response
     *       响应
     * @param chain
     *       过滤器链
     */
    void doFilter(WxRequest request, WxResponse response, WxRequestFilterChain chain);
}
