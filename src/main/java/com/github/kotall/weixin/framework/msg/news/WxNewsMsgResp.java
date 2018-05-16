package com.github.kotall.weixin.framework.msg.news;

import com.github.kotall.weixin.framework.core.WxBeanBasedResponseWrapper;
import com.github.kotall.weixin.framework.core.WxResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 回复图文消息
 *
 * @author aracwong
 * @version 1.0.0
 */
@Data
@ToString(callSuper = true)
@XStreamAlias("xml")
public class WxNewsMsgResp extends WxBeanBasedResponseWrapper {

    @XStreamAlias("ArticleCount")
    private String articleCount;

    @XStreamAlias("Articles")
    private List<Article> articles = new ArrayList<>();

    @Data
    @XStreamAlias("item")
    public static class Article {

        @XStreamAlias("Title")
        private String title;

        @XStreamAlias("Description")
        private String description;

        @XStreamAlias("PicUrl")
        private String picUrl;

        @XStreamAlias("Url")
        private String url;

    }

    public WxNewsMsgResp(WxResponse response) {
        super(response);
    }

}
