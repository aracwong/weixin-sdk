package com.github.aracwong.wxframework.mp.msg.video;

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
public class WxVideoMsgReq extends WxRequestWrapper {

    @XStreamAlias("MsgId")
    private String msgId;

    @XStreamAlias("MediaId")
    private String mediaId;

    @XStreamAlias("Format")
    private String format;

    /**
     * 视频缩略图的 媒体 id
     */
    @XStreamAlias("ThumbMediaId")
    private String thumbMediaId;

    public WxVideoMsgReq(WxRequest request) {
        super(request);
        this.msgId = request.getParameter("//MsgId");
        this.mediaId = request.getParameter("//MediaId");
        this.format = request.getParameter("//Format");
        this.thumbMediaId = request.getParameter("//ThumbMediaId");
    }
}
