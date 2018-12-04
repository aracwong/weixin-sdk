package com.github.aracwong.wx.mp.dto.accesstoken;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信账号配置
 *
 * @author zpwang
 * @version 1.0.0
 */
@Data
public class WxAccountDto implements Serializable {

    /**
     * 微信公众号 appId
     */
    private String appId;

    /**
     * 微信公众号名称
     */
    private String appName;

    /**
     * 微信公众号 appSecret
     */
    private String appSecret;

    /**
     * 微信公众号 encodingAesKey
     */
    private String aesKey;

    /**
     * 微信公众号 token
     */
    private String token;

    /**
     * 对微信公众号服务器开发的 url
     */
    private String url;

}
