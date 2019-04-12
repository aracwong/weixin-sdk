package com.github.aracwong.wxframework.mp.api;

import com.github.aracwong.wxframework.mp.dto.result.WxResult;
import com.github.aracwong.wxframework.mp.dto.custom.WxKeFuReqDto;

/**
 * @author zpwang
 * @version 1.0.0
 */
public interface WxKeFuApi {

    WxResult create(String appId, WxKeFuReqDto wxKeFuReqDto);
}
