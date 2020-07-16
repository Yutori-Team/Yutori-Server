package com.yutori.server.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum SentenceTypes {
    SENTENCE("문장"),
    SING("노래");

    private final String sentence;
}