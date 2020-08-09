package com.location.locationweather.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.location.locationweather.model.Response;
import com.location.locationweather.service.LocationWeatherService;
import com.location.locationweather.service.googlemap.GoogleMapService;
import com.location.locationweather.service.herewego.HereWeGoService;
import com.location.locationweather.service.openstreetmap.OpenStreetMapService;
import com.location.locationweather.service.openweather.OpenWeatherService;

@RestController
@RequestMapping("/location")
public class LocationResource {

	@Autowired
	GoogleMapService googleMapService;

	@Autowired
	HereWeGoService hereWeGoService;

	@Autowired
	OpenWeatherService openWeatherService;

	@Autowired
	OpenStreetMapService openStreetMapService;

	@Autowired
	LocationWeatherService locationWeatherService;

	@GetMapping("/getWeather")
	public String getLocationWeather(@RequestParam(value = "locationName", defaultValue = "World") String locationName)
			throws IOException {
		Response response= locationWeatherService.getLocationWeather(locationName);
		
		return response!=null?response.toString():"ERROR";
	}


}
