package com.github.kotall.weixin.framework.annotation;

import java.util.Map;

/**
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/5/1 0001 上午 11:41
 */
public interface WxAnnotationResolver {

    void resolve(Map<String, Object> wxHandlers);
}
