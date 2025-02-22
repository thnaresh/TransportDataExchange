package com.transportdataexchange.bogdan.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private boolean success;
    private String message;
    private LocalDateTime timestamp;
    private String path;
    private String error;
    private int status;

    public ErrorResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponse(boolean success, String message, String error, String path, int status) {
        this.success = success;
        this.message = message;
        this.error = error;
        this.path = path;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
}