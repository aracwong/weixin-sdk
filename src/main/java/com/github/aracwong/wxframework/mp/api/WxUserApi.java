package com.github.aracwong.wxframework.mp.api;

import com.github.aracwong.wxframework.mp.dto.user.WxUserInfoReq;
import com.github.aracwong.wxframework.mp.dto.user.WxUserInfoResp;

/**
 * @author zpwang
 * @version 1.0.0
 */
public interface WxUserApi {

    WxUserInfoResp getUserInfo(WxUserInfoReq wxUserInfoReq);
}
