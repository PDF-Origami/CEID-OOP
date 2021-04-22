package donations;

import users.Organization;

public class Requests extends RequestDonationList {

    public Requests(Organization organization) {
        super(organization);
    }

    @Override
    public double add(RequestDonation rd) {
        return super.add(rd);
    }


}
