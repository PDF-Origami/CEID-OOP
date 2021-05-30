package users;

import donations.*;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
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
        for (Beneficiary beneficiary : beneficiarySet) {
            System.out.println(beneficiary.getName());
        }
    }
}
