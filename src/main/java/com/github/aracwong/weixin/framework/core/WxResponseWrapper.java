package com.github.aracwong.weixin.framework.core;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * @author aracwong
 * @version 1.0.0
 */
public class WxResponseWrapper implements WxResponse {

    @XStreamOmitField
    private WxResponse response;

    public WxResponseWrapper(WxResponse response) {
        this.response = response;
    }

    @Override
    public String getMsgType() {
        return this.response.getMsgType();
    }

    @Override
    public String getFromUserName() {
        return this.response.getFromUserName();
    }

    @Override
    public String getToUserName() {
        return this.response.getToUserName();
    }

    @Override
    public long getCreateTime() {
        return this.response.getCreateTime();
    }

    @Override
    public void setAttribute(String key, Object value) {
        this.response.setAttribute(key, value);
    }

    @Override
    public Object getAttribute(String key) {
        return this.response.getAttribute(key);
    }
}
