package com.github.aracwong.wxframework.mp.event;

import com.github.aracwong.wxframework.mp.core.WxEventRequest;
import com.github.aracwong.wxframework.mp.core.WxRequest;
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
public class WxLocationEventReq extends WxEventRequest {

    @XStreamAlias("Latitude")
    private String latitude;

    @XStreamAlias("Longitude")
    private String longitude;

    @XStreamAlias("Precision")
    private String precision;

    public WxLocationEventReq(WxRequest request) {
        super(request);
        this.latitude = request.getParameter("//Latitude");
        this.longitude = request.getParameter("//Longitude");
        this.precision = request.getParameter("//Precision");
    }
}
