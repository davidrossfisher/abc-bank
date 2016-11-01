package com.abc;

/*
* Last modified by David Fisher on 10/31/2016.
 */
public class CustomerAlreadyAddedException extends Exception {
    private static final long serialVersionUID = 199753363232807001L;

    public CustomerAlreadyAddedException() {}

    public CustomerAlreadyAddedException(String message) {
        super(message);
    }

    public CustomerAlreadyAddedException(Throwable cause) {
        super(cause);
    }

    public CustomerAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerAlreadyAddedException(String message, Throwable cause, boolean enableSuppression,
                                         boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

