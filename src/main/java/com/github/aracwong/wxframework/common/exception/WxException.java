package com.github.aracwong.wxframework.common.exception;

/**
 * @author zpwang
 * @version 1.0.0
 */
public class WxException extends RuntimeException {

    public WxException() {
        super();
    }

    public WxException(String message) {
        super(message);
    }

    public WxException(String message, Throwable cause) {
        super(message, cause);
    }

    public WxException(Throwable cause) {
        super(cause);
    }

    protected WxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
