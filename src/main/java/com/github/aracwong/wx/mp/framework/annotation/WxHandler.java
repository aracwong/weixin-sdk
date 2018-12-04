package com.github.aracwong.wx.mp.framework.annotation;

import com.github.aracwong.wx.mp.framework.constant.WxHandlerType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 微信消息处理器注解
 *
 * @author aracwong
 * @version 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface WxHandler {

    /**
     * 消息处理器类型 参见 WxHandlerType
     * @see WxHandlerType
     * @return
     *      handlerType
     */
    String forType();
}
