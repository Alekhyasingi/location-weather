package com.location.locationweather.service.herewego;

import java.io.IOException;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.location.locationweather.model.CenterPointLocation;
import com.location.locationweather.model.herewego.Response;

@Service
@ConfigurationProperties(prefix = "herewegoapi")
public class HereWeGoService {

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
	 * This Method determines the Geoghraphic center point using HERE WeGo API
	 * 
	 * @param locationName
	 * @return CenterPointLocation
	 * @throws IOException
	 */
	public CenterPointLocation getCenterPointLocation(String locationName) throws IOException {
		if (locationName != null && !locationName.isEmpty()) {
			RestTemplate restTemplate = new RestTemplate();
			Response response = restTemplate.getForObject(
					url + "?languages=en-US&maxresults=4&searchtext=" + locationName + "&apiKey=" + apiKey,
					Response.class);
			if (response != null && response.getResponse().getView().size() > 0) {
				CenterPointLocation cpl = new CenterPointLocation();

//the first result from the API as the location of the city ("best match")
				cpl.setLatitude(response.getResponse().getView().get(0).getResult().get(0).getLocation()
						.getDisplayPosition().getLatitude());
				cpl.setLongitude(response.getResponse().getView().get(0).getResult().get(0).getLocation()
						.getDisplayPosition().getLongitude());
				return cpl;
			}
		}
		return null;
	}

}
