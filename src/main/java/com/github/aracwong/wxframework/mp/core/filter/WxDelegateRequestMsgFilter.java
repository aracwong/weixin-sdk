package com.github.aracwong.wxframework.mp.core.filter;

import com.github.aracwong.wxframework.common.exception.WxException;
import com.github.aracwong.wxframework.mp.core.WxMsgHandler;
import com.github.aracwong.wxframework.mp.core.filter.WxRequestFilter;
import com.github.aracwong.wxframework.mp.core.filter.WxRequestFilterChain;
import com.github.aracwong.wxframework.mp.core.request.WxRequest;
import com.github.aracwong.wxframework.mp.core.response.WxResponse;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;

/**
 * Handler 业务处理代理类
 *
 * @author aracwong
 * @version 1.0.0
 */
public abstract class WxDelegateRequestMsgFilter<R extends WxRequest> implements WxRequestFilter, WxMsgHandler<R> {

    @Override
    public void doFilter(WxRequest request, WxResponse response, WxRequestFilterChain chain) {
        // 1. 判断该Handler是否支持此报文处理
        if (support(request)) {
            // 2. 解析微信报文
            R wxRequest;

            try {
                // 获取 WxDelegateRequestMsgFilter 注解参数
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
