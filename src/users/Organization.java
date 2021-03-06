package users;

import donations.*;
import misc.Utilities;
import java.util.*;

public class Organization {
    private String name;
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

    public User getUserByPhone(String phone) {
        for (Beneficiary beneficiary : beneficiarySet) {
            if (beneficiary.getPhone().equals(phone)) {
                return beneficiary;
            }
        }
        for (Donor donor : donorSet) {
            if (donor.getPhone().equals(phone)) {
                return donor;
            }
        }
        if (admin.getPhone().equals(phone)) {
            return admin;
        }
        return null;
    }

    // Add/remove methods
    public void addEntity(Entity entity) {
        entitySet.add(entity); // doesn't throw exception on duplicate insert
        RequestDonation rd = new RequestDonation(entity, 0);
        currentDonations.add(rd);
    }

    public void removeEntity(Entity entity) {
        entitySet.remove(entity);
    }

    public Entity getEntityByName(String name) {
        for (Entity entity : entitySet) {
            if (entity.toString().equals(name)) {
                return entity;
            }
        }
        return null;
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

    private void printEntityWithQuantity(Entity entity) {
        double quantity;
        RequestDonation rd = currentDonations.get(entity.id);
        if (rd != null) {
            quantity = rd.getQuantity();
        } else {
            quantity = 0;
        }

        System.out.println(entity.toString() + " (" + quantity + ")");
    }

    // List methods
    public void listEntities() {
        ArrayList<Material> materials = new ArrayList<>();
        ArrayList<Service> services = new ArrayList<>();

        for (Entity entity : entitySet) {
            if (entity instanceof Material) {
                materials.add((Material) entity);
            } else {
                services.add((Service) entity);
            }
        }

        System.out.println("1. Materials");
        for (Material material : materials) {
            printEntityWithQuantity(material);
        }

        System.out.println("2. Services");
        for (Service service : services) {
            printEntityWithQuantity(service);
        }
    }


    public void listDonors() {
        for (Donor donor : donorSet) {
            System.out.println(donor.getName());
        }
    }

    public void listBeneficiaries() {
        Utilities.printNumberedList(beneficiarySet);
    }
}
