package com.github.kotall.weixin.api;

import com.github.kotall.weixin.dto.accesstoken.*;
import com.github.kotall.weixin.dto.result.WxResult;

/**
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/4/27 0027 下午 9:46
 */
public interface WxAccessTokenApi {

    /**
     * 刷新 accessToken
     *
     * @param wxAccessToken
     * @return
     */
    WxAccessTokenResp refreshAccessToken(WxAccessTokenReq wxAccessToken);

    /**
     * 获取网页版 accessToken
     *
     * @param wxJsAccessTokenReq
     * @return
     */
    WxJsAccessTokenResp getJsAccessToken(WxJsAccessTokenReq wxJsAccessTokenReq);


    /**
     * 网页版刷新 accessToken
     *
     * @param wxJsRefreshAccessTokenReq
     * @return
     */
    WxJsAccessTokenResp refreshJsAccessToken(WxJsRefreshAccessTokenReq wxJsRefreshAccessTokenReq);

    /**
     * 网页版校验 access_token有效性
     *
     * @param wxCheckAccessTokenReq
     * @return
     */
    WxResult checkJsAcccessToken(WxCheckAccessTokenReq wxCheckAccessTokenReq);

}
