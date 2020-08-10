package com.location.locationweather.resource;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.location.locationweather.constants.Constants;
import com.location.locationweather.exception.NoResponseFoundException;
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
	public Response getLocationWeather(@RequestParam(value = Constants.LOCATION_NAME) String locationName)
			throws IOException {
		try {
			return locationWeatherService.getLocationWeather(locationName);

		} catch (NoResponseFoundException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.ERROR, exc);
		}
	}

}
