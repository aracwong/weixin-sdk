package com.github.kotall.weixin.dto.accesstoken;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: zpwang
 * @version: 1.0.0
 * @date: 2018/5/10
 */
@Data
public class WxCheckAccessTokenReq implements Serializable {

    String openId;

    String accessToken;
}
