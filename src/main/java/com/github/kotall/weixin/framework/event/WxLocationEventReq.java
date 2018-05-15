package com.github.kotall.weixin.framework.event;

import com.github.kotall.weixin.framework.core.WxRequest;
import com.github.kotall.weixin.framework.core.WxEventRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

/**
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/4/29 0029 上午 10:11
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
