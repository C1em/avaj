package ro.academyplus.simulator;

import ro.academyplus.simulator.aircraft.AircraftFactory;
import ro.academyplus.simulator.aircraft.Flyable;
import ro.academyplus.simulator.tower.WeatherTower;

public class Simulator {

	public static void		main(String args[])
	{
		WeatherTower weatherTower = new WeatherTower();
		Flyable flyable = AircraftFactory.newAircraft("Baloon", "yoyo", 1, 1, 1);
		flyable.registerTower(weatherTower);
	}
}
