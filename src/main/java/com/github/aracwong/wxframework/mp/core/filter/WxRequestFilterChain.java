package com.github.aracwong.wxframework.mp.core.filter;

import com.github.aracwong.wxframework.mp.core.request.WxRequest;
import com.github.aracwong.wxframework.mp.core.response.WxResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理器链、注意并发问题
 *
 * @author aracwong
 * @version 1.0.0
 */
public class WxRequestFilterChain implements WxRequestFilter {

    private List<WxRequestFilter> handlerList = new ArrayList<>();
    private int index = 0;

    /**
     * 注册处理器
     *
     * @param wxRequestFilter
     *        处理器
     * @return
     *        处理器链
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
