package com.github.kotall.weixin.framework.core;

import java.util.Map;

/**
 * 微信请求对象接口
 *
 * @author aracwong
 * @version 1.0.0
 */
public interface WxRequest {

    /**
     * FromUserName
     * @return
     */
    String getFromUserName();

    /**
     * ToUserName
     * @return
     */
    String getToUserName();

    /**
     * CreateTime
     * @return
     */
    long getCreateTime();

    /**
     * MsgType
     * @return
     */
    String getMsgType();

    /**
     * 获取报文字段属性值
     *
     * @param name
     * @return
     */
    String getParameter(String name);

    /**
     * 根据XPath node type 获取属性
     *
     * @param nodeName
     * @return
     */
    Object getNodeListParameter(String nodeName);

    /**
     * 设置请求Request 属性
     *
     * @param name
     * @param value
     */
    void setAttribute(String name, Object value);

    /**
     * 获取 Request scope的属性
     * @param key
     * @return
     */
    Object getAttribute(String key);

    /**
     * 将微信请求数据转换为简单 Map
     * @return
     */
    Map<String, String> toSimpleMap();

}
