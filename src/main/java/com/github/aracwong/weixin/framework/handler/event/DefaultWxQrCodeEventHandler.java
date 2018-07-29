package com.github.aracwong.weixin.framework.handler.event;

import com.github.aracwong.weixin.framework.constant.WxHandlerType;
import com.github.aracwong.weixin.framework.constant.WxMsgType;
import com.github.aracwong.weixin.framework.core.WxDelegateRequestFilter;
import com.github.aracwong.weixin.framework.core.WxRequest;
import com.github.aracwong.weixin.framework.core.WxResponse;
import com.github.aracwong.weixin.framework.event.WxQrCodeEventReq;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;

/**
 * 扫描带参数二维码事件
 * 1. 未关注时 扫码
 * 2. 已关注时 扫码
 *
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxQrCodeEventHandler extends WxDelegateRequestFilter<WxQrCodeEventReq> {


    @Override
    public String getHandlerKey() {
        return WxHandlerType.HANDLER_EVENT_QRCODE;
    }

    @Override
    public boolean support(WxRequest request) {
        String event = request.getParameter("//Event");
        String eventKey = request.getParameter("//EventKey");
        String ticket = request.getParameter("//Ticket");
        // 未关注时扫码或者 已关注时扫码
        boolean isQrEvent = WxMsgType.EVENT_SUBSCRIBE.equals(event) || WxMsgType.EVENT_SCAN.equals(event);
        if (WxMsgType.EVENT.equals(request.getMsgType())
                && isQrEvent
                && !Strings.isNullOrEmpty(eventKey)
                && !Strings.isNullOrEmpty(ticket)) {
            return true;
        }
        return false;
    }


    @Override
    public void handle(WxQrCodeEventReq request, WxResponse response) {
        log.info("接收到微信扫描二维码事件: {}", request);
    }
}
