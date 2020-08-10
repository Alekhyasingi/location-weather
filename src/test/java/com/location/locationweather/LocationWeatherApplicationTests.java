package com.location.locationweather;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.location.locationweather.model.CenterPointLocation;
import com.location.locationweather.model.CurrentWeather;
import com.location.locationweather.model.Response;

@SpringBootTest
@AutoConfigureMockMvc
class LocationWeatherApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getLocationWeatherTest() throws Exception {

		CenterPointLocation gcp = new CenterPointLocation(51.5073509, -0.1277583);

		CenterPointLocation hwg = new CenterPointLocation(51.50643, -0.12721);

		CenterPointLocation osm = new CenterPointLocation(51.5073219, -0.1276474);

		CurrentWeather cw = new CurrentWeather(27.15, "scattered clouds and humidity will be 51%");
		Response response = new Response(gcp, hwg, osm, cw);

		ObjectMapper mapper = new ObjectMapper();

		this.mockMvc.perform(get("/location/getWeather?locationName=LONDON")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().json(mapper.writeValueAsString(response)));
	}

}
