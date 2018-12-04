package com.github.aracwong.wx.mp.api;

import com.github.aracwong.wx.mp.dto.user.WxUserInfoReq;
import com.github.aracwong.wx.mp.dto.user.WxUserInfoResp;

/**
 * @author zpwang
 * @version 1.0.0
 */
public interface WxUserApi {

    WxUserInfoResp getUserInfo(WxUserInfoReq wxUserInfoReq);
}
