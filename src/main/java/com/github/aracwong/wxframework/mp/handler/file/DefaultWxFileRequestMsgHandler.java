package com.github.aracwong.wxframework.mp.handler.file;

import com.github.aracwong.wxframework.common.constants.MpHandlerType;
import com.github.aracwong.wxframework.common.constants.MpMsgType;
import com.github.aracwong.wxframework.mp.core.filter.WxDelegateRequestMsgFilter;
import com.github.aracwong.wxframework.mp.core.request.WxRequest;
import com.github.aracwong.wxframework.mp.core.response.WxResponse;
import com.github.aracwong.wxframework.mp.msg.file.WxFileMsgReq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
public class DefaultWxFileRequestMsgHandler extends WxDelegateRequestMsgFilter<WxFileMsgReq> {

    @Override
    public String getHandlerKey() {
        return MpHandlerType.HANDLER_FILE;
    }

    @Override
    public boolean support(WxRequest request) {
        if (MpMsgType.FILE.equals(request.getMsgType())) {
            return true;
        }
        return false;
    }

    @Override
    public void handle(WxFileMsgReq request, WxResponse response) {
        log.info("接收到文件类型消息：{}", request);
    }
}
