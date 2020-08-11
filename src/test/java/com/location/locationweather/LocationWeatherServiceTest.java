package com.location.locationweather;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.location.locationweather.exception.NoResponseFoundException;
import com.location.locationweather.model.CenterPointLocation;
import com.location.locationweather.model.CurrentWeather;
import com.location.locationweather.model.Response;
import com.location.locationweather.service.LocationWeatherService;
import com.location.locationweather.service.googlemap.GoogleMapService;
import com.location.locationweather.service.herewego.HereWeGoService;
import com.location.locationweather.service.openstreetmap.OpenStreetMapService;
import com.location.locationweather.service.openweather.OpenWeatherService;

/**
 * Class to test the service layer after 
 * moking the dependent service classes
 *
 */
@ExtendWith(SpringExtension.class)
public class LocationWeatherServiceTest {

	@TestConfiguration
	static class LocationWeatherServiceTestContextConfiguration {

		@Bean
		public LocationWeatherService service() {
			return new LocationWeatherService();
		}
	}

	@Autowired
	LocationWeatherService service;
	@MockBean
	private GoogleMapService googleMapService;

	@MockBean
	private HereWeGoService hereweGoService;

	@MockBean
	private OpenStreetMapService openStreetMapService;

	@MockBean
	private OpenWeatherService openWeatherService;

	/**
	 * Testing service layer with mocked values
	 * @throws IOException
	 * @throws NoResponseFoundException
	 */
	@Test
	public void getLocationWeatherTest() throws IOException, NoResponseFoundException {
		String locationName = "LONDON";

		CenterPointLocation gcp = new CenterPointLocation(51.5073509, -0.1277583);

		Mockito.when(googleMapService.getCenterPointLocation(locationName)).thenReturn(gcp);

		CenterPointLocation hwg = new CenterPointLocation(51.50643, -0.12721);

		Mockito.when(hereweGoService.getCenterPointLocation(locationName)).thenReturn(hwg);

		CenterPointLocation osm = new CenterPointLocation(51.5073219, -0.1276474);

		Mockito.when(openStreetMapService.getCenterPointLocation(locationName)).thenReturn(osm);

		CurrentWeather cw = new CurrentWeather(33.51, "scattered clouds and humidity will be 41%");
		Mockito.when(openWeatherService.getWeather(gcp)).thenReturn(cw);

		Response res = service.getLocationWeather(locationName);

		assertThat(res).isNotNull();
	}

	/**
	 * 
	 * Testing user defined exception
	 * @throws IOException
	 */
	@Test
	public void getLocationWeatherTest_NoResponseFoundException() throws IOException {
		String locationName = null;

		Exception exception = assertThrows(NoResponseFoundException.class, () -> {
			service.getLocationWeather(locationName);
		});

		assertThat(exception).isInstanceOf(NoResponseFoundException.class);
	}

}
