package com.work.exception;

import com.work.entity.Task;

public class TaskException extends Exception {
    public TaskException() {
    }

    public TaskException(String message) {
        super(message);
    }
}
