package com.github.aracwong.wxframework.mp.handler.event;

import com.github.aracwong.wxframework.mp.constant.WxHandlerType;
import com.github.aracwong.wxframework.mp.constant.WxMsgType;
import com.github.aracwong.wxframework.mp.core.WxDelegateRequestMsgFilter;
import com.github.aracwong.wxframework.mp.core.WxRequest;
import com.github.aracwong.wxframework.mp.core.WxResponse;
import com.github.aracwong.wxframework.mp.event.WxLocationSelectEventReq;
import lombok.extern.slf4j.Slf4j;

/**
 * 弹出地理位置选择器的事件推送
 *
 * @author zpwang
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxLocationSelectEventMsgHandler extends WxDelegateRequestMsgFilter<WxLocationSelectEventReq> {

    @Override
    public String getHandlerKey() {
        return WxHandlerType.HANDLER_EVENT_MENU_LOCATION_SELECT;
    }

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
