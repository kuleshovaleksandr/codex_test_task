package com.codex.test_task.exception;

public class DBExecutionException extends RuntimeException {
    public DBExecutionException(String message) {
        super(message);
    }
}
