package com.klenio.communicatorbackend.api;

import com.klenio.communicatorbackend.api.dto.WeatherDto;
import com.klenio.communicatorbackend.config.Confirguration;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccuWeatherApi {
    @Autowired
    private Confirguration confirguration;

    private static String citySearch = "http://dataservice.accuweather.com/locations/v1/cities/search";
    private static String currentConditions = "http://dataservice.accuweather.com/currentconditions/v1/";

    public String getKeyLocation(String cityName) {
        String req = citySearch + "?apikey=" + confirguration.getAccuweatherApiKey() + "&q=" + cityName;
        HttpResponse<JsonNode> jsonResponse = Unirest.get(req)
                .asJson();

        //JSONObject jsonObject = jsonResponse.getBody().getObject();

        //while (jsonResponse.getBody().getObject().keys().hasNext()) {
        System.out.println(jsonResponse.getBody().toString());
        //}

        return "274663";
    }

    public WeatherDto getWeather(String keyLocation) {
        String req = currentConditions + getKeyLocation("test") + "?apikey=" + confirguration.getAccuweatherApiKey();
        HttpResponse<JsonNode> jsonResponse = Unirest.get(req)
                .asJson();

        JSONArray jsonArray = jsonResponse.getBody().getArray();
        JSONObject jsonObject = jsonArray.getJSONObject(0);

        Double temperatureMetricValue = jsonObject.getJSONObject("Temperature").getJSONObject("Metric").getDouble("Value");
        String temperatureMetricUnit = jsonObject.getJSONObject("Temperature").getJSONObject("Metric").getString("Unit");
        Integer weatherIcon = jsonObject.getInt("WeatherIcon");

        return new WeatherDto(temperatureMetricValue, temperatureMetricUnit, weatherIcon);
    }
}
