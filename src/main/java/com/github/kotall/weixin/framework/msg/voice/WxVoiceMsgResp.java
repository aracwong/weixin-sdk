package com.github.kotall.weixin.framework.msg.voice;

import com.github.kotall.weixin.framework.core.WxResponse;
import com.github.kotall.weixin.framework.core.WxResponseWrapper;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

/**
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/4/29 0029 上午 10:33
 */
@Data
@ToString(callSuper = true)
@XStreamAlias("xml")
public class WxVoiceMsgResp extends WxResponseWrapper {

    @XStreamAlias("MediaId")
    private String mediaId;

    public WxVoiceMsgResp(WxResponse response) {
        super(response);
    }
}
