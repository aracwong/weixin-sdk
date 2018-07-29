package com.github.aracwong.weixin.framework.handler.event;

import com.github.aracwong.weixin.framework.constant.WxConstant;
import com.github.aracwong.weixin.framework.constant.WxMsgType;
import com.github.aracwong.weixin.framework.core.WxResponse;
import com.github.aracwong.weixin.framework.core.WxDelegateRequestFilter;
import com.github.aracwong.weixin.framework.core.WxRequest;
import com.github.aracwong.weixin.framework.event.WxLocationEventReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxLocationEventHandler extends WxDelegateRequestFilter<WxLocationEventReq> {

    @Override
    public String getHandlerKey() {
        return WxConstant.HANDLER_EVENT_LOCATION;
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
