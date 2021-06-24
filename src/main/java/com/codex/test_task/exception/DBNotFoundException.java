package com.codex.test_task.exception;

public class DBNotFoundException extends RuntimeException {
    public DBNotFoundException(String message) {
        super(message);
    }
}
