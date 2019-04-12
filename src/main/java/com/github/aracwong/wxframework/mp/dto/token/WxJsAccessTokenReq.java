package com.github.aracwong.wxframework.mp.dto.token;

import lombok.Data;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Data
public class WxJsAccessTokenReq extends WxAccessTokenReq {

    private String code;
}
