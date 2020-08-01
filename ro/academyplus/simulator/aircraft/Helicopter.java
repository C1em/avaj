package ro.academyplus.simulator.aircraft;

import ro.academyplus.simulator.tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}
	private Coordinates	changeCoordinates(Coordinates coordinates, String weather)
	{
		int longitude = coordinates.getLongitude();
		int latitude = coordinates.getLatitude();
		int height = coordinates.getHeight();
		System.out.println("Helicopter#" + this.name + "(" + this.id + "): " + weather);
		if (weather.equals("SUN"))
		{
			longitude += 10;
			height += 2;
		}
		else if (weather.equals("RAIN"))
			latitude += 5;
		else if (weather.equals("FOG"))
			longitude += 1;
		else if (weather.equals("SNOW"))
			height -= 12;
		if (height > 100)
			height = 100;
		return(new Coordinates(longitude, latitude, height));
	}
	@Override
	public void			updateConditions()
	{
		String weather = weatherTower.getWeather(this.coordinates);
		this.coordinates = changeCoordinates(this.coordinates, weather);
		if (this.coordinates.getHeight() <= 0)
		{
			System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower.");
			weatherTower.unregister(this);
		}
	}
	@Override
	public void			registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
	}
}
