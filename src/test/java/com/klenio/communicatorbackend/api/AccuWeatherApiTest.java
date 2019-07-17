package com.klenio.communicatorbackend.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccuWeatherApiTest {

    @Test
    public void getWeather() {
        //given
        AccuWeatherApi accuWeatherApi = new AccuWeatherApi();
        //when
        System.out.println(accuWeatherApi.getWeather("3"));
        //then

    }
}