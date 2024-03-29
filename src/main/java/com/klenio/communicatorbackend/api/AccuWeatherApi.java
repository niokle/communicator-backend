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

    public String getKeyLocation(String cityName) {
        String req = confirguration.getAccuweatherApiCitySearch() + "?apikey=" + confirguration.getAccuweatherApiKey() + "&q=" + cityName;
        HttpResponse<JsonNode> jsonResponse = Unirest.get(req)
                .asJson();

        //todo rzeczywista implementacja

        return "274663";
    }

    public WeatherDto getWeather(String keyLocation) {
        String req = confirguration.getAccuweatherApiCurrentConditions() + keyLocation + "?apikey=" + confirguration.getAccuweatherApiKey();
        HttpResponse<JsonNode> jsonResponse = Unirest.get(req)
                .asJson();

        JSONArray jsonArray = jsonResponse.getBody().getArray();
        JSONObject jsonObject = jsonArray.getJSONObject(0);

        try {
            Double temperatureMetricValue = jsonObject.getJSONObject("Temperature").getJSONObject("Metric").getDouble("Value");
            String temperatureMetricUnit = jsonObject.getJSONObject("Temperature").getJSONObject("Metric").getString("Unit");
            Integer weatherIcon = jsonObject.getInt("WeatherIcon");
            return new WeatherDto(temperatureMetricValue, temperatureMetricUnit, weatherIcon);
        } catch (Exception e) {
            return null;
        }
    }
}
