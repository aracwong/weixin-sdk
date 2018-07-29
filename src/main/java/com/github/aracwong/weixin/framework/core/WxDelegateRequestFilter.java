package com.github.aracwong.weixin.framework.core;

import com.github.aracwong.weixin.framework.exception.WxException;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;

/**
 * Handler 业务处理代理类
 *
 * @author aracwong
 * @version 1.0.0
 */
public abstract class WxDelegateRequestFilter<R extends WxRequest> implements WxRequestFilter, WxHandler<R> {

    /**
     * handler key
     * 建议使用能标记唯一的 msgType
     * @return
     */
    public abstract String getHandlerKey();

    /**
     * 该 Handler支持的消息处理类型
     *
     * @param request
     *       微信请求对象
     * @return
     *       是否支持
     */
    public abstract boolean support(WxRequest request);

    @Override
    public void doFilter(WxRequest request, WxResponse response, WxRequestFilterChain chain) {
        // 1. 判断该Handler是否支持此报文处理
        if (support(request)) {
            // 2. 解析微信报文
            R wxRequest;

            try {
                // 获取 WxDelegateRequestFilter 注解参数
                Class<R> clazz;
                ParameterizedType type;
                if (this.getClass().getSuperclass().getTypeParameters().length > 0) {
                    // Default Handler
                    type = (ParameterizedType) (this.getClass().getGenericSuperclass());
                } else {
                    // Implements Handler
                    type = (ParameterizedType) (this.getClass().getSuperclass().getGenericSuperclass());
                }

                clazz = (Class<R>) type.getActualTypeArguments()[0];

                Constructor constructor = clazz.getConstructor(WxRequest.class);
                wxRequest = (R) constructor.newInstance(request);
            } catch (Exception e) {
                throw new WxException("Unexpected exception!", e);
            }
            // 3. 处理消息
            this.handle(wxRequest, response);
        }
        // 4. 下一个Handler处理
        chain.doFilter(request, response, chain);
    }
}
