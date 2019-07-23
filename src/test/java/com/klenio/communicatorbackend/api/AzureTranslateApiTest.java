package com.klenio.communicatorbackend.api;

import com.klenio.communicatorbackend.api.dto.TranslateDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AzureTranslateApiTest {
    @Autowired
    private AzureTranslateApi azureTranslateApi;

    @Test
    public void getTranslation() {
        //given
        String textInput = "Hi how are you?";
        String textOutputLanguage = "pl";

        //when
        TranslateDto translateDto = azureTranslateApi.getTranslation(textInput, textOutputLanguage);

        //then
        Assert.assertEquals("Cześć jak się masz?", translateDto.getTextOutput());
        Assert.assertEquals("en", translateDto.getTextInputLanguage());
    }
}