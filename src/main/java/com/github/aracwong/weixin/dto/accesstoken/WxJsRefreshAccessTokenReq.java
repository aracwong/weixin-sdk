package com.github.aracwong.weixin.dto.accesstoken;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Data
public class WxJsRefreshAccessTokenReq implements Serializable {

    private String appId;

    @SerializedName("grant_type")
    private String grantType;

    @SerializedName("refresh_token")
    private String refreshToken;
}
