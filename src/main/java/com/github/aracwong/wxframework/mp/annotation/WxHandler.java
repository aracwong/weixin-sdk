package com.github.aracwong.wxframework.mp.annotation;

import com.github.aracwong.wxframework.common.constants.MpHandlerType;

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
     * 消息处理器类型 参见 MpHandlerType
     * @see MpHandlerType
     * @return
     *      handlerType
     */
    String forType();
}
