package ro.academyplus.simulator.tower;

import ro.academyplus.simulator.aircraft.Flyable;

import java.util.Iterator;
import java.util.LinkedList;

public class Tower
{
	private LinkedList<Flyable> observers = new LinkedList<Flyable>();
	private Iterator<Flyable> it;

	public void		register(Flyable flyable)
	{
		observers.add(flyable);
	}
	public void		unregister(Flyable flyable)
	{
		it.remove();
	}
	protected void	conditionsChanged()
	{
		it = observers.iterator();
		while (it.hasNext())
			it.next().updateConditions();
	}
}
