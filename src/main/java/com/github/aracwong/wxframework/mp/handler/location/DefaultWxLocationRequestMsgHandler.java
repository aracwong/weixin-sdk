package com.github.aracwong.wxframework.mp.handler.location;

import com.github.aracwong.wxframework.common.constants.MpHandlerType;
import com.github.aracwong.wxframework.common.constants.MpMsgType;
import com.github.aracwong.wxframework.mp.core.filter.WxDelegateRequestMsgFilter;
import com.github.aracwong.wxframework.mp.core.request.WxRequest;
import com.github.aracwong.wxframework.mp.core.response.WxResponse;
import com.github.aracwong.wxframework.mp.msg.location.WxLocationMsgReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxLocationRequestMsgHandler extends WxDelegateRequestMsgFilter<WxLocationMsgReq> {

    @Override
    public String getHandlerKey() {
        return MpHandlerType.HANDLER_LOCATION;
    }

    @Override
    public boolean support(WxRequest request) {
        if (MpMsgType.LOCATION.equals(request.getMsgType())) {
            return true;
        }
        return false;
    }

    @Override
    public void handle(WxLocationMsgReq request, WxResponse response) {
        log.info("接收到微信位置消息：{}", request);
    }
}
