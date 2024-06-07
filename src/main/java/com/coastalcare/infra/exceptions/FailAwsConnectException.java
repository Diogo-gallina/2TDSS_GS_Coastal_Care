package com.coastalcare.infra.exceptions;

public class FailAwsConnectException extends RuntimeException{

    public FailAwsConnectException(String message) {
        super(message);
    }

}
