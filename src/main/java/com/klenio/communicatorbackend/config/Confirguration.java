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
}
