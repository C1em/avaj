package ro.academyplus.simulator.aircraft;

public class AircraftFactory
{
	public static Flyable	newAircraft(String type, String name, int longitude, int latitude, int height)
	{
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		if (type.equals("Baloon"))
			return((Flyable)new Baloon(name, coordinates));
		if (type.equals("Helicopter"))
			return((Flyable)new Helicopter(name, coordinates));
		if (type.equals("JetPlane"))
			return((Flyable)new JetPlane(name, coordinates));
		return ((Flyable)null);
	}
}
