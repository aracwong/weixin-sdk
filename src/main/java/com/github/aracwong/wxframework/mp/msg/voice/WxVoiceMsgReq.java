package com.github.aracwong.wxframework.mp.msg.voice;

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
public class WxVoiceMsgReq extends WxRequestWrapper {

    @XStreamAlias("MsgId")
    private String msgId;

    @XStreamAlias("MediaId")
    private String mediaId;

    @XStreamAlias("Format")
    private String format;

    /**
     * 语音识别功能开启时会有此字段
     */
    @XStreamAlias("Recognition")
    private String recognition;

    public WxVoiceMsgReq(WxRequest request) {
        super(request);
        this.msgId = request.getParameter("//MsgId");
        this.mediaId = request.getParameter("//MediaId");
        this.format = request.getParameter("//Format");
        /**
         * 语音识别功能开启时会有此字段
         */
        this.recognition = request.getParameter("//Recognition");
    }
}
