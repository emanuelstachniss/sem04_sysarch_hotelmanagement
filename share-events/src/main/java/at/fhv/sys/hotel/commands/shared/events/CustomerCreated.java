package at.fhv.sys.hotel.commands.shared.events;

public class CustomerCreated {

    private String userId;
    private String email;

    public CustomerCreated() {}

    public CustomerCreated(String userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomerCreated{" + "userId='" + userId + '\'' + ", email='" + email + '\'' + '}';
    }
}
