package com.github.aracwong.weixin.dto.accesstoken;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Data
public class WxCheckAccessTokenReq implements Serializable {

    String openId;

    String accessToken;
}
