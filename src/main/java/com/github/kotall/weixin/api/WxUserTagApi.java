package com.github.kotall.weixin.api;

import com.github.kotall.weixin.dto.user.WxUserInfoReq;
import com.github.kotall.weixin.dto.user.WxUserTagResp;

/**
 * 用户标签
 *
 * @author zpwang
 * @version 1.0.0
 */
public interface WxUserTagApi {

    /**
     * 创建用户标签
     *
     * @param wxUserInfoReq
     *      获取用户信息请求对象
     * @return
     *      用户信息响应对象
     */
    WxUserTagResp createUserTag(WxUserInfoReq wxUserInfoReq);
}
