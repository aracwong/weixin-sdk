package com.github.aracwong.wxframework.mp.core.request;

import lombok.Data;

import java.util.Map;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Data
public class WxRequestWrapper implements WxRequest {

    private WxRequest wxRequest;

    public WxRequestWrapper(WxRequest wxRequest) {
        this.wxRequest = wxRequest;
    }

    public WxRequest getWxRequest() {
        return this.wxRequest;
    }

    @Override
    public String getFromUserName() {
        return this.wxRequest.getFromUserName();
    }

    @Override
    public String getToUserName() {
        return this.wxRequest.getToUserName();
    }

    @Override
    public long getCreateTime() {
        return this.wxRequest.getCreateTime();
    }

    @Override
    public String getMsgType() {
        return this.wxRequest.getMsgType();
    }

    @Override
    public String getParameter(String name) {
        return this.wxRequest.getParameter(name);
    }

    @Override
    public Object getNodeListParameter(String nodeName) {
        return this.wxRequest.getNodeListParameter(nodeName);
    }

    @Override
    public void setAttribute(String name, Object value) {
        this.wxRequest.setAttribute(name, value);
    }

    @Override
    public Object getAttribute(String key) {
        return this.wxRequest.getAttribute(key);
    }

    @Override
    public Map<String, String> toSimpleMap() {
        return this.wxRequest.toSimpleMap();
    }
}
