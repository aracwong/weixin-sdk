package com.github.kotall.weixin.framework.msg.music;

import com.github.kotall.weixin.framework.core.WxResponse;
import com.github.kotall.weixin.framework.core.WxResponseWrapper;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

/**
 * 回复音乐消息
 *
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/4/29 0029 上午 10:36
 */
@Data
@ToString(callSuper = true)
@XStreamAlias("xml")
public class WxMusicMsgResp extends WxResponseWrapper {

    @XStreamAlias("MediaId")
    private String mediaId;

    @XStreamAlias("Title")
    private String title;

    @XStreamAlias("Description")
    private String description;

    @XStreamAlias("MusicURL")
    private String musicURL;

    @XStreamAlias("HQMusicUrl")
    private String hQMusicUrl;

    @XStreamAlias("ThumbMediaId")
    private String thumbMediaId;

    public WxMusicMsgResp(WxResponse response) {
        super(response);
    }

}
