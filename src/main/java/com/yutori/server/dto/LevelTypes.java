package com.yutori.server.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum LevelTypes {
    TOP("상"),
    MIDDLE("중"),
    LOW("하");

    private final String level;
}
