package com.springrest.springrest.controller;

public class CustomException extends Exception{
    public CustomException() {
        super("my own exception");
    }
}
