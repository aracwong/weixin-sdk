package com.github.kotall.weixin.framework.handler.text;

import com.github.kotall.weixin.framework.constant.WxMsgType;
import com.github.kotall.weixin.framework.core.WxDelegateRequestFilter;
import com.github.kotall.weixin.framework.core.WxRequest;
import com.github.kotall.weixin.framework.core.WxResponse;
import com.github.kotall.weixin.framework.msg.text.WxTextMsgReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxTextRequestHandler extends WxDelegateRequestFilter<WxTextMsgReq> {

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
