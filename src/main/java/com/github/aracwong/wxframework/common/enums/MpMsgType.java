package com.github.aracwong.wxframework.common.enums;

/**
 * desc:
 * 公众平台消息类型及对应的处理器
 *
 * @author zpwang
 * @date 2019/4/12 18:14
 * @since 1.0.0
 */
public enum MpMsgType {


    /**
     * 文本消息
     */
    TEXT("text", "HANDLER_TEXT"),

    /**
     * 图文消息
     */
    NEWS("news", "HANDLER_NEWS"),

    /**
     * 图片消息
     */
    IMAGE("news", "HANDLER_IMAGE"),

    /**
     * 语音消息
     */
    VOICE("voice", "HANDLER_VOICE"),

    /**
     * 视频消息
     */
    VIDEO("video", "HANDLER_VIDEO"),

    /**
     * 小视频消息
     */
    SHORT_VIDEO("shortvideo", "HANDLER_SHORT_VIDEO"),

    /**
     * 位置消息
     */
    LOCATION("location", "HANDLER_LOCATION"),

    /**
     * 链接消息
     */
    LINK("link", "HANDLER_LINK"),

    /**
     * 文件类型消息
     */
    FILE("file", "HANDLER_FILE"),

    /**
     * 事件消息
     */
    EVENT("event", "HANDLER_EVENT"),

    /**
     * 关注消息
     */
    EVENT_SUBSCRIBE("subscribe", "HANDLER_EVENT_FOLLOW"),

    /**
     * 取消关注消息
     */
    EVENT_UNSUBSCRIBE("unsubscribe", "HANDLER_EVENT_FOLLOW"),

    /**
     * 已关注时扫码
     */
    EVENT_SCAN("unsubscribe", "HANDLER_EVENT_SCAN"),

    /**
     * 上报地理位置事件
     */
    EVENT_LOCATION("location", "HANDLER_EVENT_LOCATION"),

    /**
     * 点击自定义菜单时间
     */
    EVENT_CLICK("click", "HANDLER_EVENT_CLICK"),

    /**
     * 点击菜单跳转链接事件
     */
    EVENT_VIEW("view", "HANDLER_EVENT_VIEW"),

    /**
     *
     * 扫码推事件
     *
     */
    EVENT_SCANCODE_PUSH("scancode_push", "HANDLER_EVENT_SCANCODE_PUSH"),

    /**
     * 扫码推事件且弹出 "消息接收中" 事件
     */
    EVENT_SCANCODE_PUSH_WAITMSG("scancode_waitmsg", "HANDLER_EVENT_SCANCODE_PUSH_WAITMSG"),

    /**
     * 弹出系统拍照发图的事件推送
     */
    EVENT_PIC_SYSPHOTO("pic_sysphoto", "HANDLER_EVENT_PIC_SYSPHOTO"),

    /**
     * 弹出拍照或者相册发图的事件推送
     */
    EVENT_PIC_PHOTO_OR_ALBUM("pic_photo_or_album", "HANDLER_EVENT_PIC_PHOTO_OR_ALBUM"),

    /**
     * 弹出微信相册发图器的事件推送
     */
    EVENT_PIC_WEIXIN("pic_weixin", "HANDLER_EVENT_PIC_WEIXIN"),

    /**
     * 弹出地理位置选择器的事件推送
     */
    EVENT_LOCATION_SELECT("location_select", "HANDLER_EVENT_LOCATION_SELECT"),

    ;

    private String msgType;

    private String handler;

    MpMsgType(String msgType, String handler) {
        this.msgType = msgType;
        this.handler = handler;
    }
}
