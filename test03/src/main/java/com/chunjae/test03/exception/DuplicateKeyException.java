package com.chunjae.test03.exception;

// 유일한 필드 = Unique(키)
public class DuplicateKeyException extends RuntimeException {

    public DuplicateKeyException(String message) {
        super(message);
    }

}