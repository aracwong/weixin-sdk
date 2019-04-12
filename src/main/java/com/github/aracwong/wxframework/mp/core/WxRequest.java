package com.github.aracwong.wxframework.mp.core;

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
     *    fromUserName
     */
    String getFromUserName();

    /**
     * ToUserName
     * @return
     *    toUserName
     */
    String getToUserName();

    /**
     * CreateTime
     * @return
     *    createTime
     */
    long getCreateTime();

    /**
     * MsgType
     * @return
     *     msgType
     */
    String getMsgType();

    /**
     * 获取报文字段属性值
     *
     * @param name
     *      参数名称
     * @return
     *      参数值
     */
    String getParameter(String name);

    /**
     * 根据XPath node type 获取属性
     *
     * @param nodeName
     *        node key值
     * @return
     *       Node
     */
    Object getNodeListParameter(String nodeName);

    /**
     * 设置请求Request 属性
     *
     * @param name
     *      属性 key
     * @param value
     *      属性 value
     */
    void setAttribute(String name, Object value);

    /**
     * 获取 Request scope的属性
     * @param key
     *      属性 key
     * @return
     *      属性值
     */
    Object getAttribute(String key);

    /**
     * 将微信请求数据转换为简单 Map
     * @return
     *     Map对象
     */
    Map<String, String> toSimpleMap();

}
