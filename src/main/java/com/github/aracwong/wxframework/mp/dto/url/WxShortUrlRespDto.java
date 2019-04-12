package com.github.aracwong.wxframework.mp.dto.url;

import com.github.aracwong.wxframework.mp.dto.result.WxResult;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Data
@ToString(callSuper = true)
public class WxShortUrlRespDto extends WxResult implements Serializable {

    @SerializedName("short_url")
    private String shortUrl;

}
