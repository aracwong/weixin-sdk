package com.github.kotall.weixin.framework.handler.event;

import com.github.kotall.weixin.framework.constant.WxMsgType;
import com.github.kotall.weixin.framework.core.WxDelegateRequestFilter;
import com.github.kotall.weixin.framework.core.WxRequest;
import com.github.kotall.weixin.framework.core.WxResponse;
import com.github.kotall.weixin.framework.event.WxMenuEventReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/4/29 0029 下午 7:12
 */
@Slf4j
public class DefaultWxMenuEventHandler extends WxDelegateRequestFilter<WxMenuEventReq> {

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
