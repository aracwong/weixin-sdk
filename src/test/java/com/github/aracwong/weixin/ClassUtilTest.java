package com.github.aracwong.weixin;

import com.github.aracwong.weixin.framework.annotation.WxHandler;
import com.github.aracwong.weixin.framework.constant.WxConstant;
import com.github.aracwong.weixin.utils.ClassUtil;
import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * @author zpwang
 * @version 1.0.0
 */
@WxHandler(forType = WxConstant.HANDLER_EVENT_FOLLOW)
public class ClassUtilTest {

    @Test
    public void testGetClass() {
        List<Class<?>> classes = ClassUtil.getClasses("com.github.aracwong.weixin");
        for (Class<?> aClass : classes) {
            Annotation annotaion = aClass.getAnnotation(WxHandler.class);
            if (null != annotaion && annotaion instanceof WxHandler) {
                WxHandler wxHandler = (WxHandler)annotaion;
            }
        }
        Assert.assertTrue(classes.size() > 0);
    }

}
