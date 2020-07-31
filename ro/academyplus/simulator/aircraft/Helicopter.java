package ro.academyplus.simulator.aircraft;

import ro.academyplus.simulator.tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates)
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
		System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
	}
}
