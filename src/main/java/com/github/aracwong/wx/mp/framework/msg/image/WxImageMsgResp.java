package com.github.aracwong.wx.mp.framework.msg.image;

import com.github.aracwong.wx.mp.framework.core.WxResponse;
import com.github.aracwong.wx.mp.framework.core.WxResponseWrapper;
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
public class WxImageMsgResp extends WxResponseWrapper {

    @XStreamAlias("MediaId")
    private String mediaId;

    public WxImageMsgResp(WxResponse response) {
        super(response);
    }
}
