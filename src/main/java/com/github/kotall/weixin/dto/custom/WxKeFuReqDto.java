package com.github.kotall.weixin.dto.custom;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 客服
 *
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/4/29 0029 上午 10:46
 */
@Data
@ToString
public class WxKeFuReqDto implements Serializable {

    @SerializedName("kf_account")
    private String keFuAccount;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("password")
    private String password;

}
