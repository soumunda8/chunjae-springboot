package com.chunjae.test05.exception;

// 유일한 필드 = Unique(키)
public class DuplicateKeyException extends RuntimeException {
    public DuplicateKeyException(String message) {
        super(message);
    }

}