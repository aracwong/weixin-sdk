package com.github.kotall.weixin.framework.handler.image;

import com.github.kotall.weixin.framework.constant.WxMsgType;
import com.github.kotall.weixin.framework.core.WxDelegateRequestFilter;
import com.github.kotall.weixin.framework.core.WxRequest;
import com.github.kotall.weixin.framework.core.WxResponse;
import com.github.kotall.weixin.framework.msg.image.WxImageMsgReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/4/29 0029 下午 6:20
 */
@Slf4j
public class DefaultWxImageRequestHandler extends WxDelegateRequestFilter<WxImageMsgReq> {

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
