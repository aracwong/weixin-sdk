package com.github.aracwong.wx.mp.framework.core;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author aracwong
 * @version 1.0.0
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
