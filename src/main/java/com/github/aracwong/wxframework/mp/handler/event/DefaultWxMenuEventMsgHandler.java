package com.github.aracwong.wxframework.mp.handler.event;

import com.github.aracwong.wxframework.common.constants.MpHandlerType;
import com.github.aracwong.wxframework.common.constants.MpMsgType;
import com.github.aracwong.wxframework.mp.core.filter.WxDelegateRequestMsgFilter;
import com.github.aracwong.wxframework.mp.core.request.WxRequest;
import com.github.aracwong.wxframework.mp.core.response.WxResponse;
import com.github.aracwong.wxframework.mp.msg.event.WxMenuEventReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxMenuEventMsgHandler extends WxDelegateRequestMsgFilter<WxMenuEventReq> {

    @Override
    public String getHandlerKey() {
        return MpHandlerType.HANDLER_EVENT_MENU_DEFAULT;
    }

    @Override
    public boolean support(WxRequest request) {
        String event = request.getParameter("//Event");
        boolean isMenuEvent = MpMsgType.EVENT_CLICK.equals(event) || MpMsgType.EVENT_VIEW.equals(event);
        if (MpMsgType.EVENT.equals(request.getMsgType()) && isMenuEvent) {
            return true;
        }
        return false;
    }

    @Override
    public void handle(WxMenuEventReq request, WxResponse response) {
        log.info("接收到微信菜单事件: {}", request);
    }
}
