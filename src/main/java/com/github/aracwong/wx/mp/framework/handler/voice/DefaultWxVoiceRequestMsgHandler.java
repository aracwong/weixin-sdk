package com.github.aracwong.wx.mp.framework.handler.voice;

import com.github.aracwong.wx.mp.framework.constant.WxHandlerType;
import com.github.aracwong.wx.mp.framework.constant.WxMsgType;
import com.github.aracwong.wx.mp.framework.core.WxDelegateRequestMsgFilter;
import com.github.aracwong.wx.mp.framework.core.WxRequest;
import com.github.aracwong.wx.mp.framework.core.WxResponse;
import com.github.aracwong.wx.mp.framework.msg.voice.WxVoiceMsgReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxVoiceRequestMsgHandler extends WxDelegateRequestMsgFilter<WxVoiceMsgReq> {


    @Override
    public String getHandlerKey() {
        return WxHandlerType.HANDLER_VOICE;
    }

    @Override
    public boolean support(WxRequest request) {
        if (WxMsgType.VOICE.equals(request.getMsgType())) {
           return true;
        }
        return false;
    }

    @Override
    public void handle(WxVoiceMsgReq request, WxResponse response) {
        log.info("接收到微信语音消息：{}", request);
    }
}
