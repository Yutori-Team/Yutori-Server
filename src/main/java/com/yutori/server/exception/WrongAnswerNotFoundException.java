package com.yutori.server.exception;

public class WrongAnswerNotFoundException extends RuntimeException {
    public WrongAnswerNotFoundException() {super("틀린 문장이 아닙니다.");}
}
