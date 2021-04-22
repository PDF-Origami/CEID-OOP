package users;

import donations.Offers;
import donations.RequestDonation;

public class Donor extends User {
    Offers offersList;

    public Donor(String name, String phone) {
        super(name, phone);
    }

    public double add(RequestDonation rd) {
        return offersList.add(rd);
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
