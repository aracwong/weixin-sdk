package com.github.aracwong.weixin.api;

import com.github.aracwong.weixin.dto.url.WxShortUrlReqDto;
import com.github.aracwong.weixin.dto.url.WxShortUrlRespDto;

/**
 * @author zpwang
 * @version 1.0.0
 */
public interface WxShortUrlApi {

    WxShortUrlRespDto shortUrl(String appId, WxShortUrlReqDto reqDto);
}
