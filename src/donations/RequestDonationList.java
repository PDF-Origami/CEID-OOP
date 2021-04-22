package donations;

import java.util.HashSet;
import java.util.Set;

public class RequestDonationList {
    Set<RequestDonation> rdEntities = new HashSet<>();

    public RequestDonation get(int id) {
        for (RequestDonation rd : rdEntities) {
            if (rd.entity.id == id) {
                return rd;
            }
        }
        return null;
    }

    public double add(RequestDonation rd) {
        if (rdEntities.contains(rd)) {
            return this.get(rd.entity.id).quantity;
        } else {
            rdEntities.add(rd);
            return 0;
        }
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
