package com.github.aracwong.wx.mp.framework.core;

import com.github.aracwong.wx.mp.framework.handler.event.*;
import com.github.aracwong.wx.mp.framework.handler.file.DefaultWxFileRequestHandler;
import com.github.aracwong.wx.mp.framework.handler.image.DefaultWxImageRequestHandler;
import com.github.aracwong.wx.mp.framework.handler.link.DefaultWxLinkRequestHandler;
import com.github.aracwong.wx.mp.framework.handler.location.DefaultWxLocationRequestHandler;
import com.github.aracwong.wx.mp.framework.handler.text.DefaultWxTextRequestHandler;
import com.github.aracwong.wx.mp.framework.handler.video.DefaultWxVideoRequestHandler;
import com.github.aracwong.wx.mp.framework.handler.voice.DefaultWxVoiceRequestHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zpwang
 * @version 1.0.0
 */
public class WxMsgHandlerRegistration {

    public static Map<String, WxDelegateRequestFilter> handlerFiltersMapping = new ConcurrentHashMap<>();

    public WxMsgHandlerRegistration() {
        init();
    }

    private void init() {
        registerHandler(new DefaultWxTextRequestHandler());
        registerHandler(new DefaultWxImageRequestHandler());
        registerHandler(new DefaultWxVoiceRequestHandler());
        registerHandler(new DefaultWxVideoRequestHandler());
        registerHandler(new DefaultWxLinkRequestHandler());
        registerHandler(new DefaultWxLocationRequestHandler());
        registerHandler(new DefaultWxFileRequestHandler());

        registerHandler(new DefaultWxFollowEventHandler());
        registerHandler(new DefaultWxQrCodeEventHandler());
        registerHandler(new DefaultWxLocationEventHandler());
        registerHandler(new DefaultWxMenuEventHandler());
        registerHandler(new DefaultWxScanCodeEventHandler());
        registerHandler(new DefaultWxPicPhotoEventHandler());
        registerHandler(new DefaultWxLocationSelectEventHandler());
    }

    public WxMsgHandlerRegistration registerHandler(WxDelegateRequestFilter handler) {
        handlerFiltersMapping.put(handler.getHandlerKey(), handler);
        return this;
    }

    List<WxRequestFilter> getHandlerFilters() {
        List<WxRequestFilter> handlerFilters = new ArrayList<>();
        handlerFiltersMapping.forEach((key, value) -> handlerFilters.add(value));
        return handlerFilters;
    }


}
