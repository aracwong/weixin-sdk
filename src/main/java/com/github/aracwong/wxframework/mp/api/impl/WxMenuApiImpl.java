package com.github.aracwong.wxframework.mp.api.impl;

import com.github.aracwong.wxframework.mp.api.WxMenuApi;
import com.github.aracwong.wxframework.mp.dto.menu.WxReqMenuDto;
import com.github.aracwong.wxframework.mp.dto.result.WxResult;
import com.github.aracwong.wxframework.mp.context.WxAppContext;
import com.github.aracwong.wxframework.common.utils.HttpClientUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author aracwong
 * @version 1.0.0
 */
public class WxMenuApiImpl implements WxMenuApi {

    private static final Logger log = LoggerFactory.getLogger(WxMenuApiImpl.class);

    private static final String WX_MENU_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create";

    @Override
    public WxResult create(String appId, List<WxReqMenuDto> wxMenus) {
        String url = WX_MENU_CREATE + "?access_token=" + WxAppContext.getWxAccessToken(appId).getAccessToken();
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        Map<String, List<WxReqMenuDto>> wxMenuMap = new HashMap<>(1);
        wxMenuMap.put("button", wxMenus);
        String postEntity = gson.toJson(wxMenuMap);
        log.info("创建微信菜单请求：appId={}, 菜单定义: {}", appId, wxMenus);
        String jsonResult = HttpClientUtil.post(url, postEntity);
        WxResult wxResult = gson.fromJson(jsonResult, WxResult.class);
        log.info("创建菜单请求响应：{}", wxResult);
        return wxResult;
    }
}
