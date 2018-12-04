package com.github.aracwong.wx.mp.api;

import com.github.aracwong.wx.mp.dto.url.WxShortUrlReqDto;
import com.github.aracwong.wx.mp.dto.url.WxShortUrlRespDto;

/**
 * @author zpwang
 * @version 1.0.0
 */
public interface WxShortUrlApi {

    WxShortUrlRespDto shortUrl(String appId, WxShortUrlReqDto reqDto);
}
