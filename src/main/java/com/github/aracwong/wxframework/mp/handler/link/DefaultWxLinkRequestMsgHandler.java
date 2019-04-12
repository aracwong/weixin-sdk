package com.github.aracwong.wxframework.mp.handler.link;

import com.github.aracwong.wxframework.common.constants.MpHandlerType;
import com.github.aracwong.wxframework.common.constants.MpMsgType;
import com.github.aracwong.wxframework.mp.core.filter.WxDelegateRequestMsgFilter;
import com.github.aracwong.wxframework.mp.core.request.WxRequest;
import com.github.aracwong.wxframework.mp.core.response.WxResponse;
import com.github.aracwong.wxframework.mp.msg.link.WxLinkMsgReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxLinkRequestMsgHandler extends WxDelegateRequestMsgFilter<WxLinkMsgReq> {

    @Override
    public String getHandlerKey() {
        return MpHandlerType.HANDLER_LINK;
    }

    @Override
    public boolean support(WxRequest request) {
        if (MpMsgType.LINK.equals(request.getMsgType())) {
            return true;
        }
        return false;
    }

    @Override
    public void handle(WxLinkMsgReq request, WxResponse response) {
        log.info("接收到微信链接消息：{}", request);
    }
}
