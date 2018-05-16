package com.github.aracwong.weixin.api;

import com.github.aracwong.weixin.dto.user.WxUserInfoReq;
import com.github.aracwong.weixin.dto.user.WxUserInfoResp;

/**
 * @author zpwang
 * @version 1.0.0
 */
public interface WxUserApi {

    WxUserInfoResp getUserInfo(WxUserInfoReq wxUserInfoReq);
}
