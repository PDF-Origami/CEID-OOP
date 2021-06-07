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

        Admin admin = new Admin("Alice", "0000000000");
        org.setAdmin(admin);

        Material mat1 = new Material("Sugar", "", 256, 2, 4, 6);
        Material mat2 = new Material("Rice", "H2O", 512, 1, 4, 9);
        Material mat3 = new Material("Milk", "H2O", 1024, 1, 4, 6);
        Service serv1 = new Service("Medical support", "", 2048);
        Service serv2 = new Service("Nursery support", "", 4096);
        Service serv3 = new Service("Babysitting", "", 8192);

        org.addEntity(mat1);
        org.addEntity(mat2);
        org.addEntity(mat3);
        org.addEntity(serv1);
        org.addEntity(serv2);
        org.addEntity(serv3);

        Beneficiary ben1 = new Beneficiary(org,"Bob", "1111111111", 3);
        Beneficiary ben2 = new Beneficiary(org,"Charlie", "2222222222", 3);
        Donor don1 = new Donor(org, "3333333333", "Daphne");

        RequestDonation rd1 = new RequestDonation(mat1, 3);
        RequestDonation rd2 = new RequestDonation(mat2, 1);
        RequestDonation rd3 = new RequestDonation(mat3, 6);
        RequestDonation rd4 = new RequestDonation(serv1, 5);
        RequestDonation rd5 = new RequestDonation(serv2, 15);
        RequestDonation rd6 = new RequestDonation(serv3, 4);

        ben1.add(rd1);
        ben1.add(rd4);
        ben2.add(rd2);
        don1.add(rd3);
        don1.add(rd5);
        don1.add(rd6);

        org.insertBeneficiary(ben1);
        org.insertBeneficiary(ben2);
        org.insertDonor(don1);

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

        Menu adminMonitorMenu = new Menu(new Item[] {
            new Item("List beneficiaries", "adminListBeneficiaries"),
            new Item("List donors", "adminListDonors"),
            new Item("Reset all beneficiary received lists", "adminResetBeneficiaries"),
            new Item("Back", "back")
        });

        Menu adminMenu = new Menu(new Item[] {
            new Item("View org. entities", "adminView"),
            new Item("Monitor org.", "", adminMonitorMenu)
        });

        Controller.setUserMenus(adminMenu, donorMenu, beneficiaryMenu);
        Controller.authorizeUser();
        Controller.run();
    }
}
