package com.github.aracwong.wxframework.mp.dto.token;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Data
public class WxJsAccessTokenResp extends WxAccessTokenResp {

    @SerializedName("openid")
    private String openId;

    private String scope;

    @SerializedName("refresh_token")
    private String refreshToken;
}
