package com.github.aracwong.weixin.framework.context;

import com.github.aracwong.weixin.dto.accesstoken.WxAccessTokenResp;
import com.github.aracwong.weixin.framework.annotation.WxHandler;
import com.github.aracwong.weixin.framework.constant.WxConstant;
import com.github.aracwong.weixin.framework.constant.WxMsgType;
import com.github.aracwong.weixin.framework.core.WxRequestFilter;
import com.github.aracwong.weixin.framework.handler.event.*;
import com.github.aracwong.weixin.framework.handler.file.DefaultWxFileRequestHandler;
import com.github.aracwong.weixin.framework.handler.image.DefaultWxImageRequestHandler;
import com.github.aracwong.weixin.framework.handler.link.DefaultWxLinkRequestHandler;
import com.github.aracwong.weixin.framework.handler.location.DefaultWxLocationRequestHandler;
import com.github.aracwong.weixin.framework.handler.text.DefaultWxTextRequestHandler;
import com.github.aracwong.weixin.framework.handler.video.DefaultWxVideoRequestHandler;
import com.github.aracwong.weixin.framework.handler.voice.DefaultWxVoiceRequestHandler;

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



}
