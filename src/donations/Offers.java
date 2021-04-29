package donations;

import users.Organization;

public class Offers extends RequestDonationList {
    public Offers(Organization organization) {
        super(organization);
    }

    public void commit() {
        for (RequestDonation rdEntity: this.rdEntities) {
            this.organization.currentDonations.add(rdEntity);
        }

    }
}
