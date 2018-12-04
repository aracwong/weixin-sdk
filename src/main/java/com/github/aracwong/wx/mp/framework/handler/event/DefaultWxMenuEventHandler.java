package com.github.aracwong.wx.mp.framework.handler.event;

import com.github.aracwong.wx.mp.framework.constant.WxHandlerType;
import com.github.aracwong.wx.mp.framework.constant.WxMsgType;
import com.github.aracwong.wx.mp.framework.core.WxDelegateRequestFilter;
import com.github.aracwong.wx.mp.framework.core.WxRequest;
import com.github.aracwong.wx.mp.framework.core.WxResponse;
import com.github.aracwong.wx.mp.framework.event.WxMenuEventReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxMenuEventHandler extends WxDelegateRequestFilter<WxMenuEventReq> {

    @Override
    public String getHandlerKey() {
        return WxHandlerType.HANDLER_EVENT_MENU_DEFAULT;
    }

    @Override
    public boolean support(WxRequest request) {
        String event = request.getParameter("//Event");
        boolean isMenuEvent = WxMsgType.EVENT_CLICK.equals(event) || WxMsgType.EVENT_VIEW.equals(event);
        if (WxMsgType.EVENT.equals(request.getMsgType()) && isMenuEvent) {
            return true;
        }
        return false;
    }

    @Override
    public void handle(WxMenuEventReq request, WxResponse response) {
        log.info("接收到微信菜单事件: {}", request);
    }
}
