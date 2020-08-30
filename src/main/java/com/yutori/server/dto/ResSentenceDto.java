package com.yutori.server.dto;

import com.yutori.server.domain.Sentence;
import lombok.Data;

@Data
public class ResSentenceDto {
    private Long sentenceId;
    private String sentence;

    public static ResSentenceDto from(Sentence sentence) {
        ResSentenceDto resSentenceDto = new ResSentenceDto();
        resSentenceDto.sentenceId = sentence.getId();
        resSentenceDto.sentence = sentence.getText();
        return resSentenceDto;
    }
}
