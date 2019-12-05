package coderiview3;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
	// Generate a atuo ID - this is Threadfrindly
	private static AtomicInteger atomicInteger = new AtomicInteger(0);

	private int id;
	private String name;
	private String surname;
	private Bike bike;
	private Rent rent;

	public User(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = atomicInteger.incrementAndGet();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}

	public Rent getRent() {
		return rent;
	}

	public void setRent(Rent rent) {
		this.rent = rent;
	}

	@Override
	public String toString() {
		return "User: \tid: " + id + "\tname=" + name + "\tsurname=" + surname + "\t";
	}

}
