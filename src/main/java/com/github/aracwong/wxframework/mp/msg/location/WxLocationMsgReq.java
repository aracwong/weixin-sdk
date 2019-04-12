package com.github.aracwong.wxframework.mp.msg.location;

import com.github.aracwong.wxframework.mp.core.request.WxRequest;
import com.github.aracwong.wxframework.mp.core.request.WxRequestWrapper;
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
public class WxLocationMsgReq extends WxRequestWrapper {

    @XStreamAlias("MsgId")
    private String msgId;

    @XStreamAlias("Label")
    private String label;

    @XStreamAlias("Scale")
    private String scale;

    /**
     * 地理位置维度
     */
    @XStreamAlias("Location_X")
    private String locationX;

    /**
     * 地理位置经度
     */
    @XStreamAlias("Location_Y")
    private String locationY;

    public WxLocationMsgReq(WxRequest request) {
        super(request);
        this.msgId = request.getParameter("//MsgId");
        this.label = request.getParameter("//label");
        this.scale = request.getParameter("//Scale");
        this.locationX = request.getParameter("//Location_X");
        this.locationY = request.getParameter("//Location_Y");
    }
}
