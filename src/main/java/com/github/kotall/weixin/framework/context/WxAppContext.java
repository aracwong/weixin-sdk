package com.github.kotall.weixin.framework.context;

import com.github.kotall.weixin.dto.accesstoken.WxAccessTokenResp;
import com.github.kotall.weixin.framework.annotation.WxHandler;
import com.github.kotall.weixin.framework.constant.WxConstant;
import com.github.kotall.weixin.framework.constant.WxMsgType;
import com.github.kotall.weixin.framework.core.WxRequestFilter;
import com.github.kotall.weixin.framework.handler.event.*;
import com.github.kotall.weixin.framework.handler.file.DefaultWxFileRequestHandler;
import com.github.kotall.weixin.framework.handler.image.DefaultWxImageRequestHandler;
import com.github.kotall.weixin.framework.handler.link.DefaultWxLinkRequestHandler;
import com.github.kotall.weixin.framework.handler.location.DefaultWxLocationRequestHandler;
import com.github.kotall.weixin.framework.handler.text.DefaultWxTextRequestHandler;
import com.github.kotall.weixin.framework.handler.video.DefaultWxVideoRequestHandler;
import com.github.kotall.weixin.framework.handler.voice.DefaultWxVoiceRequestHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zpwang
 * @version 1.0.0
 */
public class WxAppContext {

    /**
     * key: appId
     * value: WxAccessToken
     */
    private static Map<String, WxAccessTokenResp> wxAccessToken = new ConcurrentHashMap<>();

    private static Map<String, WxRequestFilter> defaultHandlerMapping = new ConcurrentHashMap<>();

    static {
        defaultHandlerMapping.put(WxConstant.HANDLER_TEXT, new DefaultWxTextRequestHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_IMAGE, new DefaultWxImageRequestHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_VOICE, new DefaultWxVoiceRequestHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_VIDEO, new DefaultWxVideoRequestHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_LINK, new DefaultWxLinkRequestHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_LOCATION, new DefaultWxLocationRequestHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_FILE, new DefaultWxFileRequestHandler());

        defaultHandlerMapping.put(WxConstant.HANDLER_FOLLOW_EVENT, new DefaultWxFollowEventHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_QRCODE_EVENT, new DefaultWxQrCodeEventHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_LOCCATION_EVENT, new DefaultWxLocationEventHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_MENU_DEFAULT_EVENT, new DefaultWxMenuEventHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_MENU_SCANCODE_PUSH_EVENT, new DefaultWxScanCodeEventHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_MENU_PIC_PHOTO_EVENT, new DefaultWxPicPhotoEventHandler());
        defaultHandlerMapping.put(WxConstant.HANDLER_MENU_LOCATION_SELECT_EVENT, new DefaultWxLocationSelectEventHandler());
    }

    public static List<WxRequestFilter> getWxMsgHandlers() {
        List<WxRequestFilter> handlerList = new ArrayList<>();
        defaultHandlerMapping.forEach((key, value) -> handlerList.add(value));
        return handlerList;
    }

    /**
     * 根据 appId 获取 WxAccessToken
     *
     * @param appId
     *        appId
     * @return
     *     WxAccessTokenResp
     */
    public static WxAccessTokenResp getWxAccessToken(String appId) {
        return wxAccessToken.get(appId);
    }

    /**
     * 设置 WxAccessToken 以 WxAccessToken 中appId为key
     *
     * @param appId
     *        appId
     * @param accessToken
     *        WxAccessTokenResp
     */
    public static void setWxAccessToken(String appId, WxAccessTokenResp accessToken) {
        wxAccessToken.put(appId, accessToken);
    }

    /**
     * 注册自定义 Handler
     *
     * @param handlers
     *        handler mapping
     */
    public void registerHandler(Map<String, Object> handlers) {
        Object[] beansWithHandlerAnnotation = handlers.values().toArray();
        for (Object object : beansWithHandlerAnnotation) {
            WxRequestFilter handler = (WxRequestFilter) object;
            WxHandler wxHandler = handler.getClass().getAnnotation(WxHandler.class);
            String msgType = wxHandler.forMsgType();
            switch (msgType) {
                case WxMsgType.TEXT:
                    if (handler instanceof DefaultWxTextRequestHandler) {
                        defaultHandlerMapping.put(WxConstant.HANDLER_TEXT, handler);
                    }
                    break;
                case WxMsgType.IMAGE:
                    if (handler instanceof DefaultWxImageRequestHandler) {
                        defaultHandlerMapping.put(WxConstant.HANDLER_IMAGE, handler);
                    }
                    break;
                case WxMsgType.VOICE:
                    if (handler instanceof DefaultWxVoiceRequestHandler) {
                        defaultHandlerMapping.put(WxConstant.HANDLER_VOICE, handler);
                    }
                    break;
                case WxMsgType.VIDEO:
                    if (handler instanceof DefaultWxVideoRequestHandler) {
                        defaultHandlerMapping.put(WxConstant.HANDLER_VIDEO, handler);
                    }
                    break;
                case WxMsgType.LINK:
                    if (handler instanceof DefaultWxLinkRequestHandler) {
                        defaultHandlerMapping.put(WxConstant.HANDLER_LINK, handler);
                    }
                    break;
                case WxMsgType.LOCATION:
                    if (handler instanceof DefaultWxLocationEventHandler) {
                        defaultHandlerMapping.put(WxConstant.HANDLER_LOCATION, handler);
                    }
                    break;
                case WxMsgType.FILE:
                    if (handler instanceof DefaultWxFileRequestHandler) {
                        defaultHandlerMapping.put(WxConstant.HANDLER_FILE, handler);
                    }
                    break;
                case WxMsgType.EVENT:
                    if (handler instanceof DefaultWxFollowEventHandler) {
                        defaultHandlerMapping.put(WxConstant.HANDLER_FOLLOW_EVENT, handler);
                    }
                    if (handler instanceof DefaultWxQrCodeEventHandler) {
                        defaultHandlerMapping.put(WxConstant.HANDLER_QRCODE_EVENT, handler);
                    }
                    if (handler instanceof DefaultWxLocationEventHandler) {
                        defaultHandlerMapping.put(WxConstant.HANDLER_LOCCATION_EVENT, handler);
                    }
                    if (handler instanceof DefaultWxMenuEventHandler) {
                        defaultHandlerMapping.put(WxConstant.HANDLER_MENU_DEFAULT_EVENT, handler);
                    }
                    if (handler instanceof DefaultWxScanCodeEventHandler) {
                        defaultHandlerMapping.put(WxConstant.HANDLER_MENU_SCANCODE_PUSH_EVENT, handler);
                    }
                    if (handler instanceof DefaultWxPicPhotoEventHandler) {
                        defaultHandlerMapping.put(WxConstant.HANDLER_MENU_PIC_PHOTO_EVENT, handler);
                    }
                    if (handler instanceof DefaultWxLocationSelectEventHandler) {
                        defaultHandlerMapping.put(WxConstant.HANDLER_MENU_LOCATION_SELECT_EVENT, handler);
                    }
                    break;
                default:
            }
        }
    }
}
