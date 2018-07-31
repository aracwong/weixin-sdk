package com.github.aracwong.weixin.framework.core;

/**
 * 微信消息具体处理器
 *
 * @author aracwong
 * @version 1.0.0
 */
public interface WxHandler<R extends WxRequest> {

    /**
     * handler key
     * 建议使用能标记唯一的 msgType
     * @return
     */
    String getHandlerKey();

    /**
     * 该 Handler支持的消息处理类型
     *
     * @param request
     *       微信请求对象
     * @return
     *       是否支持
     */
    boolean support(WxRequest request);

    /**
     * 处理微信请求的具体业务处理逻辑
     *
     * @param request
     *        请求对象
     * @param response
     *        响应对象
     */
    void handle(R request, WxResponse response);
}
