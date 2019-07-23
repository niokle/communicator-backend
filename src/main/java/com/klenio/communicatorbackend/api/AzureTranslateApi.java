package com.klenio.communicatorbackend.api;

import com.klenio.communicatorbackend.api.dto.TranslateDto;
import com.klenio.communicatorbackend.config.Confirguration;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AzureTranslateApi {
    @Autowired
    Confirguration confirguration;

    static private String url = "https://api.cognitive.microsofttranslator.com/translate?";
    static private String apiVersion = "api-version=3.0";

    public TranslateDto getTranslation(String textInput, String textOutputLanguage) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Text", textInput);

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject);

        String req = url + apiVersion + "&to=" + textOutputLanguage;
        HttpResponse<JsonNode> jsonResponse = Unirest.post(req)
                .header("Ocp-Apim-Subscription-Key", confirguration.getAzureApiKey())
                .header("Content-Type", "application/json")
                .body(jsonArray)
                .asJson();

        JSONArray jsonArrayResponse = jsonResponse.getBody().getArray();
        JSONObject jsonObjectResponse = jsonArrayResponse.getJSONObject(0);

        String textOutput = jsonObjectResponse.getJSONArray("translations").getJSONObject(0).getString("text");
        String textInputLanguage = jsonObjectResponse.getJSONObject("detectedLanguage").getString("language");

        return new TranslateDto(textInput, textInputLanguage, textOutput, textOutputLanguage);
    }
}
