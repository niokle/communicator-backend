package com.klenio.communicatorbackend.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TranslateDto {
    private String textInput;
    private String textInputLanguage;
    private String textOutput;
    private String textOutputLanguage;
}
