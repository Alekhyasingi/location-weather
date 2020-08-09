package com.location.locationweather.service.openweather;

import java.io.IOException;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.location.locationweather.model.CenterPointLocation;
import com.location.locationweather.model.CurrentWeather;
import com.location.locationweather.model.openweather.Response;

@Service
@ConfigurationProperties(prefix = "openweatherapi")
public class OpenWeatherService {

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private String apiKey;

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	
	/**
	 * This method determines the current weather
	 * for the location coordinates that are given as
	 * input using OpenWeatherMap API
	 * @param CenterPointLocation 
	 * @return CurrentWeather
	 * @throws IOException
	 */
	public CurrentWeather getWeather(CenterPointLocation cpl) throws IOException {
		if (cpl != null) {
			RestTemplate restTemplate = new RestTemplate();
			Response response = restTemplate.getForObject(url + "?lat=" + cpl.getLatitude() + "&lon="
					+ cpl.getLongitude() + "&units=metric&exclude=minutely,hourly,daily&appid=" + apiKey,
					Response.class);
			if (response != null && response.getCurrent() != null) {
				CurrentWeather weather = new CurrentWeather();
				weather.setTemperature(response.getCurrent().getTemp());
				weather.setDescription(response.getCurrent());
				return weather;
			}
		}
		return null;

	}
}
