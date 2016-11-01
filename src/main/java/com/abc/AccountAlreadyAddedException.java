package com.abc;

/*
* Last modified by David Fisher on 10/31/2016.
 */
public class AccountAlreadyAddedException extends Exception {
    private static final long serialVersionUID = 199753363232807009L;

    public AccountAlreadyAddedException() {}

    public AccountAlreadyAddedException(String message) {
        super(message);
    }

    public AccountAlreadyAddedException(Throwable cause) {
        super(cause);
    }

    public AccountAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountAlreadyAddedException(String message, Throwable cause, boolean enableSuppression,
                                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

