package com.location.locationweather.service.openweather;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.location.locationweather.constants.Constants;
import com.location.locationweather.model.CenterPointLocation;
import com.location.locationweather.model.CurrentWeather;
import com.location.locationweather.model.openweather.Response;

@Service
@ConfigurationProperties(prefix = "openweatherapi")
public class OpenWeatherService {

	@Autowired
	private RestTemplate restTemplate;

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
	 * This method determines the current weather for the location coordinates that
	 * are given as input using OpenWeatherMap API
	 * 
	 * @param CenterPointLocation
	 * @return CurrentWeather
	 * @throws IOException
	 */
	public CurrentWeather getWeather(CenterPointLocation cpl) throws IOException {
		if (cpl != null) {

			UriComponentsBuilder builder = UriComponentsBuilder
					.fromHttpUrl(url)
					.queryParam(Constants.OPENWEATHERSERVICE_LATITUDE, cpl.getLatitude())
					.queryParam(Constants.OPENWEATHERSERVICE_LONGITUDE, cpl.getLongitude())
					.queryParam(Constants.OPENWEATHERSERVICE_UNITS, Constants.OPENWEATHERSERVICE_UNITS_VALUE)
					.queryParam(Constants.OPENWEATHERSERVICE_EXCLUDE, Constants.OPENWEATHERSERVICE_EXCLUDE_VALUE)
					.queryParam(Constants.OPENWEATHERSERVICE_APPID, apiKey);

			Response response = restTemplate.getForObject(builder.toUriString(), Response.class);

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
