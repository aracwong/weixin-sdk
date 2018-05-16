package com.github.aracwong.weixin.framework.annotation;

import java.util.Map;

/**
 * @author aracwong
 * @version 1.0.0
 */
public interface WxAnnotationResolver {

    void resolve(Map<String, Object> wxHandlers);
}
