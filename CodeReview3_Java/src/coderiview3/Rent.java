package coderiview3;

import java.util.concurrent.atomic.AtomicInteger;

public class Rent implements DateToString {
	private static AtomicInteger atomicInteger = new AtomicInteger(0);

	private int id;
	private User u;
	private Bike b;
	private String rentStart;
	private String rentEnd;

	public Rent(User u, Bike b, String rentStart, String rentEnd) {
		super();
		this.u = u;
		this.b = b;
		this.rentStart = rentStart;
		this.rentEnd = rentEnd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public Bike getB() {
		return b;
	}

	public void setB(Bike b) {
		this.b = b;
	}

	public String getRentStart() {
		return rentStart;
	}

	public void setRentStart(String rentStart) {
		this.rentStart = rentStart;
	}

	public String getRentEnd() {
		return rentEnd;
	}

	public void setRentEnd(String rentEnd) {
		this.rentEnd = rentEnd;
	}

}
