package com.github.kotall.weixin.api.impl;

import com.github.kotall.weixin.dto.url.WxShortUrlReqDto;
import com.github.kotall.weixin.dto.url.WxShortUrlRespDto;
import com.google.gson.Gson;
import com.github.kotall.weixin.api.WxShortUrlApi;
import com.github.kotall.weixin.framework.context.WxAppContext;
import com.github.kotall.weixin.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: zpwang
 * @version: 1.0.0
 * @date: 2018/5/6
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
