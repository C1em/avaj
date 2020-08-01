package ro.academyplus.simulator;

import java.util.LinkedList;

import ro.academyplus.simulator.aircraft.AircraftFactory;
import ro.academyplus.simulator.aircraft.Flyable;
import ro.academyplus.simulator.tower.WeatherTower;

public class Simulator {
	public static void		main(String args[])
	{
		String str[] = {
			"Baloon B1 2 3 20",
			"Baloon B2 1 8 66",
			"JetPlane J1 23 44 32",
			"Helicopter H1 654 33 20",
			"Helicopter H2 22 33 44",
			"Helicopter H3 98 68 99",
			"Baloon B3 102 22 34",
			"JetPlane J2 11 99 768",
			"Helicopter H4 223 23 54"
		};
		int nbSimu = 25;
		WeatherTower weatherTower;
		LinkedList<Flyable> aircraftList = new LinkedList<Flyable>();

		weatherTower = new WeatherTower();

		for (int i = 0; i < 9; i++)
		{
			String arg[] = str[i].split(" ");
			Flyable flyable = AircraftFactory.newAircraft(
				arg[0], arg[1],
				Integer.parseInt(arg[2]),
				Integer.parseInt(arg[3]),
				Integer.parseInt(arg[4]));
			aircraftList.add(flyable);
		}
		for (Flyable flyable : aircraftList)
			flyable.registerTower(weatherTower);
		for (int i = 1; i <= nbSimu; i++)
			weatherTower.changeWeather();
	}
}
