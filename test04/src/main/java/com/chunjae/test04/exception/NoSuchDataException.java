package com.chunjae.test04.exception;

public class NoSuchDataException extends RuntimeException {

    public NoSuchDataException(String message) {
        super(message);
    }

}