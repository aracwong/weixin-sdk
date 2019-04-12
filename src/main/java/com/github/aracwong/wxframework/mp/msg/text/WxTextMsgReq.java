package com.github.aracwong.wxframework.mp.msg.text;

import com.github.aracwong.wxframework.mp.core.request.WxRequest;
import com.github.aracwong.wxframework.mp.core.request.WxRequestWrapper;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

/**
 * 普通文本消息
 * @author aracwong
 * @version 1.0.0
 */
@Data
@ToString(callSuper = true)
@XStreamAlias("xml")
public class WxTextMsgReq extends WxRequestWrapper {

    @XStreamAlias("MsgId")
    private String msgId;

    @XStreamAlias("Content")
    private String content;

    public WxTextMsgReq(WxRequest request) {
        super(request);
        this.msgId = request.getParameter("//MsgId");
        this.content = request.getParameter("//Content");
    }

}
