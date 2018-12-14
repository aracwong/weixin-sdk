package com.github.aracwong.wx.mp.framework.handler.event;

import com.github.aracwong.wx.mp.framework.constant.WxHandlerType;
import com.github.aracwong.wx.mp.framework.constant.WxMsgType;
import com.github.aracwong.wx.mp.framework.core.WxDelegateRequestMsgFilter;
import com.github.aracwong.wx.mp.framework.core.WxRequest;
import com.github.aracwong.wx.mp.framework.core.WxResponse;
import com.github.aracwong.wx.mp.framework.event.WxLocationEventReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxLocationEventMsgHandler extends WxDelegateRequestMsgFilter<WxLocationEventReq> {

    @Override
    public String getHandlerKey() {
        return WxHandlerType.HANDLER_EVENT_LOCATION;
    }

    @Override
    public boolean support(WxRequest request) {
        if (WxMsgType.EVENT.equals(request.getMsgType())
                && WxMsgType.EVENT_LOCATION.equals(request.getParameter("//Event"))) {
            return true;
        }
        return false;
    }


    @Override
    public void handle(WxLocationEventReq request, WxResponse response) {
        log.info("接收到微信位置事件: {}", request);
    }
}
