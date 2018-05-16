package com.github.aracwong.weixin.framework.handler.video;

import com.github.aracwong.weixin.framework.constant.WxMsgType;
import com.github.aracwong.weixin.framework.core.WxDelegateRequestFilter;
import com.github.aracwong.weixin.framework.core.WxRequest;
import com.github.aracwong.weixin.framework.core.WxResponse;
import com.github.aracwong.weixin.framework.msg.video.WxVideoMsgReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxVideoRequestHandler extends WxDelegateRequestFilter<WxVideoMsgReq> {


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
