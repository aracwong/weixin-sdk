package com.github.aracwong.wxframework.mp.msg.link;

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
public class WxLinkMsgReq extends WxRequestWrapper {
    @XStreamAlias("MsgId")
    private String msgId;

    @XStreamAlias("Title")
    private String title;

    @XStreamAlias("Description")
    private String description;

    @XStreamAlias("Url")
    private String url;

    public WxLinkMsgReq(WxRequest request) {
        super(request);
        this.msgId = request.getParameter("//MsgId");
        this.title = request.getParameter("//title");
        this.description = request.getParameter("//Description");
        this.url = request.getParameter("//Url");
    }
}
