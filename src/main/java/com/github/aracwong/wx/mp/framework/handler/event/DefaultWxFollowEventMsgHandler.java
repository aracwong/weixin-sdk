package com.github.aracwong.wx.mp.framework.handler.event;

import com.github.aracwong.wx.mp.framework.constant.WxHandlerType;
import com.github.aracwong.wx.mp.framework.constant.WxMsgType;
import com.github.aracwong.wx.mp.framework.core.WxDelegateRequestMsgFilter;
import com.github.aracwong.wx.mp.framework.core.WxRequest;
import com.github.aracwong.wx.mp.framework.core.WxResponse;
import com.github.aracwong.wx.mp.framework.event.WxFollowEventReq;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;

/**
 * 关注/取消关注 事件处理
 *
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxFollowEventMsgHandler extends WxDelegateRequestMsgFilter<WxFollowEventReq> {

    @Override
    public String getHandlerKey() {
        return WxHandlerType.HANDLER_EVENT_FOLLOW;
    }

    @Override
    public boolean support(WxRequest request) {
        String event = request.getParameter("//Event");
        String eventKey = request.getParameter("//EventKey");
        boolean isSubscribeOrUnSubscribeEvent = WxMsgType.EVENT_SUBSCRIBE.equals(event) || WxMsgType.EVENT_UNSUBSCRIBE.equals(event);
        // 2018-05-01 通过点击朋友分享的公众号，会带有EventKey 值为空
        if (WxMsgType.EVENT.equals(request.getMsgType())
                && isSubscribeOrUnSubscribeEvent
                && Strings.isNullOrEmpty(eventKey)) {
            return true;
        }
        return false;
    }

    @Override
    public void handle(WxFollowEventReq request, WxResponse response) {
        log.info("微信关注/取消关注事件默认处理器");
    }
}
