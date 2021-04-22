package users;

import donations.RequestDonation;
import donations.RequestDonationList;
import donations.Requests;

public class Beneficiary extends User {
    private int familySize = 1;
    private RequestDonationList receivedList;
    private Requests requestsList;

    public Beneficiary(String name, String phone, int familySize) {
        super(name, phone);
        this.familySize = familySize;
    }

    public double add(RequestDonation rd) {
        return requestsList.add(rd);
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
