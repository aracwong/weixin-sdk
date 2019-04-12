package com.github.aracwong.wxframework.mp.dto.user;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Data
public class WxUserInfoResp implements Serializable {

    @SerializedName("openid")
    private String openId;

    @SerializedName("nickname")
    private String nickName;

    private String sex;

    private String province;

    private String city;

    private String country;

    @SerializedName("headimgurl")
    private String headImgUrl;

    private String privilege;

    @SerializedName("unionid")
    private String unionId;


}
