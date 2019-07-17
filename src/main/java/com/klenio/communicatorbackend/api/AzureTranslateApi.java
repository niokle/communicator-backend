package com.klenio.communicatorbackend.api;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.json.JSONArray;
import org.json.JSONObject;

public class AzureTranslateApi {
    //todo
    static private String apiKey = "08306b0d4d514e47a0e88f6f8eeebbe2";
    static private String url = "https://api.cognitive.microsofttranslator.com/translate?";
    static private String apiVersion = "api-version=3.0";

    public String getTranslation(String sourceText, String languageCode) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Text", sourceText);

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject);

        String req = url + apiVersion + "&to=" + languageCode;
        HttpResponse<JsonNode> jsonResponse = Unirest.post(req)
                .header("Ocp-Apim-Subscription-Key", apiKey)
                .header("Content-Type", "application/json")
                .body(jsonArray)
                .asJson();
        return jsonResponse.getBody().toString();
    }
}
