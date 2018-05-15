package com.github.kotall.weixin.framework.handler.link;

import com.github.kotall.weixin.framework.constant.WxMsgType;
import com.github.kotall.weixin.framework.core.WxDelegateRequestFilter;
import com.github.kotall.weixin.framework.core.WxRequest;
import com.github.kotall.weixin.framework.core.WxResponse;
import com.github.kotall.weixin.framework.msg.link.WxLinkMsgReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/4/29 0029 下午 6:16
 */
@Slf4j
public class DefaultWxLinkRequestHandler extends WxDelegateRequestFilter<WxLinkMsgReq> {

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
