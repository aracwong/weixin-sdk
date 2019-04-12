package com.github.aracwong.wxframework.mp.handler.event;

import com.github.aracwong.wxframework.common.constants.MpHandlerType;
import com.github.aracwong.wxframework.common.constants.MpMsgType;
import com.github.aracwong.wxframework.mp.core.filter.WxDelegateRequestMsgFilter;
import com.github.aracwong.wxframework.mp.core.request.WxRequest;
import com.github.aracwong.wxframework.mp.core.response.WxResponse;
import com.github.aracwong.wxframework.mp.msg.event.WxLocationEventReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxLocationEventMsgHandler extends WxDelegateRequestMsgFilter<WxLocationEventReq> {

    @Override
    public String getHandlerKey() {
        return MpHandlerType.HANDLER_EVENT_LOCATION;
    }

    @Override
    public boolean support(WxRequest request) {
        if (MpMsgType.EVENT.equals(request.getMsgType())
                && MpMsgType.EVENT_LOCATION.equals(request.getParameter("//Event"))) {
            return true;
        }
        return false;
    }


    @Override
    public void handle(WxLocationEventReq request, WxResponse response) {
        log.info("接收到微信位置事件: {}", request);
    }
}
