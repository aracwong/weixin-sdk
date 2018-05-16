package com.github.kotall.weixin.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.kotall.weixin.api.WxUserApi;
import com.github.kotall.weixin.dto.user.WxUserInfoReq;
import com.github.kotall.weixin.dto.user.WxUserInfoResp;
import com.github.kotall.weixin.utils.WxUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Slf4j
public class WxUserApiImpl implements WxUserApi {

    private static final String WX_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    @Override
    public WxUserInfoResp getUserInfo(WxUserInfoReq wxUserInfoReq) {
        String reqUrl = WX_USER_INFO_URL
                .replace("OPENID", wxUserInfoReq.getOpenId())
                .replace("ACCESS_TOKEN", wxUserInfoReq.getAccessToken());
        JSONObject rs = WxUtil.get(reqUrl);
        WxUserInfoResp wxUserInfoResp;
        if (null == rs) {
           return null;
        } else {
            wxUserInfoResp = new WxUserInfoResp();
            wxUserInfoResp.setCity(rs.getString("city"));
            wxUserInfoResp.setCountry(rs.getString("country"));
            wxUserInfoResp.setHeadImgUrl(rs.getString("headimgurl"));
            wxUserInfoResp.setNickName(rs.getString("nickname"));
            wxUserInfoResp.setOpenId(rs.getString("openid"));
            wxUserInfoResp.setPrivilege(rs.getString("privilege"));
            wxUserInfoResp.setProvince(rs.getString("province"));
            wxUserInfoResp.setSex(rs.getString("sex"));
            wxUserInfoResp.setUnionId(rs.getString("unionid"));
        }
        return wxUserInfoResp;
    }
}
