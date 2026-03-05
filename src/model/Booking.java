//Booking
package model;

import java.time.LocalDate;

public class Booking {
    private String bookingID;
    private String fullName;
    private String tourID;
    private LocalDate bookingDate;
    private String phone;

    public Booking(String bookingID, String fullName,
                   String tourID, LocalDate bookingDate,
                   String phone) {
        this.bookingID = bookingID;
        this.fullName = fullName;
        this.tourID = tourID;
        this.bookingDate = bookingDate;
        this.phone = phone;
    }

    public String getBookingID() { return bookingID; }
    public String getTourID() { return tourID; }
    public String getFullName() { return fullName; }

    @Override
    public String toString() {
        return bookingID + " | " + fullName + " | " + tourID;
    }
}