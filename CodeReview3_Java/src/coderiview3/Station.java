package coderiview3;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Station implements DateToString {
	// Generate a atuo ID - this is Threadfrindly
	private static AtomicInteger atomicInteger = new AtomicInteger(0);

	private int id;
	private String location;

	// Array to store the Bikes into every Station
	ArrayList<Bike> arrlist = new ArrayList<>();

	public Station(String location) {
		super();
		this.location = location;
		this.id = atomicInteger.incrementAndGet();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ArrayList<Bike> getArrlist() {
		return arrlist;
	}

	public void setArrlist(ArrayList<Bike> arrlist) {
		this.arrlist = arrlist;
	}

	@Override
	public String toString() {
		return "Station " + location;
	}

	// add a bike to the station if Space is left
	public void addBike(Bike b) {
		if (checkSpace())
			getArrlist().add(b);
	}

	// remove a bike form the Station
	public void removeBike(Bike b) {
		int index = 0;
		for (Bike bi : getArrlist()) {
			if (b.getId() == bi.getId()) {
				getArrlist().remove(index);
				break;
			}
			index++;
		}
	}

	// Meth to check if their is Space for a Bike if you bring it back or add it in
	// the Main
	public boolean checkSpace() {
		if (this.arrlist.size() > 5) {
			System.out.println("Please search a other station, this one is full");
			return false;
		} else
			return true;
	}

	// Rent Meth with switch to check if the Bike is available

	public void rentBike(User u, Bike b, Company c) {
		// Check if the User already have a Bike
		if (u.getBike() == null) {
			switch (b.getState()) {
			// When the Bike is available create a new Rent and store/override it at the
			// Userclass and in the Company RentArray
			// Also store the Bike at the UserClass and remove it form the stataion with the
			// Meth above
			case CanBeRended:
				u.setBike(b);
				Rent r = new Rent(u, b, DateToString.getDateTime(), "The User still has the Bike");
				c.getArr().add(r);
				u.setRent(r);
				System.out.println(
						u.getName() + " " + u.getSurname() + " rent the " + b.toString() + " at " + r.getRentStart());
				b.setState(State.CanNotBeRented);
				removeBike(b);
				break;
			// if it is not available through a massage (could be done with only One Line
			// if wanted because all 3 options have the same outcome for the User
			case CanNotBeRented:
				System.out.println("Sorry " + u.getName() + " " + u.getSurname() + " the Bike is not available");
				break;
			case InService:
				System.out.println("Sorry " + u.getName() + " " + u.getSurname() + " the Bike is at the Service");
				break;
			case Discarded:
				System.out.println("Sorry " + u.getName() + " " + u.getSurname() + " the Bike is not available");
				break;
			}
		} else
			System.out.println("You can only have one Bike");
	}

	// User return a Bike to a Station and The Rent will be updated in the Company
	// RentArray
	public void returnBike(User u, Bike b, Company c) {

		if (u.getBike() != null) {
			if (checkSpace()) {
				u.getBike().setState(State.CanBeRended);
				u.setBike(null);
				this.arrlist.add(b);
				c.updateRent(u.getRent());
				System.out.println("Thanks for returning the Bike, have a nice Day! " + DateToString.getDateTime());
			}
		} else
			System.out.println("You have no Bike to return");
	}

}
