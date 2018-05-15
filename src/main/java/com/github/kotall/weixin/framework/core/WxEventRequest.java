package com.github.kotall.weixin.framework.core;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/4/29 0029 上午 10:03
 */
public class WxEventRequest extends WxRequestWrapper {


    @XStreamAlias("Event")
    private String event;

    public WxEventRequest(WxRequest wxRequest) {
        super(wxRequest);
    }

    public String getEvent() {
        if (null == event) {
            event = this.getParameter("//Event");
        }
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
