package coderiview3;

import java.util.ArrayList;

public class Company implements DateToString {

	private String name;
	ArrayList<Rent> arr = new ArrayList<>();
	ArrayList<Station> arrS = new ArrayList<>();

	public Company(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Rent> getArr() {
		return arr;
	}

	public void setArr(ArrayList<Rent> arr) {
		this.arr = arr;
	}

	public ArrayList<Station> getArrS() {
		return arrS;
	}

	public void setArrS(ArrayList<Station> arrS) {
		this.arrS = arrS;
	}

	@Override
	public String toString() {
		return "Company " + name;
	}

	// print all Station with Bikes
	public void printStations() {
		System.out.println(toString() + "\n##################################################################");
		for (Station s : arrS) {
			System.out.println(s.toString() + "\nThis Bikes are Available");
			for (Bike b : s.getArrlist())
				System.out.println(b.toString());
			System.out.println("##################################################################");

		}

	}

	// print all Rents
	public void printRents() {
		System.out.println("All rentels");
		for (Rent r : arr)
			System.out.println(r.getU().toString() + "\t" + r.getB() + "\tStart: " + r.getRentStart() + "\tEnd: "
					+ r.getRentEnd());
	}

	// Update my Rent in the RentArray when the bike is given back
	public void updateRent(Rent r) {
		r.setRentEnd(DateToString.getDateTime());
		for (Rent rent : arr)
			if (r.getId() == rent.getId())
				rent = r;
	}

}
