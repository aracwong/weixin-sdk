package com.github.aracwong.wxframework.mp.event;

import com.github.aracwong.wxframework.mp.core.WxEventRequest;
import com.github.aracwong.wxframework.mp.core.WxRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Data
@ToString(callSuper = true)
@XStreamAlias("xml")
public class WxScanCodeEventReq extends WxEventRequest {

    @XStreamAlias("EventKey")
    private String eventKey;

    @XStreamAlias("ScanCodeInfo")
    private ScanCodeInfo scanCodeInfo = new ScanCodeInfo();

    @Data
    public class ScanCodeInfo {
        @XStreamAlias("ScanType")
        private String scanType;

        @XStreamAlias("ScanResult")
        private String scanResult;
    }

    public WxScanCodeEventReq(WxRequest request) {
        super(request);
        this.eventKey = request.getParameter("//EventKey");
        this.scanCodeInfo.setScanType(request.getParameter("//ScanCodeInfo/ScanType"));
        this.scanCodeInfo.setScanResult(request.getParameter("//ScanCodeInfo/ScanResult"));
    }

}

