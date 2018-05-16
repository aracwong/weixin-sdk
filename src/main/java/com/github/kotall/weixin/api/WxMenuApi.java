package com.github.kotall.weixin.api;

import com.github.kotall.weixin.dto.menu.WxReqMenuDto;
import com.github.kotall.weixin.dto.result.WxResult;

import java.util.List;

/**
 * @author aracwong
 * @version 1.0.0
 */
public interface WxMenuApi {

    WxResult create(String appId, List<WxReqMenuDto> wxMenus);
}
