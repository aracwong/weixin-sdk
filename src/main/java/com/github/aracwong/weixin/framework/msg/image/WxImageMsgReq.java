package com.github.aracwong.weixin.framework.msg.image;

import com.github.aracwong.weixin.framework.core.WxRequest;
import com.github.aracwong.weixin.framework.core.WxRequestWrapper;
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
public class WxImageMsgReq extends WxRequestWrapper {

    @XStreamAlias("MsgId")
    private String msgId;

    @XStreamAlias("MediaId")
    private String mediaId;

    @XStreamAlias("PicUrl")
    private String picUrl;

    public WxImageMsgReq(WxRequest wxRequest) {
        super(wxRequest);
        this.msgId = wxRequest.getParameter("//MsgId");
        this.mediaId = wxRequest.getParameter("//MediaId");
        this.picUrl = wxRequest.getParameter("//PicUrl");
    }

}
