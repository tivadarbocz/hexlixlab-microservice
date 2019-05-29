package domain;

public class DeliveryInfo {
    private Long id;
    private String firstname;
    private String lastname;
    private String status;

    public DeliveryInfo() {
    }

    public DeliveryInfo(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public DeliveryInfo(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
