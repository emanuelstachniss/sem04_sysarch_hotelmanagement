package at.fhv.sys.hotel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustomerQueryModel {

    @Id
    private String userId;
    private String email;

    public CustomerQueryModel() {}

    public CustomerQueryModel(String userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public String getUserId() {
        return "Customer-" + userId;
    }

    public String getEmail() {
        return "Customer Email is: " + email;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
