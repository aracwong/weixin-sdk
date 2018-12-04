package com.github.aracwong.wx.mp.api;

import com.github.aracwong.wx.mp.dto.result.WxResult;
import com.github.aracwong.wx.mp.dto.custom.WxKeFuReqDto;

/**
 * @author zpwang
 * @version 1.0.0
 */
public interface WxKeFuApi {

    WxResult create(String appId, WxKeFuReqDto wxKeFuReqDto);
}
