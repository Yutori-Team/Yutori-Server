package com.yutori.server.exception;

public class MemberAlreadyExistException extends RuntimeException {
    public MemberAlreadyExistException(){
        super("이미 가입한 사용자입니다.");
    }
}
