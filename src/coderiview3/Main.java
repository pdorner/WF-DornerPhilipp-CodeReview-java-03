package coderiview3;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		System.out.println(" -------- __@      __@       __@       __@      __~@\r\n" + 
				" ----- _`\\<,_    _`\\<,_    _`\\<,_     _`\\<,_    _`\\<,_\r\n" + 
				" ---- (*)/ (*)  (*)/ (*)  (*)/ (*)  (*)/ (*)  (*)/ (*)\r\n" + 
				" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\r\n" + 
				"\r\n");
		
		Bike b1 = new Bike("blue", State.CanBeRended);
		Bike b2 = new Bike("red", State.CanBeRended);
		Bike b3 = new Bike("yellow", State.Discarded);
		Bike b4 = new Bike("green", State.InService);
		Bike b5 = new Bike("pink", State.CanBeRended);
		Bike b6 = new Bike("purple", State.CanBeRended);
		Bike b7 = new Bike("orange", State.CanBeRended);
		Bike b8 = new Bike("black", State.CanBeRended);

		// Put the Bikes in a HashMap
		HashMap<Integer, Bike> hmBike = new HashMap<>();
		hmBike.put(b1.getId(), b1);
		hmBike.put(b2.getId(), b2);
		hmBike.put(b3.getId(), b3);
		hmBike.put(b4.getId(), b4);
		hmBike.put(b5.getId(), b5);
		hmBike.put(b6.getId(), b6);
		hmBike.put(b7.getId(), b7);
		hmBike.put(b8.getId(), b8);
		// Show Key + Value of all of my bikes
		hmBike.forEach((k, v) -> System.out.println("Key: " + k + "\tValue: " + v));
		System.out.println("------------------------------------------------------------------------\n\n");

		// Generet Stations and fill them with bikes 3, 4, 1
		Station s1 = new Station("Hernals");
		Station s2 = new Station("Otterkring");
		Station s3 = new Station("Währing");
		s1.addBike(hmBike.get(1));
		s1.addBike(hmBike.get(2));
		s1.addBike(hmBike.get(3));
		s2.addBike(hmBike.get(4));
		s2.addBike(hmBike.get(5));
		s2.addBike(hmBike.get(6));
		s2.addBike(hmBike.get(7));
		s3.addBike(hmBike.get(8));

		// Generate a Company to store all data
		Company c = new Company("City Bike");
		c.getArrS().add(s1);
		c.getArrS().add(s2);
		c.getArrS().add(s3);
		c.printStations();
		System.out.println();

		// Put the Stations in a HashMap
		HashMap<Integer, Station> hmStation = new HashMap<>();
		hmStation.put(s1.getId(), s1);
		hmStation.put(s1.getId(), s2);
		hmStation.put(s1.getId(), s3);
		// Generat User and give them univalabel bikes
		User u1 = new User("Homer", "Simpson");
		User u2 = new User("Bart", "Simpson");
		User u3 = new User("Lisa", "Simpson");
		User u4 = new User("Marge", "Simson");
		User u5 = new User("Maggie", "Simson");
		// Users Rents a bike at Station One
		s1.rentBike(u1, hmBike.get(1), c);
		s1.rentBike(u3, hmBike.get(2), c);
		s3.rentBike(u4, hmBike.get(8), c);

		// User One try to Rent a second Bike
		s1.rentBike(u1, hmBike.get(1), c);
		System.out.println();

		// User Two try to Rent the same bike and than try to rent a other bike
		s1.rentBike(u2, hmBike.get(1), c);
		s2.rentBike(u2, hmBike.get(4), c);
		s2.rentBike(u2, hmBike.get(6), c);
		System.out.println();

		// Users return bikes till Station is full
		s2.returnBike(u1, u1.getBike(), c);
		s2.returnBike(u2, u2.getBike(), c);
		s2.returnBike(u3, u3.getBike(), c);
		s2.returnBike(u4, u4.getBike(), c);

		// User again rents a Bike and you can see that the Rental List saves all Rents
		// and the new StationList
		s2.rentBike(u1, hmBike.get(1), c);
		System.out.println();
		c.printStations();
		c.printRents();
		System.out.println(" -------- __@      __@       __@       __@      __~@\r\n" + 
				" ----- _`\\<,_    _`\\<,_    _`\\<,_     _`\\<,_    _`\\<,_\r\n" + 
				" ---- (*)/ (*)  (*)/ (*)  (*)/ (*)  (*)/ (*)  (*)/ (*)\r\n" + 
				" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\r\n" + 
				"\r\n");

	}

}
