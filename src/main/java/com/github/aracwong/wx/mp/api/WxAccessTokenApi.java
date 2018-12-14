package com.github.aracwong.wx.mp.api;

import com.github.aracwong.wx.mp.dto.accesstoken.*;
import com.github.aracwong.wx.mp.dto.result.WxResult;

/**
 * @author aracwong
 * @version 1.0.0
 */
public interface WxAccessTokenApi {

    /**
     * 刷新 accessToken
     *
     * @param wxAccessToken
     *        accessToken 对象
     * @return
     *       WxAccessTokenResp
     */
    WxAccessTokenResp refreshAccessToken(WxAccessTokenReq wxAccessToken);

    /**
     * 获取网页版 accessToken
     *
     * @param wxJsAccessTokenReq
     *        网页accessToken 对象
     * @return
     *        WxJsAccessTokenResp
     */
    WxJsAccessTokenResp getJsAccessToken(WxJsAccessTokenReq wxJsAccessTokenReq);


    /**
     * 网页版刷新 accessToken
     *
     * @param wxJsRefreshAccessTokenReq
     *       网页 refreshAccessToken 对象
     * @return
     *       WxJsAccessTokenResp
     */
    WxJsAccessTokenResp refreshJsAccessToken(WxJsRefreshAccessTokenReq wxJsRefreshAccessTokenReq);

    /**
     * 网页版校验 access_token有效性
     *
     * @param wxCheckAccessTokenReq
     *       网页刷新accessToken请求对象
     * @return
     *       WxResult
     */
    WxResult checkJsAcccessToken(WxCheckAccessTokenReq wxCheckAccessTokenReq);

}
