package com.github.aracwong.wxframework.mp.context;

import com.github.aracwong.wxframework.mp.dto.token.WxAccessTokenResp;

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
