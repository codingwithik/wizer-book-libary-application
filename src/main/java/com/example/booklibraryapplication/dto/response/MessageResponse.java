package com.example.booklibraryapplication.dto.response;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class MessageResponse {

    private String message;
    private boolean status;

    public MessageResponse(String message) {
        this.message = message;
    }

}
