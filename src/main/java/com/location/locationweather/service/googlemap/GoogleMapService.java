package com.location.locationweather.service.googlemap;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.location.locationweather.model.CenterPointLocation;
import com.location.locationweather.model.googlemap.Response;
import com.location.locationweather.constants.*;

@Service
@ConfigurationProperties(prefix = "googlemapapi")
public class GoogleMapService {
	
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
	 * 
	 * This Method determines the Geoghraphic center point using Google Maps
	 * 
	 * @param locationName
	 * @return CenterPointLocation
	 * @throws IOException
	 */
	public CenterPointLocation getCenterPointLocation(String locationName) throws IOException {
		if (locationName != null && !locationName.isEmpty()) {
			
		
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
			.queryParam(Constants.GOOGLEMAP_ADDRESS, locationName)
			.queryParam(Constants.GOOGLEMAP_KEY, apiKey);
			
			Response response = restTemplate.getForObject( builder.toUriString(),
					Response.class);
			
			
			if (response != null && "OK".equalsIgnoreCase(response.getStatus())&&response.getResults().size()>0) {
				CenterPointLocation cpl = new CenterPointLocation();
				
				//the first result from the API as the location of the city ("best match")
				cpl.setLatitude(response.getResults().get(0).getGeometry().getLocation().getLat());
				cpl.setLongitude(response.getResults().get(0).getGeometry().getLocation().getLng());
				return cpl;

			}
		}
		return null;

	}
}
