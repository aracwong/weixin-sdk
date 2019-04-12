package com.github.aracwong.wxframework.mp.handler.event;

import com.github.aracwong.wxframework.common.constants.MpHandlerType;
import com.github.aracwong.wxframework.common.constants.MpMsgType;
import com.github.aracwong.wxframework.mp.core.filter.WxDelegateRequestMsgFilter;
import com.github.aracwong.wxframework.mp.core.request.WxRequest;
import com.github.aracwong.wxframework.mp.core.response.WxResponse;
import com.github.aracwong.wxframework.mp.msg.event.WxQrCodeEventReq;
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
public class DefaultWxQrCodeEventMsgHandler extends WxDelegateRequestMsgFilter<WxQrCodeEventReq> {


    @Override
    public String getHandlerKey() {
        return MpHandlerType.HANDLER_EVENT_QRCODE;
    }

    @Override
    public boolean support(WxRequest request) {
        String event = request.getParameter("//Event");
        String eventKey = request.getParameter("//EventKey");
        String ticket = request.getParameter("//Ticket");
        // 未关注时扫码或者 已关注时扫码
        boolean isQrEvent = MpMsgType.EVENT_SUBSCRIBE.equals(event) || MpMsgType.EVENT_SCAN.equals(event);
        if (MpMsgType.EVENT.equals(request.getMsgType())
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
