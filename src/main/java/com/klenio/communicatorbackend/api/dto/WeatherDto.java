package com.klenio.communicatorbackend.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WeatherDto {
    private Double temperature;
    private String unit;
    private Integer icon;
}
