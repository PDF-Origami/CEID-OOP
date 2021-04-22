package users;

import donations.RequestDonation;
import donations.RequestDonationList;
import donations.Requests;

class Beneficiary extends User {
    private int familySize = 1;
    private RequestDonationList receivedList;
    private Requests requestsList;

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
