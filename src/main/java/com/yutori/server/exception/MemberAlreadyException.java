package com.yutori.server.exception;

public class MemberAlreadyException extends RuntimeException {
    public MemberAlreadyException(){
        super("이미 가입한 사용자입니다.");
    }
}
