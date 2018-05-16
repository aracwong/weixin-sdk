package com.github.aracwong.weixin.framework.handler.event;

import com.github.aracwong.weixin.framework.constant.WxMsgType;
import com.github.aracwong.weixin.framework.core.WxDelegateRequestFilter;
import com.github.aracwong.weixin.framework.core.WxRequest;
import com.github.aracwong.weixin.framework.core.WxResponse;
import com.github.aracwong.weixin.framework.event.WxLocationSelectEventReq;
import lombok.extern.slf4j.Slf4j;

/**
 * 弹出地理位置选择器的事件推送
 *
 * @author zpwang
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxLocationSelectEventHandler extends WxDelegateRequestFilter<WxLocationSelectEventReq> {

    @Override
    public boolean support(WxRequest request) {
        String event = request.getParameter("//Event");
        boolean isLocationSelectEvent = WxMsgType.EVENT_LOCATION_SELECT.equals(event);
        if (WxMsgType.EVENT.equals(request.getMsgType())
                && isLocationSelectEvent) {
            return true;
        }
        return false;
    }


    @Override
    public void handle(WxLocationSelectEventReq request, WxResponse response) {
        log.info("弹出地理位置选择器的事件推送: {}", request);
    }


}
