package users;

import donations.Offers;
import donations.RequestDonation;

class Donor extends User {
    Offers offersList;

    public double add(RequestDonation rd) {
        return offersList.add(rd);
    }
}
