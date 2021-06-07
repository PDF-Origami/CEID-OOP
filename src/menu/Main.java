package menu;

import donations.Material;
import donations.RequestDonation;
import donations.Service;
import users.Admin;
import users.Beneficiary;
import users.Donor;
import users.Organization;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Organization org = new Organization();
        Executor.setOrganization(org);
        Controller.setOrganization(org);

        Admin admin = new Admin("admin s. trator", "1234567890");
        org.setAdmin(admin);

        Material mat1 = new Material("Clothes", "", 1024, 2, 4, 6);
        Material mat2 = new Material("Water", "H2O", 2048, 1, 4, 9);
        Service serv1 = new Service("Medical aid", "", 4096);

        org.addEntity(mat1);
        org.addEntity(serv1);
        org.addEntity(mat2);

        Donor don1 = new Donor(org, "0000000001", "Vas");
        Donor don2 = new Donor(org, "0000000011", "Pat");

        org.insertDonor(don1);
        org.insertDonor(don2);

        RequestDonation rd3 = new RequestDonation(serv1, 1);

        Beneficiary ben1 = new Beneficiary(org,"John", "1112223334", 3);
        ben1.add(rd3);
        org.insertBeneficiary(ben1);

        // Menus have to be declared bottom-up (i.e. starting with the leaves)
        Menu donorOfferOptionsMenu = new Menu(new Item[] {
                new Item("Delete offer", "donorDeleteOffer"),
                new Item("Edit offer", "donorEditOffer")
        });

        Menu donorShowOffersMenu = new Menu(new Item[] {
                new Item("Select an offer", "donorSelectOffer", donorOfferOptionsMenu),
                new Item("Clear all offers", "donorClearOffers"),
                new Item("Commit offers", "donorCommit"),
                new Item("Back", "back")
        });

        Menu donorMenu = new Menu(new Item[] {
            new Item("Add offer", "donorAddOffer"),
            new Item("Show offers", "donorShowOffers", donorShowOffersMenu),
            new Item("Commit", "donorCommit"),
        });

        Menu beneficiaryRequestOptionsMenu = new Menu(new Item[] {
                new Item("Delete offer", "beneficiaryDeleteRequest"),
                new Item("Edit offer", "beneficiaryEditRequest")
        });

        Menu beneficiaryShowRequestsMenu = new Menu(new Item[] {
                new Item("Select an offer", "beneficiarySelectRequest", beneficiaryRequestOptionsMenu),
                new Item("Clear all offers", "beneficiaryClearRequests"),
                new Item("Commit offers", "donorCommit"),
                new Item("Back", "back")
        });

        Menu beneficiaryMenu = new Menu(new Item[] {
            new Item("Add request", "beneficiaryAddRequest"),
            new Item("Show requests", "beneficiaryShowRequests", beneficiaryShowRequestsMenu),
            new Item("Commit offers", "beneficiaryCommit"),
        });

        Menu adminMenu = new Menu(new Item[] {
                new Item("View org. entities", "adminView"),
                new Item("List org. beneficiaries", "adminListBeneficiaries")
        });

        Controller.setUserMenus(adminMenu, donorMenu, beneficiaryMenu);
        Controller.authorizeUser();
        Controller.run();
    }
}
