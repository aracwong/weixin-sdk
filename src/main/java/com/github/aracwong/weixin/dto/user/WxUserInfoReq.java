package com.github.aracwong.weixin.dto.user;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Data
public class WxUserInfoReq implements Serializable {

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("openid'")
    private String openId;
}
