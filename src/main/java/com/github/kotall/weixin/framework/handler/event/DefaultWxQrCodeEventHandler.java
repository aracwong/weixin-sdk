package com.github.kotall.weixin.framework.handler.event;

import com.google.common.base.Strings;
import com.github.kotall.weixin.framework.constant.WxMsgType;
import com.github.kotall.weixin.framework.core.WxDelegateRequestFilter;
import com.github.kotall.weixin.framework.core.WxRequest;
import com.github.kotall.weixin.framework.core.WxResponse;
import com.github.kotall.weixin.framework.event.WxQrCodeEventReq;
import lombok.extern.slf4j.Slf4j;

/**
 * 扫描带参数二维码事件
 * 1. 未关注时 扫码
 * 2. 已关注时 扫码
 *
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/4/29 0029 下午 7:14
 */
@Slf4j
public class DefaultWxQrCodeEventHandler extends WxDelegateRequestFilter<WxQrCodeEventReq> {


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
