package com.github.aracwong.weixin.framework.handler.text;

import com.github.aracwong.weixin.framework.constant.WxHandlerType;
import com.github.aracwong.weixin.framework.constant.WxMsgType;
import com.github.aracwong.weixin.framework.core.WxDelegateRequestFilter;
import com.github.aracwong.weixin.framework.core.WxRequest;
import com.github.aracwong.weixin.framework.core.WxResponse;
import com.github.aracwong.weixin.framework.msg.text.WxTextMsgReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxTextRequestHandler extends WxDelegateRequestFilter<WxTextMsgReq> {

    @Override
    public String getHandlerKey() {
        return WxHandlerType.HANDLER_TEXT;
    }

    @Override
    public boolean support(WxRequest request) {
        if (WxMsgType.TEXT.equals(request.getMsgType())) {
            return true;
        }
        return false;
    }

    @Override
    public void handle(WxTextMsgReq request, WxResponse response) {
        log.info("接收到微信文本消息：{}", request);
    }

}
