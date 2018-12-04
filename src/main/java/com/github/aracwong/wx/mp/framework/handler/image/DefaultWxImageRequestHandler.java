package com.github.aracwong.wx.mp.framework.handler.image;

import com.github.aracwong.wx.mp.framework.constant.WxHandlerType;
import com.github.aracwong.wx.mp.framework.constant.WxMsgType;
import com.github.aracwong.wx.mp.framework.core.WxDelegateRequestFilter;
import com.github.aracwong.wx.mp.framework.core.WxRequest;
import com.github.aracwong.wx.mp.framework.core.WxResponse;
import com.github.aracwong.wx.mp.framework.msg.image.WxImageMsgReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxImageRequestHandler extends WxDelegateRequestFilter<WxImageMsgReq> {

    @Override
    public String getHandlerKey() {
        return WxHandlerType.HANDLER_IMAGE;
    }

    @Override
    public boolean support(WxRequest request) {
        if (WxMsgType.IMAGE.equals(request.getMsgType())) {
            return true;
        }
        return false;
    }


    @Override
    public void handle(WxImageMsgReq request, WxResponse response) {
        log.info("接收到微信图像消息：{}", request);
    }
}
