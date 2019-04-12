package com.github.aracwong.wxframework.mp.handler.video;

import com.github.aracwong.wxframework.mp.constant.WxHandlerType;
import com.github.aracwong.wxframework.mp.constant.WxMsgType;
import com.github.aracwong.wxframework.mp.core.WxDelegateRequestMsgFilter;
import com.github.aracwong.wxframework.mp.core.WxRequest;
import com.github.aracwong.wxframework.mp.core.WxResponse;
import com.github.aracwong.wxframework.mp.msg.video.WxVideoMsgReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxVideoRequestMsgHandler extends WxDelegateRequestMsgFilter<WxVideoMsgReq> {

    @Override
    public String getHandlerKey() {
        return WxHandlerType.HANDLER_VIDEO;
    }

    @Override
    public boolean support(WxRequest request) {
        if (WxMsgType.VIDEO.equals(request.getMsgType())) {
           return true;
        }
        return false;
    }

    @Override
    public void handle(WxVideoMsgReq request, WxResponse response) {
        log.info("接收到微信视频消息：{}", request);
    }
}
