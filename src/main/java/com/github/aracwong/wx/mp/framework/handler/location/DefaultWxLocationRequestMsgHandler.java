package com.github.aracwong.wx.mp.framework.handler.location;

import com.github.aracwong.wx.mp.framework.constant.WxHandlerType;
import com.github.aracwong.wx.mp.framework.constant.WxMsgType;
import com.github.aracwong.wx.mp.framework.core.WxDelegateRequestMsgFilter;
import com.github.aracwong.wx.mp.framework.core.WxRequest;
import com.github.aracwong.wx.mp.framework.core.WxResponse;
import com.github.aracwong.wx.mp.framework.msg.location.WxLocationMsgReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxLocationRequestMsgHandler extends WxDelegateRequestMsgFilter<WxLocationMsgReq> {

    @Override
    public String getHandlerKey() {
        return WxHandlerType.HANDLER_LOCATION;
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
