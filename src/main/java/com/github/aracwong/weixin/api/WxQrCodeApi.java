package com.github.aracwong.weixin.api;

import com.github.aracwong.weixin.dto.qrcode.WxQrCodeReqDto;
import com.github.aracwong.weixin.dto.qrcode.WxQrCodeRespDto;

/**
 * @author zpwang
 * @version 1.0.0
 */
public interface WxQrCodeApi {

    WxQrCodeRespDto create(String appId, WxQrCodeReqDto wxQrCodeReqDto);

}
