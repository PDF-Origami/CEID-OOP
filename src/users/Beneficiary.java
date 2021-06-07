package users;

import donations.*;

public class Beneficiary extends User {
    private final Organization organization;
    private int familySize = 1;
    private final RequestDonationList receivedList;
    private final Requests requestList;

    public Beneficiary(Organization organization, String name, String phone, int familySize) {
        super(name, phone);
        this.organization = organization;
        this.familySize = familySize;
        this.receivedList = new RequestDonationList(organization);
        this.requestList = new Requests(organization);
    }

    public void add(RequestDonation rd) {
        requestList.add(rd);
    }

    public void remove(RequestDonation rd) {

    }

    public void modify(RequestDonation rd) {

    }

    public void monitor() {
        requestList.monitor();
    }

    public void reset() {
        requestList.reset();
    }

    public void commit() {
        for (RequestDonation rdEntity: requestList.getRequestDonations()) {
            RequestDonation orgRD = organization.currentDonations.get(rdEntity.getEntity().id);
            orgRD.setQuantity(orgRD.getQuantity() + rdEntity.getQuantity());
        }
        reset();
    }

    private boolean validRequestDonation(RequestDonation requestDonation) {
        if (requestDonation.getEntity() instanceof Material) {
            double level;
            Material material = ((Material) requestDonation.getEntity());
            if (familySize == 1) {
                level = material.getLevel1();
            } else if (familySize <= 4) {
                level = material.getLevel2();
            } else {
                level = material.getLevel3();
            }

            return requestList.get(material.id).getQuantity() <= level + receivedList.get(material.id).getQuantity();
        } else {
            return true;
        }
    }
}
