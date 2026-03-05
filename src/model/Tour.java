//Tour
package model;

import java.time.LocalDate;

public class Tour {
    private String tourID;
    private String tourName;
    private String time;
    private int price;
    private String homeID;
    private LocalDate departureDate;
    private LocalDate endDate;
    private int numberTourist;
    private boolean booking;

    public Tour(String tourID, String tourName, String time, int price,
                String homeID, LocalDate departureDate,
                LocalDate endDate, int numberTourist, boolean booking) {
        this.tourID = tourID;
        this.tourName = tourName;
        this.time = time;
        this.price = price;
        this.homeID = homeID;
        this.departureDate = departureDate;
        this.endDate = endDate;
        this.numberTourist = numberTourist;
        this.booking = booking;
    }

    public String getTourID() { return tourID; }
    public String getHomeID() { return homeID; }
    public LocalDate getDepartureDate() { return departureDate; }
    public LocalDate getEndDate() { return endDate; }
    public int getNumberTourist() { return numberTourist; }
    public int getPrice() { return price; }
    public boolean isBooking() { return booking; }

    public void setBooking(boolean booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return tourID + " | " + tourName + " | " + departureDate;
    }
}