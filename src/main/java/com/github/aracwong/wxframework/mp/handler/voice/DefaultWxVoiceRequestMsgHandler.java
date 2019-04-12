package com.github.aracwong.wxframework.mp.handler.voice;

import com.github.aracwong.wxframework.common.constants.MpHandlerType;
import com.github.aracwong.wxframework.common.constants.MpMsgType;
import com.github.aracwong.wxframework.mp.core.filter.WxDelegateRequestMsgFilter;
import com.github.aracwong.wxframework.mp.core.request.WxRequest;
import com.github.aracwong.wxframework.mp.core.response.WxResponse;
import com.github.aracwong.wxframework.mp.msg.voice.WxVoiceMsgReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxVoiceRequestMsgHandler extends WxDelegateRequestMsgFilter<WxVoiceMsgReq> {


    @Override
    public String getHandlerKey() {
        return MpHandlerType.HANDLER_VOICE;
    }

    @Override
    public boolean support(WxRequest request) {
        if (MpMsgType.VOICE.equals(request.getMsgType())) {
           return true;
        }
        return false;
    }

    @Override
    public void handle(WxVoiceMsgReq request, WxResponse response) {
        log.info("接收到微信语音消息：{}", request);
    }
}
