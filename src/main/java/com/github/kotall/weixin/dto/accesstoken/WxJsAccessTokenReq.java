package com.github.kotall.weixin.dto.accesstoken;

import lombok.Data;

/**
 * @author: zpwang
 * @version: 1.0.0
 * @date: 2018/5/10
 */
@Data
public class WxJsAccessTokenReq extends WxAccessTokenReq {

    private String code;
}
