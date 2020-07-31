package ro.academyplus.simulator.aircraft;

import ro.academyplus.simulator.tower.WeatherTower;

public interface Flyable
{
	public void		updateConditions();
	public void		registerTower(WeatherTower weatherTower);
}
