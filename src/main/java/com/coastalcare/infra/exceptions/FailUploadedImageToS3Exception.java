package com.coastalcare.infra.exceptions;

public class FailUploadedImageToS3Exception extends RuntimeException{
    public FailUploadedImageToS3Exception(String message) {
        super(message);
    }
}
