package com.github.aracwong.weixin.framework.handler.voice;

import com.github.aracwong.weixin.framework.constant.WxMsgType;
import com.github.aracwong.weixin.framework.core.WxDelegateRequestFilter;
import com.github.aracwong.weixin.framework.core.WxRequest;
import com.github.aracwong.weixin.framework.core.WxResponse;
import com.github.aracwong.weixin.framework.msg.voice.WxVoiceMsgReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxVoiceRequestHandler extends WxDelegateRequestFilter<WxVoiceMsgReq> {


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
