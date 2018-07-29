package com.github.aracwong.weixin.framework.handler.file;

import com.github.aracwong.weixin.framework.constant.WxConstant;
import com.github.aracwong.weixin.framework.constant.WxMsgType;
import com.github.aracwong.weixin.framework.core.WxDelegateRequestFilter;
import com.github.aracwong.weixin.framework.core.WxRequest;
import com.github.aracwong.weixin.framework.core.WxResponse;
import com.github.aracwong.weixin.framework.msg.file.WxFileMsgReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxFileRequestHandler extends WxDelegateRequestFilter<WxFileMsgReq> {

    @Override
    public String getHandlerKey() {
        return WxConstant.HANDLER_FILE;
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
