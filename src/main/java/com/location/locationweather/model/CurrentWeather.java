package com.location.locationweather.model;

import com.location.locationweather.model.openweather.Current;

public class CurrentWeather {

	private Double temperature;

	private String description;

	public CurrentWeather() {
	}

	public CurrentWeather(Double temperature, String description) {

		this.temperature = temperature;
		this.description = description;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDescription(Current current) {
		this.description = current.getWeather().get(0).getDescription() + " and humidity will be "
				+ current.getHumidity() + "%";

	}

}
