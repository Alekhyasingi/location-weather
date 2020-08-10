package com.location.locationweather.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.locationweather.exception.NoResponseFoundException;
import com.location.locationweather.model.CenterPointLocation;
import com.location.locationweather.model.CurrentWeather;
import com.location.locationweather.model.Response;
import com.location.locationweather.service.googlemap.GoogleMapService;
import com.location.locationweather.service.herewego.HereWeGoService;
import com.location.locationweather.service.openstreetmap.OpenStreetMapService;
import com.location.locationweather.service.openweather.OpenWeatherService;

@Service
public class LocationWeatherService {

	@Autowired
	GoogleMapService googleMapService;

	@Autowired
	HereWeGoService hereWeGoService;

	@Autowired
	OpenWeatherService openWeatherService;

	@Autowired
	OpenStreetMapService openStreetMapService;

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Response getLocationWeather(String locationName) throws IOException, NoResponseFoundException {
		if (locationName.isEmpty())
			throw new NoResponseFoundException();

		if (locationName.contains(" "))
			locationName = locationName.replace(" ", "+");

		CenterPointLocation gcp = googleMapService.getCenterPointLocation(locationName);

		CenterPointLocation hwg = hereWeGoService.getCenterPointLocation(locationName);

		CenterPointLocation osm = openStreetMapService.getCenterPointLocation(locationName);

		if (gcp == null && hwg == null && osm == null)
			throw new NoResponseFoundException();

		CurrentWeather currWeather = openWeatherService
				.getWeather(gcp != null ? gcp : (hwg != null ? hwg : (osm != null ? osm : null)));

		return new Response(gcp, hwg, osm, currWeather);

	}

	public String replace(String str) {
		String[] words = str.split(" ");
		StringBuilder sentence = new StringBuilder(words[0]);

		for (int i = 1; i < words.length; ++i) {
			sentence.append("%20");
			sentence.append(words[i]);
		}

		return sentence.toString();
	}

}
