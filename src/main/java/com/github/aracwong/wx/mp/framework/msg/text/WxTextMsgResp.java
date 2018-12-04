package com.github.aracwong.wx.mp.framework.msg.text;

import com.github.aracwong.wx.mp.framework.core.WxBeanBasedResponseWrapper;
import com.github.aracwong.wx.mp.framework.core.WxResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

/**
 * @author aracwong
 * @version 1.0.0
 */
@Data
@ToString(callSuper = true)
@XStreamAlias("xml")
public class WxTextMsgResp extends WxBeanBasedResponseWrapper {

    @XStreamAlias("Content")
    private String content;

    public WxTextMsgResp(WxResponse response) {
        super(response);
    }

}
