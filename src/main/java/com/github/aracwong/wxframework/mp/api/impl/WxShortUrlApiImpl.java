package com.github.aracwong.wxframework.mp.api.impl;

import com.github.aracwong.wxframework.mp.dto.url.WxShortUrlReqDto;
import com.github.aracwong.wxframework.mp.dto.url.WxShortUrlRespDto;
import com.github.aracwong.wxframework.mp.context.WxAppContext;
import com.github.aracwong.wxframework.common.utils.HttpClientUtil;
import com.google.gson.Gson;
import com.github.aracwong.wxframework.mp.api.WxShortUrlApi;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Slf4j
public class WxShortUrlApiImpl implements WxShortUrlApi {

    private static final String WX_SHORTURL_CREATE = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN";

    @Override
    public WxShortUrlRespDto shortUrl(String appId, WxShortUrlReqDto reqDto) {
        log.info("微信长链接转短链接请求：菜单定义: {}", reqDto);
        String url = WX_SHORTURL_CREATE.replace("ACCESS_TOKEN", WxAppContext.getWxAccessToken(appId).getAccessToken());
        Gson gson = new Gson();
        String postEntity = gson.toJson(reqDto);
        String jsonResult = HttpClientUtil.post(url, postEntity);
        WxShortUrlRespDto wxResult = gson.fromJson(jsonResult, WxShortUrlRespDto.class);
        log.info("微信长链接转短链接响应：{}", wxResult);
        return wxResult;
    }
}
