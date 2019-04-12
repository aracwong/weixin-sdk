package com.github.aracwong.wxframework.mp.api.impl;

import com.github.aracwong.wxframework.mp.api.WxQrCodeApi;
import com.github.aracwong.wxframework.mp.dto.qrcode.WxQrCodeRespDto;
import com.github.aracwong.wxframework.mp.context.WxAppContext;
import com.google.gson.Gson;
import com.github.aracwong.wxframework.mp.dto.qrcode.WxQrCodeReqDto;
import com.github.aracwong.wxframework.common.utils.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 二维码相关接口
 *
 * @author zpwang
 * @version 1.0.0
 */
public class WxQrCodeApiImpl implements WxQrCodeApi {

    private static final Logger log = LoggerFactory.getLogger(WxQrCodeApiImpl.class);

    private static final String WX_QRCODE_CREATE = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";

    @Override
    public WxQrCodeRespDto create(String appId, WxQrCodeReqDto wxQrCodeReqDto) {
        log.info("创建微信二维码请求：appId={}, 菜单定义: {}", appId, wxQrCodeReqDto);
        String url = WX_QRCODE_CREATE.replace("ACCESS_TOKEN", WxAppContext.getWxAccessToken(appId).getAccessToken());
        Gson gson = new Gson();
        String postEntity = gson.toJson(wxQrCodeReqDto);
        log.info(postEntity);
        String jsonResult = HttpClientUtil.post(url, postEntity);
        log.info("创建二维码请求响应：{}", jsonResult);
        WxQrCodeRespDto wxResult = gson.fromJson(jsonResult, WxQrCodeRespDto.class);
        return wxResult;
    }
}
