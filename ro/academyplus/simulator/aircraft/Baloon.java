package ro.academyplus.simulator.aircraft;

import ro.academyplus.simulator.tower.WeatherTower;

public class Baloon extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}
	@Override
	public void		updateConditions()
	{
		weatherTower.getWeather(this.coordinates);
	}
	@Override
	public void		registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
	}
}
