package com.yutori.server.exception;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException() {super("비밀번호 형식이 맞지 않습니다.");}
}
