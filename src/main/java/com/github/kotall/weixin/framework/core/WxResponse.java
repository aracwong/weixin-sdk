package com.github.kotall.weixin.framework.core;

/**
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/4/30 0030 上午 7:54
 */
public interface WxResponse {

    /**
     * 设置属性
     * @param key
     * @param value
     */
    void setAttribute(String key, Object value);

    /**
     * 获取属性值
     * @param key
     * @return
     */
    Object getAttribute(String key);

    /**
     * MsgType
     * @return
     */
    String getMsgType();

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

}
