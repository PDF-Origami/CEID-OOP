package donations;

import users.Organization;

public class Requests extends RequestDonationList {

    public Requests(Organization organization) {
        super(organization);
    }

    @Override
    public double add(RequestDonation rd) {
        // TODO: add checks
        return super.add(rd);
    }

    @Override
    public void modify(RequestDonation rd, double newQuantity) {
        // TODO: add checks
        super.modify(rd, newQuantity);
    }

    public boolean validRequestDonation() {
        return true;
    }

    public void commit() {}
}
