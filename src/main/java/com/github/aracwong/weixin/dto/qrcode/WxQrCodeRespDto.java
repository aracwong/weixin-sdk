package com.github.aracwong.weixin.dto.qrcode;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Data
@ToString
public class WxQrCodeRespDto implements Serializable {

    @SerializedName("ticket")
    private String ticket;

    @SerializedName("expire_seconds")
    private long expireSeconds;

    @SerializedName("url")
    private String url;

}
