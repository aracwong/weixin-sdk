package com.github.kotall.weixin.framework.annotation;

import com.github.kotall.weixin.framework.constant.WxMsgType;

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
     * 消息类型 对应微信报文中的 WxMsgType
     * @see WxMsgType
     * @return
     *      msgType
     */
    String forMsgType();
}
