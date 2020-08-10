package com.location.locationweather;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.location.locationweather.resource.LocationResource;
import com.location.locationweather.service.LocationWeatherService;

@SpringBootTest
public class LocationResourceIntegrationTest {
  
    @MockBean
    private LocationWeatherService service;
    
    @Autowired
    private LocationResource resource;
    
    @Test
	public void contexLoads() throws Exception {
		assertThat(resource).isNotNull();
	}
    
}
