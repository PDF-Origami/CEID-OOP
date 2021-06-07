package users;

import donations.Offers;
import donations.RequestDonation;

public class Donor extends User {
    private final Organization organization;
    private final Offers offersList;

    public Donor(Organization organization, String phone, String name) {
        super(name, phone);
        this.organization = organization;
        this.offersList = new Offers(this.organization);
    }

    public void commit() {
        offersList.commit();
    }

    public void add(RequestDonation rd) {
        offersList.add(rd);
    }

    public void remove(RequestDonation rd) {
        offersList.remove(rd);
    }

    public void modify(RequestDonation rd) {
        offersList.modify(rd);
    }

    public void monitor() {
        offersList.monitor();
    }

    public RequestDonation[] getRequestDonations() {
        return offersList.getRequestDonations();
    }

    public void reset() {
        offersList.reset();
    }
}
