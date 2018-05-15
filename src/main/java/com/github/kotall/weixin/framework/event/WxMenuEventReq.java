package com.github.kotall.weixin.framework.event;

import com.github.kotall.weixin.framework.core.WxEventRequest;
import com.github.kotall.weixin.framework.core.WxRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

/**
 * 用户点击自定义菜单事件
 *
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/4/29 0029 上午 10:16
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
