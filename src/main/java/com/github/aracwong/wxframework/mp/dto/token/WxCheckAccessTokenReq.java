package com.github.aracwong.wxframework.mp.dto.token;

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
