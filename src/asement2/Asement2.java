package asement2;

import manager.*;
import model.*;
import utils.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Asement2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HomestayManager hm = new HomestayManager();
        TourManager tm = new TourManager();
        BookingManager bm = new BookingManager();

        hm.loadFromFile("Homestays.txt");

        int choice;

        do {
            System.out.println("\n1.Add Tour");
            System.out.println("2.Add Booking");
            System.out.println("3.Update Booking");
            System.out.println("4.Delete Booking");
            System.out.println("5.Show Tours");
            System.out.println("6.Show Bookings");
            System.out.println("7.Statistics Revenue");
            System.out.println("8.Save");
            System.out.println("0.Exit");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Tour ID: ");
                    String tid = sc.nextLine();

                    if (!ValidationUtils.isValidTourID(tid) || tm.isDuplicate(tid)) {
                        System.out.println("Invalid or Duplicate ID!");
                        break;
                    }

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Time: ");
                    String time = sc.nextLine();

                    System.out.print("Price: ");
                    int price = Integer.parseInt(sc.nextLine());

                    System.out.print("HomeID: ");
                    String hid = sc.nextLine();

                    if (hm.findByID(hid) == null) {
                        System.out.println("Home not exist!");
                        break;
                    }

                    System.out.print("Departure (yyyy-MM-dd): ");
                    LocalDate dep = LocalDate.parse(sc.nextLine());

                    System.out.print("End (yyyy-MM-dd): ");
                    LocalDate end = LocalDate.parse(sc.nextLine());

                    if (end.isBefore(dep)) {
                        System.out.println("Invalid date!");
                        break;
                    }

                    System.out.print("Number Tourist: ");
                    int num = Integer.parseInt(sc.nextLine());

                    if (num > hm.findByID(hid).getMaxCapacity()) {
                        System.out.println("Exceed capacity!");
                        break;
                    }

                    tm.add(new Tour(tid, name, time, price, hid, dep, end, num, false));
                    break;

                case 2:
                    System.out.print("Booking ID: ");
                    String bid = sc.nextLine();

                    if (!ValidationUtils.isValidBookingID(bid) || bm.isDuplicate(bid)) {
                        System.out.println("Invalid or Duplicate!");
                        break;
                    }

                    System.out.print("Full Name: ");
                    String fname = sc.nextLine();

                    System.out.print("Tour ID: ");
                    String tourid = sc.nextLine();

                    if (tm.findByID(tourid) == null) {
                        System.out.println("Tour not exist!");
                        break;
                    }

                    System.out.print("Booking Date (yyyy-MM-dd): ");
                    LocalDate bdate = LocalDate.parse(sc.nextLine());

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    if (!ValidationUtils.isValidPhone(phone)) {
                        System.out.println("Invalid phone!");
                        break;
                    }

                    bm.add(new Booking(bid, fname, tourid, bdate, phone));
                    break;

                case 3:
                    System.out.print("Booking ID: ");
                    bm.update(sc.nextLine(), "UpdatedName");
                    break;

                case 4:
                    System.out.print("Booking ID: ");
                    bm.remove(sc.nextLine());
                    break;

                case 5:
                    tm.showAll();
                    break;

                case 6:
                    bm.showAll();
                    break;

                case 7:
                    System.out.println("Total Revenue: " +
                            bm.totalRevenue(tm.getList()));
                    break;

                case 8:
                    bm.saveToFile("Bookings.txt");
                    break;
            }

        } while (choice != 0);
    }
}
                    