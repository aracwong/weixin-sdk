package com.github.aracwong.wx.mp;

import com.github.aracwong.wx.mp.framework.annotation.WxHandler;
import com.github.aracwong.wx.mp.framework.constant.WxHandlerType;
import com.github.aracwong.wx.common.utils.ClassUtil;
import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * @author zpwang
 * @version 1.0.0
 */
@WxHandler(forType = WxHandlerType.HANDLER_EVENT_FOLLOW)
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
