package com.github.aracwong.wxframework.mp.msg.video;

import com.github.aracwong.wxframework.mp.core.WxResponse;
import com.github.aracwong.wxframework.mp.core.WxResponseWrapper;
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
public class WxVideoMsgResp extends WxResponseWrapper {

    @XStreamAlias("MediaId")
    private String mediaId;

    @XStreamAlias("Title")
    private String title;

    @XStreamAlias("Description")
    private String description;

    public WxVideoMsgResp(WxResponse response) {
        super(response);
    }

}
