package com.github.kotall.weixin.framework.msg.file;

import com.github.kotall.weixin.framework.core.WxRequest;
import com.github.kotall.weixin.framework.core.WxRequestWrapper;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

/**
 * 文件类型消息
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/5/1 0001 下午 5:35
 */
@Data
@ToString(callSuper = true)
@XStreamAlias("xml")
public class WxFileMsgReq extends WxRequestWrapper {

    @XStreamAlias("Title")
    private String title;

    @XStreamAlias("Description")
    private String description;

    @XStreamAlias("FileKey")
    private String fileKey;

    @XStreamAlias("FileMd5")
    private String fileMd5;

    @XStreamAlias("FileTotalLen")
    private String fileTotalLen;

    @XStreamAlias("MsgId")
    private String msgId;

    public WxFileMsgReq(WxRequest request) {
        super(request);
        this.title = request.getParameter("//Title");
        this.description = request.getParameter("//Description");
        this.fileKey = request.getParameter("//FileKey");
        this.fileMd5 = request.getParameter("//FileMd5");
        this.fileTotalLen = request.getParameter("//FileTotalLen");
        this.msgId = request.getParameter("//MsgId");
    }
}
