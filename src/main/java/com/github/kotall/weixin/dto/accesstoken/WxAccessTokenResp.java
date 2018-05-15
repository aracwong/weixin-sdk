package com.github.kotall.weixin.dto.accesstoken;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : zpwang
 * @version : 1.0.0
 * @date : 2018/2/22
 */
@Data
public class WxAccessTokenResp implements Serializable {

    public static final long serialVersionUID = 1L;


    /**
     * access_token
     */
    private String accessToken;

    /**
     * 有效时间
     */
    private String expiresIn;

    public WxAccessTokenResp() {}

    public WxAccessTokenResp(String appId, String accessToken, String expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }

    public WxAccessTokenResp(String appId, String appSecret, String accessToken, String expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }


}
