package com.github.aracwong.weixin.framework.core;

/**
 * @author aracwong
 * @version 1.0.0
 */
public interface WxResponse {

    /**
     * 设置属性
     * @param key
     *        属性 key
     * @param value
     *        属性值
     */
    void setAttribute(String key, Object value);

    /**
     * 获取属性值
     * @param key
     *       属性 key
     * @return
     *       属性值
     */
    Object getAttribute(String key);

    /**
     * MsgType
     * @return
     *    msgType
     */
    String getMsgType();

    /**
     * FromUserName
     * @return
     *     fromUserName
     */
    String getFromUserName();

    /**
     * ToUserName
     * @return
     *     toUserName
     */
    String getToUserName();

    /**
     * CreateTime
     * @return
     *    createTime
     */
    long getCreateTime();

}
