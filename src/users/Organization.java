package users;

import donations.Entity;
import donations.RequestDonationList;

import java.util.HashSet;
import java.util.Set;

public class Organization {
    String name;
    private Admin admin;
    private final Set<Entity> entitySet = new HashSet<>();
    private final Set<Beneficiary> beneficiarySet = new HashSet<>();
    private final Set<Donor> donorSet = new HashSet<>();
    public final RequestDonationList currentDonations = new RequestDonationList(this);

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    // Add/remove methods
    public void addEntity(Entity entity) {
        entitySet.add(entity); // doesn't throw exception on duplicate insert
    }

    public void removeEntity(Entity entity) {
        entitySet.remove(entity);
    }

    public void insertDonor(Donor donor) {
        donorSet.add(donor);
    }

    public void removeDonor(Donor donor) {
        donorSet.remove(donor);
    }

    public void insertBeneficiary(Beneficiary beneficiary) {
        beneficiarySet.add(beneficiary);
    }

    public void removeBeneficiary(Beneficiary beneficiary) {
        beneficiarySet.remove(beneficiary);
    }

    // List methods
    public void listEntities() {
        for (Entity entity : entitySet) {
            System.out.println(entity.toString());
        }
    }

    public void listDonors() {
        for (Donor donor : donorSet) {
            System.out.println(donor.getName());
        }
    }

    public void listBeneficiaries() {
        for (Beneficiary beneficiary : beneficiarySet) {
            System.out.println(beneficiary.getName());
        }
    }
}
