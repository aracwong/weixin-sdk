package com.github.kotall.weixin.framework.handler.event;

import com.github.kotall.weixin.framework.constant.WxMsgType;
import com.github.kotall.weixin.framework.core.WxDelegateRequestFilter;
import com.github.kotall.weixin.framework.core.WxRequest;
import com.github.kotall.weixin.framework.core.WxResponse;
import com.github.kotall.weixin.framework.event.WxLocationEventReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/4/29 0029 下午 6:41
 */
@Slf4j
public class DefaultWxLocationEventHandler extends WxDelegateRequestFilter<WxLocationEventReq> {

    @Override
    public boolean support(WxRequest request) {
        if (WxMsgType.EVENT.equals(request.getMsgType())
                && WxMsgType.EVENT_LOCATION.equals(request.getParameter("//Event"))) {
            return true;
        }
        return false;
    }


    @Override
    public void handle(WxLocationEventReq request, WxResponse response) {
        log.info("接收到微信位置事件: {}", request);
    }
}
