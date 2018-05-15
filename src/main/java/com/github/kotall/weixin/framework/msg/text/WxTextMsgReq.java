package com.github.kotall.weixin.framework.msg.text;

import com.github.kotall.weixin.framework.core.WxRequest;
import com.github.kotall.weixin.framework.core.WxRequestWrapper;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

/**
 * 普通文本消息
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/4/29 0029 上午 9:43
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
