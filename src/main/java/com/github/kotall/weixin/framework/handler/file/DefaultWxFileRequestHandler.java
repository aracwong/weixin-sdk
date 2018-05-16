package com.github.kotall.weixin.framework.handler.file;

import com.github.kotall.weixin.framework.constant.WxMsgType;
import com.github.kotall.weixin.framework.core.WxDelegateRequestFilter;
import com.github.kotall.weixin.framework.core.WxRequest;
import com.github.kotall.weixin.framework.core.WxResponse;
import com.github.kotall.weixin.framework.msg.file.WxFileMsgReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxFileRequestHandler extends WxDelegateRequestFilter<WxFileMsgReq> {

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
