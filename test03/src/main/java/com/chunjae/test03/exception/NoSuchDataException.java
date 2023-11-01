package com.chunjae.test03.exception;

public class NoSuchDataException extends RuntimeException {

    public NoSuchDataException(String message) {
        super(message);
    }

}