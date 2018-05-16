package com.github.aracwong.weixin.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Data
public class WxUserTagReq implements Serializable {

    private String name;
}
