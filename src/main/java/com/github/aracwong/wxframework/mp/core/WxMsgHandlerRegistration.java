package com.github.aracwong.wxframework.mp.core;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zpwang
 * @version 1.0.0
 */
public class WxMsgHandlerRegistration {

    public static Map<String, WxMsgHandler> handlerFiltersMapping = new ConcurrentHashMap<>();

    public WxMsgHandlerRegistration() {
        init();
    }

    private void init() {
        ServiceLoader<WxMsgHandler> serviceLoader = ServiceLoader.load(WxMsgHandler.class);
        Iterator<WxMsgHandler> it = serviceLoader.iterator();
        while (it != null && it.hasNext()) {
            WxMsgHandler handler = it.next();
            this.registerHandler(handler);
        }
    }

    public WxMsgHandlerRegistration registerHandler(WxMsgHandler handler) {
        handlerFiltersMapping.put(handler.getHandlerKey(), handler);
        return this;
    }

    List<WxRequestFilter> getHandlerFilters() {
        List<WxRequestFilter> handlerFilters = new ArrayList<>();
        handlerFiltersMapping.forEach((key, value) -> handlerFilters.add((WxRequestFilter)value));
        return handlerFilters;
    }


}
