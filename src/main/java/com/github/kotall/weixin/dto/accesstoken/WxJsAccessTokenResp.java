package com.github.kotall.weixin.dto.accesstoken;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author: zpwang
 * @version: 1.0.0
 * @date: 2018/5/10
 */
@Data
public class WxJsAccessTokenResp extends WxAccessTokenResp {

    @SerializedName("openid")
    private String openId;

    private String scope;

    @SerializedName("refresh_token")
    private String refreshToken;
}
