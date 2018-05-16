package com.github.aracwong.weixin.api;

import com.github.aracwong.weixin.dto.result.WxResult;
import com.github.aracwong.weixin.dto.custom.WxKeFuReqDto;

/**
 * @author zpwang
 * @version 1.0.0
 */
public interface WxKeFuApi {

    WxResult create(String appId, WxKeFuReqDto wxKeFuReqDto);
}
