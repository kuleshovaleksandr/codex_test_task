package com.codex.test_task.exception;

public class ItemExistsInCartException extends RuntimeException {
    public ItemExistsInCartException(String message) {
        super(message);
    }
}
