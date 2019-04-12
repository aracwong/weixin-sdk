package com.github.aracwong.wxframework.mp.msg.event;

import com.github.aracwong.wxframework.mp.core.request.WxEventRequest;
import com.github.aracwong.wxframework.mp.core.request.WxRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

/**
 * 用户点击自定义菜单事件
 *
 * @author aracwong
 * @version 1.0.0
 */
@Data
@ToString(callSuper = true)
@XStreamAlias("xml")
public class WxMenuEventReq extends WxEventRequest {

    @XStreamAlias("EventKey")
    private String eventKey;

    public WxMenuEventReq(WxRequest request) {
        super(request);
        this.eventKey = request.getParameter("//EventKey");
    }
}
