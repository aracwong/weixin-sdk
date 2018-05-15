package com.github.kotall.weixin.framework.core;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理器链、注意并发问题
 *
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/4/30 0030 上午 7:56
 */
public class WxRequestFilterChain implements WxRequestFilter {

    private List<WxRequestFilter> handlerList = new ArrayList<>();
    private int index = 0;

    /**
     * 注册处理器
     *
     * @param wxRequestFilter
     * @return
     */
    public WxRequestFilterChain addHandler(WxRequestFilter wxRequestFilter) {
        this.handlerList.add(wxRequestFilter);
        return this;
    }

    @Override
    public void doFilter(WxRequest request, WxResponse response, WxRequestFilterChain chain) {
        if (index == handlerList.size()) {
            return;
        }
        WxRequestFilter handler = handlerList.get(index);
        index++;
        handler.doFilter(request, response, chain);
    }
}
