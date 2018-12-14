package com.github.aracwong.wx.mp;

import com.github.aracwong.wx.mp.framework.core.WxMsgHandler;
import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author zpwang
 * @version 1.0.0
 */
public class ServiceLoaderTest {

    @Test
    public void serviceLoader() {
        ServiceLoader<WxMsgHandler> serviceLoader = ServiceLoader.load(WxMsgHandler.class);
        Iterator<WxMsgHandler> it = serviceLoader.iterator();
        while (it != null && it.hasNext()) {
            WxMsgHandler handler = it.next();
            System.out.println(handler.getHandlerKey());
        }


    }
}
