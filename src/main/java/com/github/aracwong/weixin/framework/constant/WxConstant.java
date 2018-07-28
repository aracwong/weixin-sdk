package com.github.aracwong.weixin.framework.constant;

/**
 * @author zpwang
 * @version 1.0.0
 */
public class WxConstant {

    /**
     * 缓存中 access_token 前缀
     */
    public static final String WX_ACCESS_TOKEN_PREFIX = "access_token";

    /**
     * 微信响应error code key
     */
    public static final String WX_ERROR_CODE_KEY = "errcode";

    /**
     * 微信响应error msg key
     */
    public static final String WX_ERROR_MSG_KEY = "errmsg";

    /**
     * access_token
     */
    public static final String WX_ACCESS_TOKEN = "access_token";

    /**
     * expires_in
     */
    public static final String WX_EXPIRE_IN = "expires_in";

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

    /**
     * 用户 openid
     */
    public static final String WX_OPENID = "openid";

    /**
     * refresh_token
     */
    public static final String WX_REFRESH_TOKEN = "refresh_token";

    /**
     * scope
     */
    public static final String WX_SCOPE = "scope";
}
