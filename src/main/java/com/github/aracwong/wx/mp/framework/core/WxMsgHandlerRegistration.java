package com.github.aracwong.wx.mp.framework.core;

import com.github.aracwong.wx.mp.framework.handler.event.*;
import com.github.aracwong.wx.mp.framework.handler.file.DefaultWxFileRequestMsgHandler;
import com.github.aracwong.wx.mp.framework.handler.image.DefaultWxImageRequestMsgHandler;
import com.github.aracwong.wx.mp.framework.handler.link.DefaultWxLinkRequestMsgHandler;
import com.github.aracwong.wx.mp.framework.handler.location.DefaultWxLocationRequestMsgHandler;
import com.github.aracwong.wx.mp.framework.handler.text.DefaultWxTextRequestMsgHandler;
import com.github.aracwong.wx.mp.framework.handler.video.DefaultWxVideoRequestMsgHandler;
import com.github.aracwong.wx.mp.framework.handler.voice.DefaultWxVoiceRequestMsgHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zpwang
 * @version 1.0.0
 */
public class WxMsgHandlerRegistration {

    public static Map<String, WxDelegateRequestMsgFilter> handlerFiltersMapping = new ConcurrentHashMap<>();

    public WxMsgHandlerRegistration() {
        init();
    }

    private void init() {
        registerHandler(new DefaultWxTextRequestMsgHandler());
        registerHandler(new DefaultWxImageRequestMsgHandler());
        registerHandler(new DefaultWxVoiceRequestMsgHandler());
        registerHandler(new DefaultWxVideoRequestMsgHandler());
        registerHandler(new DefaultWxLinkRequestMsgHandler());
        registerHandler(new DefaultWxLocationRequestMsgHandler());
        registerHandler(new DefaultWxFileRequestMsgHandler());

        registerHandler(new DefaultWxFollowEventMsgHandler());
        registerHandler(new DefaultWxQrCodeEventMsgHandler());
        registerHandler(new DefaultWxLocationEventMsgHandler());
        registerHandler(new DefaultWxMenuEventMsgHandler());
        registerHandler(new DefaultWxScanCodeEventMsgHandler());
        registerHandler(new DefaultWxPicPhotoEventMsgHandler());
        registerHandler(new DefaultWxLocationSelectEventMsgHandler());
    }

    public WxMsgHandlerRegistration registerHandler(WxDelegateRequestMsgFilter handler) {
        handlerFiltersMapping.put(handler.getHandlerKey(), handler);
        return this;
    }

    List<WxRequestFilter> getHandlerFilters() {
        List<WxRequestFilter> handlerFilters = new ArrayList<>();
        handlerFiltersMapping.forEach((key, value) -> handlerFilters.add(value));
        return handlerFilters;
    }


}
