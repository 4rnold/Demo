package com.arnold.febs.common.exception;

import com.arnold.febs.common.consts.FebsConstant;

public class FebsException extends RuntimeException {


    public FebsException() {
    }

    public FebsException(String msg) {
        super(msg);
    }

    public FebsException(Throwable cause) {
        super(cause);
    }

    public FebsException(String message, Throwable cause) {
        super(message, cause);
    }

    public FebsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
