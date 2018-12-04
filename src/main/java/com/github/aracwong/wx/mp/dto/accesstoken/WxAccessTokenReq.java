package com.github.aracwong.wx.mp.dto.accesstoken;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Data
public class WxAccessTokenReq implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * 微信公众号 appId
     */
    private String appId;

    /**
     * 凭证密钥
     */
    private String appSecret;

    public WxAccessTokenReq() {
    }

    public WxAccessTokenReq(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }

}
