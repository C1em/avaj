package ro.academyplus.simulator.tower;

import ro.academyplus.simulator.aircraft.Flyable;
import java.util.LinkedList;

public class Tower
{
	LinkedList<Flyable> observers = new LinkedList<Flyable>();

	public void		register(Flyable flyable)
	{
		observers.add(flyable);
	}
	public void		unregister(Flyable flyable)
	{
		observers.remove(flyable);
	}
	protected void	conditionsChanged()
	{
		for (Flyable flyable : observers)
			flyable.updateConditions();
	}
}
