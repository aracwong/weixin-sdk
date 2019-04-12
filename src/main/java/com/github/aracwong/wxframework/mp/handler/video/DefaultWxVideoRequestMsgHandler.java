package com.github.aracwong.wxframework.mp.handler.video;

import com.github.aracwong.wxframework.common.constants.MpHandlerType;
import com.github.aracwong.wxframework.common.constants.MpMsgType;
import com.github.aracwong.wxframework.mp.core.filter.WxDelegateRequestMsgFilter;
import com.github.aracwong.wxframework.mp.core.request.WxRequest;
import com.github.aracwong.wxframework.mp.core.response.WxResponse;
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
        return MpHandlerType.HANDLER_VIDEO;
    }

    @Override
    public boolean support(WxRequest request) {
        if (MpMsgType.VIDEO.equals(request.getMsgType())) {
           return true;
        }
        return false;
    }

    @Override
    public void handle(WxVideoMsgReq request, WxResponse response) {
        log.info("接收到微信视频消息：{}", request);
    }
}
