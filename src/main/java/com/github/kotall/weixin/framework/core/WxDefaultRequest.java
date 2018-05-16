package com.github.kotall.weixin.framework.core;

import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author aracwong
 * @version 1.0.0
 */
public class WxDefaultRequest extends WxXmlRequestResolver implements WxRequest {
    /**
     * 消息类型
     * 1：text 文本消息
     * 2：image 图片消息
     * 3：voice 语音消息
     * 4：video 视频消息
     * 5：location 地址位置消息
     * 6：link 链接消息
     * 7：event 事件
     */
    private String msgType;
    private String toUserName;
    private String fromUserName;
    private long createTime;

    /**
     * 存放属性
     */
    private Map<String, Object> attributes = new HashMap<>();

    public WxDefaultRequest(InputSource inputSource) throws Exception {
        super(inputSource);
    }

    public WxDefaultRequest(String xmlData) throws Exception {
        super(new InputSource(new StringReader(xmlData.trim())));
    }

    @Override
    public String getFromUserName() {
        if (null == this.fromUserName) {
            this.fromUserName = this.getString("//FromUserName");
        }
        return this.fromUserName;
    }

    @Override
    public String getToUserName() {
        if (null == this.toUserName) {
            this.toUserName = this.getString("//ToUserName");
        }
        return this.toUserName;
    }

    @Override
    public long getCreateTime() {
        if (0 == this.createTime) {
            this.createTime = this.getNumber("//CreateTime").longValue();
        }
        return this.createTime;
    }

    @Override
    public String getMsgType() {
        if (null == this.msgType) {
            this.msgType = this.getString("//MsgType");
        }
        return this.msgType;
    }

    @Override
    public String getParameter(String name) {
        return this.getString(name);
    }

    @Override
    public Object getNodeListParameter(String nodeName) {
        return this.getNodeList(nodeName);
    }

    @Override
    public void setAttribute(String name, Object value) {
        this.attributes.put(name, value);
    }

    @Override
    public Object getAttribute(String key) {
        return this.attributes.get(key);
    }
}
