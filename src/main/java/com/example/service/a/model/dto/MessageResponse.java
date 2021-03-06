package com.example.service.a.model.dto;

import lombok.Getter;

import java.io.Serializable;

public class MessageResponse implements Serializable {

    @Getter
    private final String message;

    public MessageResponse(String message) {
        this.message = message;
    }
}
