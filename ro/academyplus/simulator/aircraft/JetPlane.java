package ro.academyplus.simulator.aircraft;

import ro.academyplus.simulator.tower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}
	private Coordinates	changeCoordinates(Coordinates coordinates, String weather)
	{
		int longitude = coordinates.getLongitude();
		int latitude = coordinates.getLatitude();
		int height = coordinates.getHeight();
		System.out.println("JetPlane#" + this.name + "(" + this.id + "): " + weather);
		if (weather.equals("SUN"))
		{
			latitude += 10;
			height += 2;
		}
		else if (weather.equals("RAIN"))
			latitude += 5;
		else if (weather.equals("FOG"))
			latitude += 1;
		else if (weather.equals("SNOW"))
			height -= 7;
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
			System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower.");
			weatherTower.unregister(this);
		}
	}
	@Override
	public void			registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
	}
}
