package com.yutori.server.dto;

import com.yutori.server.domain.Sentence;
import lombok.Data;

@Data
public class ResSentenceDto {
    private String sentence;

    public static ResSentenceDto from(Sentence sentence) {
        ResSentenceDto resSentenceDto = new ResSentenceDto();
        resSentenceDto.sentence = sentence.getText();
        return resSentenceDto;
    }
}
