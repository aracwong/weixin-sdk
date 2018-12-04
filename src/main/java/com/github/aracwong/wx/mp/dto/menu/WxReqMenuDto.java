package com.github.aracwong.wx.mp.dto.menu;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Data
@ToString
public class WxReqMenuDto implements Serializable {

    private String name;

    private String type;

    private String key;

    private String url;

    @SerializedName("appid")
    private String appId;

    @SerializedName("pagepath")
    private String pagePath;

    @SerializedName("sub_button")
    private List<WxReqMenuDto> subMenus;

}
