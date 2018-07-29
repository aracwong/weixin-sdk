package com.github.aracwong.weixin.framework.handler.link;

import com.github.aracwong.weixin.framework.constant.WxConstant;
import com.github.aracwong.weixin.framework.msg.link.WxLinkMsgReq;
import com.github.aracwong.weixin.framework.constant.WxMsgType;
import com.github.aracwong.weixin.framework.core.WxDelegateRequestFilter;
import com.github.aracwong.weixin.framework.core.WxRequest;
import com.github.aracwong.weixin.framework.core.WxResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxLinkRequestHandler extends WxDelegateRequestFilter<WxLinkMsgReq> {

    @Override
    public String getHandlerKey() {
        return WxConstant.HANDLER_LINK;
    }

    @Override
    public boolean support(WxRequest request) {
        if (WxMsgType.LINK.equals(request.getMsgType())) {
            return true;
        }
        return false;
    }

    @Override
    public void handle(WxLinkMsgReq request, WxResponse response) {
        log.info("接收到微信链接消息：{}", request);
    }
}
