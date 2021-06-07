package donations;

import users.Organization;

public class Requests extends RequestDonationList {

    public Requests(Organization organization) {
        super(organization);
    }

    @Override
    public void add(RequestDonation newRequestDonation) {
        // TODO: add checks
        super.add(newRequestDonation);
    }

    @Override
    public void modify(RequestDonation rd) {
        // TODO: add checks
        super.modify(rd);
    }

    @Override
    public void monitor() {
        if (requestDonations.size() == 0) {
            System.out.println("No requests to show");
        } else {
            int i = 1;
            for (RequestDonation rd : requestDonations) {
                System.out.println(i + ". " + rd.toString());
                i++;
            }
        }
    }
}
