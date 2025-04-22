package at.fhv.sys.hotel.commands.shared.events;

public class RoomBooked {

    private String startTime;
    private String endTime;
    private int roomNumber;
    private int capacity;
    private String lastname;
    private String firstname;

    public RoomBooked() {}

    public RoomBooked(String startTime, String endTime, int roomNumber, int capacity, String lastname, String firstname) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "RoomBooked{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", roomNumber=" + roomNumber +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }

}
