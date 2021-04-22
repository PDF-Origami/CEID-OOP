import donations.RequestDonationList;
import users.Admin;

public class Organization {
    String name;
    Admin admin;
    RequestDonationList currentDonations;

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void addEntity() {

    }

}
