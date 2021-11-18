package com.example.detail.service;

import com.example.detail.config.EndPointConfig;
import com.example.detail.pojo.City;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetailServiceImp implements DetailService{

    private final RestTemplate restTemplate;

    public DetailServiceImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @Retryable(include = IllegalAccessError.class)
    public List<Integer> findCityIdByName(List<String> cities) {
        List<Integer> ans = new ArrayList<>();
        for(String city: cities) {
            City[] temp = restTemplate.getForObject(EndPointConfig.queryWeatherByCity + city, City[].class);
            for(City c: temp) {
                if(c != null && c.getWoeid() != null) {
                    ans.add(c.getWoeid());
                }
            }
        }
        return ans;
    }
}
