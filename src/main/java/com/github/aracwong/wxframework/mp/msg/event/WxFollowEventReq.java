package com.github.aracwong.wxframework.mp.msg.event;

import com.github.aracwong.wxframework.mp.core.request.WxEventRequest;
import com.github.aracwong.wxframework.mp.core.request.WxRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

/**
 * 关注或取消关注事件
 *
 * @author aracwong
 * @version 1.0.0
 */
@Data
@ToString(callSuper = true)
@XStreamAlias("xml")
public class WxFollowEventReq extends WxEventRequest {
    public WxFollowEventReq(WxRequest wxRequest) {
        super(wxRequest);
    }

}
