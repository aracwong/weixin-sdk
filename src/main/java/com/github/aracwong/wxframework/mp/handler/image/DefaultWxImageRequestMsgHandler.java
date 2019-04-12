package com.github.aracwong.wxframework.mp.handler.image;

import com.github.aracwong.wxframework.common.constants.MpHandlerType;
import com.github.aracwong.wxframework.common.constants.MpMsgType;
import com.github.aracwong.wxframework.mp.core.filter.WxDelegateRequestMsgFilter;
import com.github.aracwong.wxframework.mp.core.request.WxRequest;
import com.github.aracwong.wxframework.mp.core.response.WxResponse;
import com.github.aracwong.wxframework.mp.msg.image.WxImageMsgReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxImageRequestMsgHandler extends WxDelegateRequestMsgFilter<WxImageMsgReq> {

    @Override
    public String getHandlerKey() {
        return MpHandlerType.HANDLER_IMAGE;
    }

    @Override
    public boolean support(WxRequest request) {
        if (MpMsgType.IMAGE.equals(request.getMsgType())) {
            return true;
        }
        return false;
    }


    @Override
    public void handle(WxImageMsgReq request, WxResponse response) {
        log.info("接收到微信图像消息：{}", request);
    }
}
