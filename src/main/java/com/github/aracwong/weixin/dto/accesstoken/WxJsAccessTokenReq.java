package com.github.aracwong.weixin.dto.accesstoken;

import lombok.Data;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Data
public class WxJsAccessTokenReq extends WxAccessTokenReq {

    private String code;
}
