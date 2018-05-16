package com.github.kotall.weixin.api;

import com.github.kotall.weixin.dto.user.WxUserInfoReq;
import com.github.kotall.weixin.dto.user.WxUserInfoResp;

/**
 * @author zpwang
 * @version 1.0.0
 */
public interface WxUserApi {

    WxUserInfoResp getUserInfo(WxUserInfoReq wxUserInfoReq);
}
