package coderiview3;

import java.util.concurrent.atomic.AtomicInteger;

public class Bike {

	private static AtomicInteger atomicInteger = new AtomicInteger(0);

	private int id;
	private String color;
	private State state;

	public Bike(String color, State state) {
		super();
		this.color = color;
		this.state = state;
		this.id = atomicInteger.incrementAndGet();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Bike \tid: " + id + "\tcolor: " + color;
	}

}
