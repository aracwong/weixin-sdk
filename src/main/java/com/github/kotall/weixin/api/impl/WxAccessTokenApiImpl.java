package com.github.kotall.weixin.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.kotall.weixin.api.WxAccessTokenApi;
import com.github.kotall.weixin.dto.accesstoken.*;
import com.github.kotall.weixin.dto.result.WxResult;
import com.github.kotall.weixin.framework.constant.WxConstant;
import com.github.kotall.weixin.utils.WxUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author aracwong
 * @version 1.0.0
 */
public class WxAccessTokenApiImpl implements WxAccessTokenApi {

    private static final Logger log = LoggerFactory.getLogger(WxAccessTokenApiImpl.class);

    public static final String WX_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public static final String WX_JS_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code";

    public static final String WX_JS_REFRESH_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";

    public static final String WX_JS_CHECK_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID";


    @Override
    public WxAccessTokenResp refreshAccessToken(WxAccessTokenReq wxAccessTokenReq) {
        String requestUrl = WX_ACCESS_TOKEN_URL.replace("APPID", wxAccessTokenReq.getAppId()).replace("APPSECRET", wxAccessTokenReq.getAppSecret());
        JSONObject rs = WxUtil.get(requestUrl);
        WxAccessTokenResp wxAccessTokenResp;
        if (null == rs || rs.containsKey(WxConstant.WX_ERROR_CODE_KEY)) {
            log.warn("failed to refresh accessToken from WeiXin server, errcode:{}, errmsg:{}", rs.get(WxConstant.WX_ERROR_CODE_KEY), rs.get(WxConstant.WX_ERROR_MSG_KEY));
            return null;
        } else {
            wxAccessTokenResp = new WxAccessTokenResp();
            wxAccessTokenResp.setAccessToken(rs.getString(WxConstant.WX_ACCESS_TOKEN));
            wxAccessTokenResp.setExpiresIn(rs.getString(WxConstant.WX_EXPIRE_IN));
        }
        return wxAccessTokenResp;
    }

    @Override
    public WxJsAccessTokenResp getJsAccessToken(WxJsAccessTokenReq wxJsAccessTokenReq) {
        String reqUrl = WX_JS_ACCESS_TOKEN_URL
                .replace("APPID", wxJsAccessTokenReq.getAppId())
                .replace("APPSECRET", wxJsAccessTokenReq.getAppSecret())
                .replace("CODE", wxJsAccessTokenReq.getCode());
        JSONObject rs = WxUtil.get(reqUrl);
        WxJsAccessTokenResp wxJsAccessTokenResp;
        if (null == rs || rs.containsKey(WxConstant.WX_ERROR_CODE_KEY)) {
            log.warn("failed to get js accessToken from WeiXin server, errcode:{}, errmsg:{}", rs.get(WxConstant.WX_ERROR_CODE_KEY), rs.get(WxConstant.WX_ERROR_MSG_KEY));
            return null;
        } else {
            wxJsAccessTokenResp = this.getWxJsAccessTokenResp(rs);
        }

        return wxJsAccessTokenResp;
    }

    @Override
    public WxJsAccessTokenResp refreshJsAccessToken(WxJsRefreshAccessTokenReq wxJsRefreshAccessTokenReq) {
        String reqUrl = WX_JS_REFRESH_ACCESS_TOKEN_URL
                .replace("APPID", wxJsRefreshAccessTokenReq.getAppId())
                .replace("REFRESH_TOKEN", wxJsRefreshAccessTokenReq.getRefreshToken());
        JSONObject rs = WxUtil.get(reqUrl);
        WxJsAccessTokenResp wxJsAccessTokenResp;
        if (null == rs || rs.containsKey(WxConstant.WX_ERROR_CODE_KEY)) {
            log.warn("failed to refresh js accessToken from WeiXin server, errcode:{}, errmsg:{}", rs.get(WxConstant.WX_ERROR_CODE_KEY), rs.get(WxConstant.WX_ERROR_MSG_KEY));
            return null;
        } else {
            wxJsAccessTokenResp = this.getWxJsAccessTokenResp(rs);
        }
        return wxJsAccessTokenResp;
    }


    @Override
    public WxResult checkJsAcccessToken(WxCheckAccessTokenReq wxCheckAccessTokenReq) {
        String reqUrl = WX_JS_CHECK_ACCESS_TOKEN_URL
                .replace("OPENID", wxCheckAccessTokenReq.getOpenId())
                .replace("ACCESS_TOKEN", wxCheckAccessTokenReq.getAccessToken());
        JSONObject rs = WxUtil.get(reqUrl);
        WxResult result = null;
        if (null != rs) {
            result = new WxResult();
            result.setErrcode(rs.getString(WxConstant.WX_ERROR_CODE_KEY));
            result.setErrmsg(rs.getString(WxConstant.WX_ERROR_MSG_KEY));
        }
        return result;
    }


    private WxJsAccessTokenResp getWxJsAccessTokenResp(JSONObject rs) {
        WxJsAccessTokenResp wxJsAccessTokenResp;
        wxJsAccessTokenResp = new WxJsAccessTokenResp();
        wxJsAccessTokenResp.setAccessToken(rs.getString(WxConstant.WX_ACCESS_TOKEN));
        wxJsAccessTokenResp.setExpiresIn(rs.getString(WxConstant.WX_EXPIRE_IN));
        wxJsAccessTokenResp.setOpenId(rs.getString(WxConstant.WX_OPENID));
        wxJsAccessTokenResp.setRefreshToken(rs.getString(WxConstant.WX_REFRESH_TOKEN));
        wxJsAccessTokenResp.setScope(rs.getString(WxConstant.WX_SCOPE));
        return wxJsAccessTokenResp;
    }

}
