package com.github.kotall.weixin.framework.core;

/**
 * 微信消息解析器
 *
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/4/30 0030 上午 9:38
 */
public interface WxRequestParser<R extends WxRequest> {

    /**
     * 微信消息解析器
     *
     * @param request
     * @return
     */
    R doParser(WxRequest request);
}
