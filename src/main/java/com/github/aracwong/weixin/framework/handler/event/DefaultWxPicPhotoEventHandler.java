package com.github.aracwong.weixin.framework.handler.event;

import com.github.aracwong.weixin.framework.constant.WxConstant;
import com.github.aracwong.weixin.framework.constant.WxMsgType;
import com.github.aracwong.weixin.framework.core.WxDelegateRequestFilter;
import com.github.aracwong.weixin.framework.core.WxRequest;
import com.github.aracwong.weixin.framework.core.WxResponse;
import com.github.aracwong.weixin.framework.event.WxPicSysPhotoEventReq;
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
public class DefaultWxPicPhotoEventHandler extends WxDelegateRequestFilter<WxPicSysPhotoEventReq> {

    @Override
    public String getHandlerKey() {
        return WxConstant.HANDLER_EVENT_MENU_PIC_PHOTO;
    }

    @Override
    public boolean support(WxRequest request) {
        String msgType = request.getMsgType();
        String event = request.getParameter("//Event");
        boolean isPicSysPhotoEvent = WxMsgType.EVENT_PIC_SYSPHOTO.equals(event)
                || WxMsgType.EVENT_PIC_PHOTO_OR_ALBUM.equals(event)
                || WxMsgType.EVENT_PIC_WEIXIN.equals(event);
        if (WxMsgType.EVENT.equals(msgType) && isPicSysPhotoEvent) {
            return true;
        }
        return false;
    }


    @Override
    public void handle(WxPicSysPhotoEventReq request, WxResponse response) {
        log.info("弹出系统拍照发图(或系统相册发图或者微信相册发图)的事件推送: {}", request);
    }


}
