package com.github.kotall.weixin.dto.user;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: zpwang
 * @version: 1.0.0
 * @date: 2018/5/10
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
