package com.github.kotall.weixin.dto.url;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: zpwang
 * @version: 1.0.0
 * @date: 2018/5/6
 */
@Data
@ToString
public class WxShortUrlReqDto implements Serializable {

    @SerializedName("action")
    private String action;

    @SerializedName("long_url")
    private String longUrl;
}
