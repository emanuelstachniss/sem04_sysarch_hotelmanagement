package at.fhv.sys.hotel.commands.shared.events;

public class RoomBooked {

    private String startTime;
    private String endTime;
    private int roomNumber;
    private int customerId;

    public RoomBooked() {}

    public RoomBooked(String startTime, String endTime, int roomNumber, int customerId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.roomNumber = roomNumber;
        this.customerId = customerId;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "RoomBooked{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", roomNumber=" + roomNumber +
                ", customerId=" + customerId +
                '}';
    }

}
