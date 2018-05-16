package com.github.kotall.weixin.framework.event;

import com.github.kotall.weixin.framework.core.WxRequest;
import com.github.kotall.weixin.framework.core.WxEventRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Data
@ToString(callSuper = true)
@XStreamAlias("xml")
public class WxQrCodeEventReq extends WxEventRequest {

    @XStreamAlias("EventKey")
    private String eventKey;

    @XStreamAlias("Ticket")
    private String ticket;

    public WxQrCodeEventReq(WxRequest request) {
        super(request);
        this.eventKey = request.getParameter("//EventKey");
        this.ticket = request.getParameter("//Ticket");
    }
}
