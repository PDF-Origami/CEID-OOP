package donations;

import users.Organization;
import java.util.HashSet;
import java.util.Set;

public class RequestDonationList {
    Set<RequestDonation> requestDonations = new HashSet<>();
    Organization organization;

    public RequestDonationList(Organization organization) {
        this.organization = organization;
    }

    public RequestDonation get(int id) {
        for (RequestDonation rd : requestDonations) {
            if (rd.getEntity().id == id) {
                return rd;
            }
        }
        return null;
    }

    public void add(RequestDonation newRequestDonation) {
        for (RequestDonation rd : requestDonations) {
            if (rd.getEntity().equals(newRequestDonation.getEntity())) {
                rd.setQuantity(newRequestDonation.getQuantity());
                return;
            }
        }

        // If the entity exists in the org's list
        if (organization.getEntityByName(newRequestDonation.getEntity().name) != null) {
            requestDonations.add(newRequestDonation);
        } else {
            throw new IllegalArgumentException("Entity not in org. entity list");
        }
    }

    public void remove(RequestDonation rd) {
        requestDonations.remove(rd);
    }

    public void modify(RequestDonation rd) {
        add(rd);
    }

    public RequestDonation[] getRequestDonations() {
        RequestDonation[] array = new RequestDonation[requestDonations.size()];
        requestDonations.toArray(array);
        return array;
    }

    public void monitor() {
        for (RequestDonation rd : requestDonations) {
            System.out.println(rd.getEntity().name + " " + rd.getQuantity());
        }
    }

    public void reset() {
        requestDonations.clear();
    }
}
