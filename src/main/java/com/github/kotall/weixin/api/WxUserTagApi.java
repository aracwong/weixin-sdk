package com.github.kotall.weixin.api;

import com.github.kotall.weixin.dto.user.WxUserInfoReq;
import com.github.kotall.weixin.dto.user.WxUserTagResp;

/**
 * 用户标签
 *
 * @author: zpwang
 * @version: 1.0.0
 * @date: 2018/5/11
 */
public interface WxUserTagApi {

    /**
     * 创建用户标签
     *
     * @param wxUserInfoReq
     * @return
     */
    WxUserTagResp createUserTag(WxUserInfoReq wxUserInfoReq);
}
