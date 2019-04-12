package com.github.aracwong.wxframework.mp.handler.event;

import com.github.aracwong.wxframework.common.constants.MpHandlerType;
import com.github.aracwong.wxframework.common.constants.MpMsgType;
import com.github.aracwong.wxframework.mp.core.filter.WxDelegateRequestMsgFilter;
import com.github.aracwong.wxframework.mp.core.request.WxRequest;
import com.github.aracwong.wxframework.mp.core.response.WxResponse;
import com.github.aracwong.wxframework.mp.msg.event.WxScanCodeEventReq;
import lombok.extern.slf4j.Slf4j;

/**
 * 扫描推事件/扫描推且弹出 "消息接受中" 事件
 *
 * 场景: 微信自定义菜单-扫码菜单 扫码后推送事件
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxScanCodeEventMsgHandler extends WxDelegateRequestMsgFilter<WxScanCodeEventReq> {

    @Override
    public String getHandlerKey() {
        return MpHandlerType.HANDLER_EVENT_MENU_SCANCODE_PUSH;
    }

    @Override
    public boolean support(WxRequest request) {
        String msgType = request.getMsgType();
        String event = request.getParameter("//Event");
        boolean isScanCodePushEvent = MpMsgType.EVENT_SCANCODE_PUSH.equals(event) || MpMsgType.EVENT_SCANCODE_PUSH_WAITMSG.equals(event);
        if (MpMsgType.EVENT.equals(msgType)
                && isScanCodePushEvent) {
           return true;
        }
        return false;
    }


    @Override
    public void handle(WxScanCodeEventReq request, WxResponse response) {
        log.info("自定义菜单扫描推事件: {}", request);
    }


}
