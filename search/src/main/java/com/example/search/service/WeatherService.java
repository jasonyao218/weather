package com.example.search.service;

import com.example.search.pojo.City;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public interface WeatherService {
    List<Map<String, Map>> findCityIdByName(List<String> cities);
    Map<String, Map> findCityNameById(int id);
}
