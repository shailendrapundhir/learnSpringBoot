package com.conservesoftwares.exceptions;

import java.util.function.Supplier;

/**
 * Created by shailendra on 7/4/17.
 */
public class FailedToLoginException extends RuntimeException {
    public FailedToLoginException(String username) {
        super("Failed to login user "+username);
    }
}
