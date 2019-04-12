package com.github.aracwong.wxframework.mp.core;

import com.thoughtworks.xstream.annotations.XStreamOmitField;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Data
public class WxDefaultResponse implements WxResponse {

    private String msgType;

    private String toUserName;

    private String fromUserName;

    private long createTime;

    @XStreamOmitField
    private Map<String, Object> attributes = new HashMap<>();

    public WxDefaultResponse(WxRequest wxRequest) {
        this.msgType = wxRequest.getMsgType();
        this.fromUserName = wxRequest.getToUserName();
        this.toUserName = wxRequest.getFromUserName();
        this.createTime = System.currentTimeMillis();
    }

    @Override
    public void setAttribute(String key, Object value) {
         this.attributes.put(key, value);
    }

    @Override
    public Object getAttribute(String key) {
        return this.attributes.get(key);
    }
}
