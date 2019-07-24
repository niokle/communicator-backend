package com.klenio.communicatorbackend.api;

import com.klenio.communicatorbackend.api.dto.WeatherDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccuWeatherApiTest {
    @Autowired
    AccuWeatherApi accuWeatherApi;

    @Test
    public void getWeather() {
        //given
        String keyLocation1 = "274663";
        String keyLocation2 = "abcd";

        //when
        WeatherDto weatherDto1 = accuWeatherApi.getWeather(keyLocation1);
        WeatherDto weatherDto2 = accuWeatherApi.getWeather(keyLocation2);

        //then
        Assert.assertNotNull(weatherDto1);
        Assert.assertNull(weatherDto2);
    }

    @Test
    public void getKeyLocation() {
        //given

        //when

        //then
    }
}