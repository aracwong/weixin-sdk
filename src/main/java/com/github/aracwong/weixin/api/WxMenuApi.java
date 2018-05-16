package com.github.aracwong.weixin.api;

import com.github.aracwong.weixin.dto.menu.WxReqMenuDto;
import com.github.aracwong.weixin.dto.result.WxResult;

import java.util.List;

/**
 * @author aracwong
 * @version 1.0.0
 */
public interface WxMenuApi {

    WxResult create(String appId, List<WxReqMenuDto> wxMenus);
}
