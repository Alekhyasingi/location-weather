# location-weather API 
This is a API to determine the geographic center point based on geocode API google Map, HERE WeGo, Open Street Map and determine the Weather from OpenWeatherMap API using the coordinates receives from the geocoding APIs

#Prerequisite
1. JAVA 8
2. Maven
3.Tomcat

#Instruction to run the project
1. Clone the repository using the below command,

git clone https://github.com/Alekhyasingi/location-weather.git

2. Import the project into your IDE. Replace the application.properties files to below format


googlemapapi.url=https://maps.googleapis.com/maps/api/geocode/json
googlemapapi.apiKey=************************************

herewegoapi.url=https://geocoder.ls.hereapi.com/search/6.2/geocode.json
herewegoapi.apiKey=************************************



openstreetmapapi.url=https://api.opencagedata.com/geocode/v1/json
openstreetmapapi.apiKey=************************************


openweatherapi.url=http://api.openweathermap.org/data/2.5/onecall
openweatherapi.apiKey=************************************



3.Give maven clean install.
$.Deploy the project into your tomcat server.

#Accessing the API
1. Once the code is deployed to server , open Postman to Test the API.
2. Enter the following URL as a GET request,
  localhost:8080/location/getWeather?locationName=<Your Location>

Example:
localhost:8080/location/getWeather?locationName=LONDON

Output:
{
"googleMapsCenterPoint:"
{
 latitude=51.5073509,
 longitude=-0.1277583
}
"hereWeGoCenterPoint:"
{
 latitude=51.50643,
 longitude=-0.12721
}
"openStreetMapCenterPoint:"
{
 latitude=51.5073219,
 longitude=-0.1276474
},
 "currentWeather":
 { 
 temperature=27.02° Celsuis,
 description=clear sky and humidity will be 61%
}
}




