package com.backend.metaphorce.exception;

public class Response {

    private String message;
    private int code;

    public Response(String message, int code){
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
