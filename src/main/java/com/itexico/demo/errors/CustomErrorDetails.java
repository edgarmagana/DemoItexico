package com.itexico.demo.errors;

import java.time.LocalDateTime;

public class CustomErrorDetails {
    private LocalDateTime timeStamp;
    private String message;

    public CustomErrorDetails(LocalDateTime timeStamp, String message) {
        this.timeStamp = timeStamp;
        this.message =message;
    }


    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

}
