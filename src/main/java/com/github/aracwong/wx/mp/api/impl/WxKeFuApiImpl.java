package com.github.aracwong.wx.mp.api.impl;

import com.github.aracwong.wx.mp.dto.result.WxResult;
import com.github.aracwong.wx.mp.api.WxKeFuApi;
import com.github.aracwong.wx.mp.dto.custom.WxKeFuReqDto;
import com.github.aracwong.wx.mp.framework.context.WxAppContext;
import com.google.gson.Gson;
import com.github.aracwong.wx.common.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Slf4j
public class WxKeFuApiImpl implements WxKeFuApi {

    private static final String WX_KEFU_CREATE_URL = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";

    @Override
    public WxResult create(String appId, WxKeFuReqDto wxKeFuReqDto) {
        log.info("创建客服, appId={}, 客服内容：{}", appId, wxKeFuReqDto);
        String url = WX_KEFU_CREATE_URL.replaceAll("ACCESS_TOKEN", WxAppContext.getWxAccessToken(appId).getAccessToken());
        Gson gson = new Gson();
        String json = gson.toJson(wxKeFuReqDto);

        if (log.isDebugEnabled()) {
            log.debug("调用微信创建客服接口数据：{}", json);
        }

        String jsonResult = HttpClientUtil.post(url, json);
        WxResult wxResult = gson.fromJson(jsonResult, WxResult.class);
        log.info("创建客服请求响应：{}", wxResult);
        return wxResult;
    }
}
