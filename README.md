# location-weather API 
This is a API to determine the geographic center point based on geocode API google Map, HERE WeGo, Open Street Map and determine the Weather from OpenWeatherMap API using the coordinates receives from the geocoding APIs

# Prerequisite
1. JAVA 8<br/>
2. Maven<br/>
3. Tomcat<br/>

# Instruction to run the project
1. Clone the repository using the below command,

git clone https://github.com/Alekhyasingi/location-weather.git

2. Import the project into your IDE. Replace the application.properties files to below format


googlemapapi.url=************************************ <br/>
googlemapapi.apiKey=************************************

herewegoapi.url=************************************ <br/>
herewegoapi.apiKey=************************************



openstreetmapapi.url=************************************ <br/>
openstreetmapapi.apiKey=************************************


openweatherapi.url=************************************ <br/>
openweatherapi.apiKey=************************************

3. Disable @SpringBootTest annotation in LocationWeatherApplicationTests.java, as it starts the server in same port for the test case
3. Give mvn clean install.<br/>
4. Deploy the project into your tomcat server.

# Accessing the API
1. Once the code is deployed to server , open Postman to Test the API.
2. Enter the following URL as a GET request,
  localhost:8080/location/getWeather?locationName=<Your Location>

Example:
localhost:8080/location/getWeather?locationName=LONDON

Output:
{ <br/>
    "googleMapsCenterPoint": { <br/>
        "latitude": 51.5073509, <br/>
        "longitude": -0.1277583 <br/>
    }, <br/>
    "hereWeGoCenterPoint": { <br/>
        "latitude": 51.50643, <br/>
        "longitude": -0.12721 <br/>
    }, <br/>
    "openStreetMapCenterPoint": { <br/>
        "latitude": 51.5073219 <br/>
        "longitude": -0.1276474 <br/>
    }, <br/>
    "currentWeather": { <br/>
        "temperature": 21.74, <br/>
        "description": "overcast clouds and humidity will be 78%" <br/>
    } <br/>
} <br/>

# Test Case classes
Functionality can be tested using the below classes.

LocationResourceIntegrationTest.java <br/>
LocationWeatherApplicationTests.java <br/>
LocationWeatherServiceTest.java

Note: Enable @SpringBootTest annotation in LocationWeatherApplicationTests.java also please change the inputfields for CurrentWeather cw object in LocationWeatherApplicationTests.java before testing as it received the values from the actual API





