package com.github.aracwong.wxframework.mp.api;

import com.github.aracwong.wxframework.mp.dto.menu.WxReqMenuDto;
import com.github.aracwong.wxframework.mp.dto.result.WxResult;

import java.util.List;

/**
 * @author aracwong
 * @version 1.0.0
 */
public interface WxMenuApi {

    WxResult create(String appId, List<WxReqMenuDto> wxMenus);
}
