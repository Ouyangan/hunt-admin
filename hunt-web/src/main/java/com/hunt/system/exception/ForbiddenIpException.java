package com.hunt.system.exception;

/**
 * @Author ouyangan
 * @Date 2016/10/29/17:32
 * @Description
 */
public class ForbiddenIpException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ForbiddenIpException(String message) {
        super(message);
    }
}
