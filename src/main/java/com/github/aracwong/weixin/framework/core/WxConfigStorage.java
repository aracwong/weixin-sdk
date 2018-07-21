package com.github.aracwong.weixin.framework.core;

import com.github.aracwong.weixin.dto.accesstoken.WxAccountDto;

/**
 *
 * 微信配置取存器
 *
 * @author zpwang
 * @version 1.0.0
 */
public interface WxConfigStorage {


    /**
     *
     * 保存微信账号配置信息
     * @param wxAccountDto
     *        微信账号配置dto
     */
    void saveWxAccount(WxAccountDto wxAccountDto);

    /**
     * 获取微信账号配置信息
     *
     * @param url  服务器url
     * @return  微信账号配置dto
     */
    WxAccountDto getWxAccount(String url);

}
