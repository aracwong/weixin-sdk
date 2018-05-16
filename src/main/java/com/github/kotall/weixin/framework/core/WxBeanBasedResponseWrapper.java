package com.github.kotall.weixin.framework.core;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Data
public class WxBeanBasedResponseWrapper extends WxResponseWrapper {

    @XStreamAlias("MsgType")
    private String msgType;

    @XStreamAlias("ToUserName")
    private String toUserName;

    @XStreamAlias("FromUserName")
    private String fromUserName;

    @XStreamAlias("CreateTime")
    private long createTime;

    public WxBeanBasedResponseWrapper(WxResponse response) {
        super(response);
        this.msgType = super.getMsgType();
        this.fromUserName = super.getFromUserName();
        this.toUserName = super.getToUserName();
        this.createTime = super.getCreateTime();
    }


}
