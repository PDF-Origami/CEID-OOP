package donations;

import users.Organization;

public class Offers extends RequestDonationList {
    public Offers(Organization organization) {
        super(organization);
    }

    public void commit() {
        for (RequestDonation rdEntity: this.requestDonations) {
            RequestDonation orgRD = organization.currentDonations.get(rdEntity.getEntity().id);
            orgRD.setQuantity(orgRD.getQuantity() + rdEntity.getQuantity());
        }
        reset();
    }

    @Override
    public void monitor() {
        if (requestDonations.size() == 0) {
            System.out.println("No offers to show");
        } else {
            int i = 1;
            for (RequestDonation rd : requestDonations) {
                System.out.println(i + ". " + rd.toString());
                i++;
            }
        }
    }
}
