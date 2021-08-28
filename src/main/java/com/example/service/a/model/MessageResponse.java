package com.example.service.a.model;

import lombok.Getter;

import java.io.Serializable;

public class MessageResponse implements Serializable {

    @Getter
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }
}
