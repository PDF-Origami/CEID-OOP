package users;

import donations.Offers;
import donations.RequestDonation;

public class Donor extends User {
    private final Organization organization;
    private final Offers offersList;

    public Donor(String name, String phone, Organization organization) {
        super(name, phone);
        this.organization = organization;
        this.offersList = new Offers(this.organization);
    }

    public void commit() {
        this.offersList.commit();
    }

    public double add(RequestDonation rd) {
        return this.offersList.add(rd);
    }

    public void remove(RequestDonation rd) {

    }

    public void modify(RequestDonation rd, double newQuantity) {

    }

    public void monitor() {

    }

    public void reset() {

    }
}
