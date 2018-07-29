package com.github.aracwong.weixin.framework.handler.location;

import com.github.aracwong.weixin.framework.constant.WxConstant;
import com.github.aracwong.weixin.framework.constant.WxMsgType;
import com.github.aracwong.weixin.framework.core.WxDelegateRequestFilter;
import com.github.aracwong.weixin.framework.core.WxRequest;
import com.github.aracwong.weixin.framework.core.WxResponse;
import com.github.aracwong.weixin.framework.msg.location.WxLocationMsgReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxLocationRequestHandler extends WxDelegateRequestFilter<WxLocationMsgReq> {

    @Override
    public String getHandlerKey() {
        return WxConstant.HANDLER_LOCATION;
    }

    @Override
    public boolean support(WxRequest request) {
        if (WxMsgType.LOCATION.equals(request.getMsgType())) {
            return true;
        }
        return false;
    }

    @Override
    public void handle(WxLocationMsgReq request, WxResponse response) {
        log.info("接收到微信位置消息：{}", request);
    }
}
