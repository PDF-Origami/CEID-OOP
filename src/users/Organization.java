package users;

import donations.Entity;
import donations.RequestDonationList;
import users.Admin;

import java.util.HashSet;
import java.util.Set;

public class Organization {
    String name;
    private Admin admin;
    private final Set<Entity> entitySet = new HashSet<>();
    public final RequestDonationList currentDonations = new RequestDonationList(this);

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void addEntity() {

    }



}