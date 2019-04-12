package com.github.aracwong.wxframework.common.constants;

/**
 * @author aracwong
 * @version 1.0.0
 */
public class MpMsgType {

    /**
     * 文本消息
     */
    public static final String TEXT = "text";

    /**
     * 图文消息
     */
    public static final String NEWS = "news";

    /**
     * 图片消息
     */
    public static final String IMAGE = "image";

    /**
     * 语音消息
     */
    public static final String VOICE = "voice";

    /**
     * 视频消息
     */
    public static final String VIDEO = "video";

    /**
     * 小视频消息
     */
    public static final String SHORT_VIDEO = "shortvideo";

    /**
     * 位置消息
     */
    public static final String LOCATION = "location";

    /**
     * 链接消息
     */
    public static final String LINK = "link";

    /**
     * 文件类型消息
     */
    public static final String FILE = "file";


    /**
     * 事件消息
     */
    public static final String EVENT = "event";

    /**
     * 关注消息
     */
    public static final String EVENT_SUBSCRIBE = "subscribe";

    /**
     * 取消关注消息
     */
    public static final String EVENT_UNSUBSCRIBE = "unsubscribe";

    /**
     * 已关注时扫码
     */
    public static final String EVENT_SCAN = "scan";

    /**
     * 上报地理位置事件
     */
    public static final String EVENT_LOCATION = "location";

    /**
     * 点击自定义菜单时间
     */
    public static final String EVENT_CLICK = "CLICK";

    /**
     * 点击菜单跳转链接事件
     */
    public static final String EVENT_VIEW = "VIEW";

    /**
     *
     * 扫码推事件
     *
     */
    public static final String EVENT_SCANCODE_PUSH = "scancode_push";

    /**
     * 扫码推事件且弹出 "消息接收中" 事件
     */
    public static final String EVENT_SCANCODE_PUSH_WAITMSG = "scancode_waitmsg";

    /**
     * 弹出系统拍照发图的事件推送
     */
    public static final String EVENT_PIC_SYSPHOTO = "pic_sysphoto";

    /**
     * 弹出拍照或者相册发图的事件推送
     */
    public static final String EVENT_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";

    /**
     * 弹出微信相册发图器的事件推送
     */
    public static final String EVENT_PIC_WEIXIN = "pic_weixin";

    /**
     * 弹出地理位置选择器的事件推送
     */
    public static final String EVENT_LOCATION_SELECT = "location_select";
}
