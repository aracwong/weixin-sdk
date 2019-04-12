package com.github.aracwong.wxframework.mp.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.aracwong.wxframework.mp.api.WxUserTagApi;
import com.github.aracwong.wxframework.mp.dto.user.WxUserInfoReq;
import com.github.aracwong.wxframework.common.utils.WxUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.github.aracwong.wxframework.mp.dto.user.WxUserTagResp;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Slf4j
public class WxUserTagApiImpl implements WxUserTagApi {

    private static final String WX_USER_TAG_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/tags/create?access_token=ACCESS_TOKEN";

    @Override
    public WxUserTagResp createUserTag(WxUserInfoReq wxUserInfoReq) {

        String url = WX_USER_TAG_CREATE_URL.replace("ACCESS_TOKEN", "");
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String json = gson.toJson(wxUserInfoReq);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tag", json);
        JSONObject rs = WxUtil.post(url, jsonObject.toJSONString());

        if (null == rs) {
            log.info("创建用户标签失败");
            return null;
        } else {
            Object obj = rs.get("tag");

        }
        return null;
    }
}
