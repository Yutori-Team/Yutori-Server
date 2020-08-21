package com.yutori.server.dto;

import com.yutori.server.domain.WrongAnswer;
import lombok.Data;

@Data
public class ResWrongDto {
    private String mySentence;
    private String answer;

    public static ResWrongDto from(WrongAnswer wrongAnswer) {
        ResWrongDto resWrongDto = new ResWrongDto();
        resWrongDto.mySentence = wrongAnswer.getMySentence();
        resWrongDto.answer = wrongAnswer.getAnswer();
        return resWrongDto;
    }
}
