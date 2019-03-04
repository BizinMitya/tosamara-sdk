package com.github.useful_solutions.tosamara_sdk.exception;

public class APIResponseException extends Exception {

    public static final String RESPONSE_BODY_IS_NULL = "Body of response is null!";
    private int code;

    public APIResponseException(int code) {
        super("Response code is " + code);
        this.code = code;
    }

    public APIResponseException(String message) {
        super(message);
    }

    public int getCode() {
        return code;
    }
}
