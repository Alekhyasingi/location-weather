package com.location.locationweather.model;

public class Response {

	
	public CenterPointLocation googleMapsCenterPoint ;
	  
	public CenterPointLocation hereWeGoCenterPoint;
	  
	public CenterPointLocation openStreetMapCenterPoint;
	
	public CurrentWeather currentWeather;

	
	
	public Response(CenterPointLocation googleMapsCenterPoint, CenterPointLocation hereWeGoCenterPoint,
			CenterPointLocation openStreetMapCenterPoint, CurrentWeather currentWeather) {
		super();
		this.googleMapsCenterPoint = googleMapsCenterPoint;
		this.hereWeGoCenterPoint = hereWeGoCenterPoint;
		this.openStreetMapCenterPoint = openStreetMapCenterPoint;
		this.currentWeather = currentWeather;
	}



	public CenterPointLocation getGoogleMapsCenterPoint() {
		return googleMapsCenterPoint;
	}



	public void setGoogleMapsCenterPoint(CenterPointLocation googleMapsCenterPoint) {
		this.googleMapsCenterPoint = googleMapsCenterPoint;
	}



	public CenterPointLocation getHereWeGoCenterPoint() {
		return hereWeGoCenterPoint;
	}



	public void setHereWeGoCenterPoint(CenterPointLocation hereWeGoCenterPoint) {
		this.hereWeGoCenterPoint = hereWeGoCenterPoint;
	}



	public CenterPointLocation getOpenStreetMapCenterPoint() {
		return openStreetMapCenterPoint;
	}



	public void setOpenStreetMapCenterPoint(CenterPointLocation openStreetMapCenterPoint) {
		this.openStreetMapCenterPoint = openStreetMapCenterPoint;
	}



	public CurrentWeather getCurrentWeather() {
		return currentWeather;
	}



	public void setCurrentWeather(CurrentWeather currentWeather) {
		this.currentWeather = currentWeather;
	}



	@Override
	public String toString() {
		if(googleMapsCenterPoint==null&hereWeGoCenterPoint==null&&openStreetMapCenterPoint==null)
			return "ERROR";
		String gmcp = (googleMapsCenterPoint!=null)?"\n\"googleMapsCenterPoint:\"" + googleMapsCenterPoint :"";
		String hwgcp = (hereWeGoCenterPoint!=null)?"\n\"hereWeGoCenterPoint:\"" + hereWeGoCenterPoint :"";
		String osmcp = (openStreetMapCenterPoint!=null)?"\n\"openStreetMapCenterPoint:\"" + openStreetMapCenterPoint :"";
		String cw = ",\n \"currentWeather\":" + currentWeather + "\n}";
		
		return "{"+gmcp+hwgcp+osmcp+cw;	
		
	}
	
}
