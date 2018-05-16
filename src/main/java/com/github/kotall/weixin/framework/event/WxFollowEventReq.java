package com.github.kotall.weixin.framework.event;

import com.github.kotall.weixin.framework.core.WxEventRequest;
import com.github.kotall.weixin.framework.core.WxRequest;
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
