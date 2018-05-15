package com.github.kotall.weixin.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: zpwang
 * @version: 1.0.0
 * @date: 2018/5/11
 */
@Data
public class WxUserTagReq implements Serializable {

    private String name;
}
