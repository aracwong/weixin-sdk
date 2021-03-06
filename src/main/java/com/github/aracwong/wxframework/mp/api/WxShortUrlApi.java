package com.github.aracwong.wxframework.mp.api;

import com.github.aracwong.wxframework.mp.dto.url.WxShortUrlReqDto;
import com.github.aracwong.wxframework.mp.dto.url.WxShortUrlRespDto;

/**
 * @author zpwang
 * @version 1.0.0
 */
public interface WxShortUrlApi {

    WxShortUrlRespDto shortUrl(String appId, WxShortUrlReqDto reqDto);
}
