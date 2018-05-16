package com.github.aracwong.weixin.dto.custom;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Data
@ToString
public class WxKeFuRespDto {
    @SerializedName("kf_account")
    private String keFuAccount;

    @SerializedName("kf_nick")
    private String kfNick;

    @SerializedName("kf_id")
    private String kfId;

    @SerializedName("kf_headimgurl")
    private String kfHeadImgUrl;
}
