package com.github.aracwong.weixin.framework.core;

/**
 * 微信消息解析器
 *
 * @author aracwong
 * @version 1.0.0
 */
public interface WxRequestParser<R extends WxRequest> {

    /**
     * 微信消息解析器
     *
     * @param request
     *        请求
     * @return
     *        包装后的具体请求
     */
    R doParser(WxRequest request);
}
