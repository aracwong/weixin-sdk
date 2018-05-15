package com.github.kotall.weixin.api;

import com.github.kotall.weixin.dto.url.WxShortUrlReqDto;
import com.github.kotall.weixin.dto.url.WxShortUrlRespDto;

/**
 * @author: zpwang
 * @version: 1.0.0
 * @date: 2018/5/6
 */
public interface WxShortUrlApi {

    WxShortUrlRespDto shortUrl(String appId, WxShortUrlReqDto reqDto);
}
