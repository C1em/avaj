package ro.academyplus.simulator.tower;

import ro.academyplus.simulator.aircraft.Coordinates;

public class WeatherProvider
{
	private static WeatherProvider	weatherProvider = new WeatherProvider();
	private static String			weather[] = {"RAIN", "FOG", "SUN", "SNOW"};

	private							WeatherProvider(){}

	public static WeatherProvider	getProvider()
	{
		return (weatherProvider);
	}
	public String					getCurrentWeather(Coordinates coordinates)
	{
		int res = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
		return (weather[((res * 2) / 3) % 4]);
	}
}
