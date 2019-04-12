package com.github.aracwong.wxframework.common.constants;

/**
 * 微信处理器类型常量
 *
 * @author zpwang
 * @version 1.0.0
 */
public class MpHandlerType {

    /**
     * 普通文本消息
     */
    public static final String HANDLER_TEXT = "HANDLER_TEXT";

    /**
     * 视频消息
     */
    public static final String HANDLER_VIDEO = "HANDLER_VIDEO";
    /**
     * 链接消息
     */
    public static final String HANDLER_LINK = "HANDLER_LINK";
    /**
     * 位置消息
     */
    public static final String HANDLER_LOCATION = "HANDLER_LOCATION";

    /**
     * 图像消息
     */
    public static final String HANDLER_IMAGE = "HANDLER_IMAGE";

    /**
     * 语音消息
     */
    public static final String HANDLER_VOICE = "HANDLER_VOICE";

    /**
     * 发送文件消息
     */
    public static final String HANDLER_FILE = "HANDLER_FILE";

    /**
     * 关注/取消关注 事件
     */
    public static final String HANDLER_EVENT_FOLLOW = "HANDLER_EVENT_FOLLOW";

    /**
     * 扫码关注事件
     */
    public static final String HANDLER_EVENT_QRCODE = "HANDLER_EVENT_QRCODE";

    /**
     * 位置事件
     */
    public static final String HANDLER_EVENT_LOCATION = "HANDLER_EVENT_LOCATION";

    /**
     * 菜单基本事件：CLICK VIEW
     */
    public static final String HANDLER_EVENT_MENU_DEFAULT = "HANDLER_EVENT_MENU_DEFAULT";

    /**
     * 自定义菜单扫码推事件
     */
    public static final String HANDLER_EVENT_MENU_SCANCODE_PUSH = "HANDLER_EVENT_MENU_SCANCODE_PUSH";

    /**
     * 弹出系统拍照发图的事件推送
     * 弹出拍照或者相册发图的事件推送
     */
    public static final String HANDLER_EVENT_MENU_PIC_PHOTO = "HANDLER_EVENT_MENU_PIC_PHOTO";

    /**
     * 弹出地理位置选择器的事件推送
     */
    public static final String HANDLER_EVENT_MENU_LOCATION_SELECT = "HANDLER_EVENT_MENU_LOCATION_SELECT";

}
