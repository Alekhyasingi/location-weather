package com.location.locationweather.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Response getLocationWeather(String locationName) throws IOException {
	
		  
		  CenterPointLocation gcp=googleMapService.getCenterPointLocation(locationName);
		  
		  CenterPointLocation hwg=hereWeGoService.getCenterPointLocation(locationName);
		  
		  CenterPointLocation osm=openStreetMapService.getCenterPointLocation(locationName);
		  
		  if(gcp==null&&hwg==null&&osm==null)
			  return null;
		  
		  CurrentWeather currWeather = openWeatherService.getWeather(gcp!=null?gcp:(hwg!=null?hwg:(osm!=null?osm:null)));
		  
		  
		  return new Response(gcp, hwg, osm, currWeather);
		
		 
	
	}

	

	
	
}
