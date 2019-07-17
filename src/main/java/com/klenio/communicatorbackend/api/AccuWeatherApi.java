package com.klenio.communicatorbackend.api;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.json.JSONObject;

public class AccuWeatherApi {
    //todo
    private static String apiKey = "";
    private static String citySearch = "http://dataservice.accuweather.com/locations/v1/cities/search"; //?apikey=&q=
    private static String currentConditions = "http://dataservice.accuweather.com/currentconditions/v1/"; //{loc}?apikey=

    public String getKeyLocation(String cityName) {

        return "274663";
    }

    public String getWeather(String keyLocation) {
        String req = currentConditions + getKeyLocation("test") + "?apikey=" + apiKey;
        HttpResponse<JsonNode> jsonResponse = Unirest.get(req)
                //.routeParam("method", "get")
                //.queryString("name", "Mark")
                .asJson();

        JSONObject jsonObject = new JSONObject();

        //System.out.println(jsonResponse.getBody());
        jsonObject = jsonResponse.getBody().getObject();

        jsonObject.keys().forEachRemaining(a -> System.out.println(a));

        return jsonResponse.getBody().toString();
    }
}
