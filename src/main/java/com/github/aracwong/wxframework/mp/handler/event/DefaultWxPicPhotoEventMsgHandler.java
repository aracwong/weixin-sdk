package com.github.aracwong.wxframework.mp.handler.event;

import com.github.aracwong.wxframework.common.constants.MpHandlerType;
import com.github.aracwong.wxframework.common.constants.MpMsgType;
import com.github.aracwong.wxframework.mp.core.filter.WxDelegateRequestMsgFilter;
import com.github.aracwong.wxframework.mp.core.request.WxRequest;
import com.github.aracwong.wxframework.mp.core.response.WxResponse;
import com.github.aracwong.wxframework.mp.msg.event.WxPicSysPhotoEventReq;
import lombok.extern.slf4j.Slf4j;

/**
 * 1. 弹出系统拍照发图的事件推送
 * 2. 弹出拍照或者相册发图的事件推送
 * 3. 弹出微信相册发图器的事件推送
 *
 * @author zpwang
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxPicPhotoEventMsgHandler extends WxDelegateRequestMsgFilter<WxPicSysPhotoEventReq> {

    @Override
    public String getHandlerKey() {
        return MpHandlerType.HANDLER_EVENT_MENU_PIC_PHOTO;
    }

    @Override
    public boolean support(WxRequest request) {
        String msgType = request.getMsgType();
        String event = request.getParameter("//Event");
        boolean isPicSysPhotoEvent = MpMsgType.EVENT_PIC_SYSPHOTO.equals(event)
                || MpMsgType.EVENT_PIC_PHOTO_OR_ALBUM.equals(event)
                || MpMsgType.EVENT_PIC_WEIXIN.equals(event);
        if (MpMsgType.EVENT.equals(msgType) && isPicSysPhotoEvent) {
            return true;
        }
        return false;
    }


    @Override
    public void handle(WxPicSysPhotoEventReq request, WxResponse response) {
        log.info("弹出系统拍照发图(或系统相册发图或者微信相册发图)的事件推送: {}", request);
    }


}
