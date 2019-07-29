package com.klenio.communicatorbackend.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Confirguration {
    @Value("${accuweather.api.key}")
    private String accuweatherApiKey;

    @Value("${azure.api.key}")
    private String azureApiKey;

    @Value("${accuweather.api.city.search}")
    private String accuweatherApiCitySearch;

    @Value("${accuweather.api.current.conditions}")
    private String accuweatherApiCurrentConditions;

    @Value("${azure.api.url}")
    private String azureApiUrl;

    @Value("${azure.api.version}")
    private String azureApiVersion;
}
