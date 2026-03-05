//Homestay
package model;

public class Homestay {
    private String homeID;
    private String homeName;
    private int roomNumber;
    private String address;
    private int maxCapacity;

    public Homestay(String homeID, String homeName, int roomNumber,
                     String address, int maxCapacity) {
        this.homeID = homeID;
        this.homeName = homeName;
        this.roomNumber = roomNumber;
        this.address = address;
        this.maxCapacity = maxCapacity;
    }

    public String getHomeID() { return homeID; }
    public String getHomeName() { return homeName; }
    public int getMaxCapacity() { return maxCapacity; }
}