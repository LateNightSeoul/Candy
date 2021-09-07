package com.example.candy.controller.challenge.dto;

import com.example.candy.domain.choice.Choice;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChoiceDto {

    @ApiModelProperty(value = "보기 번호", example = "1")
    private int seq;

    @ApiModelProperty(value = "보기 내용", example = "is는 be 동사이다")
    private String content;

}
