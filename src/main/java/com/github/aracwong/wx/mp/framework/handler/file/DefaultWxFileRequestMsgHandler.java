package com.github.aracwong.wx.mp.framework.handler.file;

import com.github.aracwong.wx.mp.framework.constant.WxHandlerType;
import com.github.aracwong.wx.mp.framework.constant.WxMsgType;
import com.github.aracwong.wx.mp.framework.core.WxDelegateRequestMsgFilter;
import com.github.aracwong.wx.mp.framework.core.WxRequest;
import com.github.aracwong.wx.mp.framework.core.WxResponse;
import com.github.aracwong.wx.mp.framework.msg.file.WxFileMsgReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxFileRequestMsgHandler extends WxDelegateRequestMsgFilter<WxFileMsgReq> {

    @Override
    public String getHandlerKey() {
        return WxHandlerType.HANDLER_FILE;
    }

    @Override
    public boolean support(WxRequest request) {
        if (WxMsgType.FILE.equals(request.getMsgType())) {
            return true;
        }
        return false;
    }

    @Override
    public void handle(WxFileMsgReq request, WxResponse response) {
        log.info("接收到文件类型消息：{}", request);
    }
}
