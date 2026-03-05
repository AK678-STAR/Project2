package manager;

import model.Booking;
import model.Tour;
import java.io.*;
import java.util.*;

public class BookingManager {

    private List<Booking> list = new ArrayList<>();

    public boolean isDuplicate(String id) {
        return findByID(id) != null;
    }

    public Booking findByID(String id) {
        for (Booking b : list)
            if (b.getBookingID().equals(id))
                return b;
        return null;
    }

    public void add(Booking b) {
        list.add(b);
        System.out.println("Booking added!");
    }

    public void remove(String id) {
        list.removeIf(b -> b.getBookingID().equals(id));
        System.out.println("Removed!");
    }

    public void update(String id, String newName) {
        Booking b = findByID(id);
        if (b != null) {
            list.remove(b);
            list.add(new Booking(id, newName,
                    b.getTourID(), java.time.LocalDate.now(), "0000000000"));
            System.out.println("Updated!");
        }
    }

    public void showAll() {
        for (Booking b : list)
            System.out.println(b);
    }

    public void saveToFile(String filename) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(filename));
            for (Booking b : list)
                pw.println(b.getBookingID() + "," +
                        b.getFullName() + "," +
                        b.getTourID());
            pw.close();
            System.out.println("Saved to file!");
        } catch (Exception e) {
            System.out.println("Save error!");
        }
    }

    public int totalRevenue(List<Tour> tours) {
        int total = 0;
        for (Booking b : list) {
            for (Tour t : tours) {
                if (t.getTourID().equals(b.getTourID()))
                    total += t.getPrice();
            }
        }
        return total;
    }
}