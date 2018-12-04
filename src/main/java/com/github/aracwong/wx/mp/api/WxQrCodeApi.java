package com.github.aracwong.wx.mp.api;

import com.github.aracwong.wx.mp.dto.qrcode.WxQrCodeReqDto;
import com.github.aracwong.wx.mp.dto.qrcode.WxQrCodeRespDto;

/**
 * @author zpwang
 * @version 1.0.0
 */
public interface WxQrCodeApi {

    WxQrCodeRespDto create(String appId, WxQrCodeReqDto wxQrCodeReqDto);

}
