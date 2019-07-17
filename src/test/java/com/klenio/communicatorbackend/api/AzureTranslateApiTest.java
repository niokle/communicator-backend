package com.klenio.communicatorbackend.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AzureTranslateApiTest {

    @Test
    public void getTranslation() {
        //given
        AzureTranslateApi azureTranslateApi = new AzureTranslateApi();
        String textToTranslate = "Hi, how are you?";
        String languageCode = "pl";

        //when
        String result = azureTranslateApi.getTranslation(textToTranslate, languageCode);

        //then
        System.out.println(result);
    }

    @Test
    public void getAuthorisation() {
        //given
        AzureTranslateApi azureTranslateApi = new AzureTranslateApi();

        //when
        //String result = azureTranslateApi.getAuthorisationToken();

        //then
        //System.out.println(result);
    }
}