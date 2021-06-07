package menu;

import donations.Entity;
import donations.RequestDonation;
import misc.Utilities;
import users.Beneficiary;
import users.Donor;
import users.Organization;

import java.util.Scanner;

final class Executor { // Singleton
    private static Organization organization;
    private static final Scanner input = new Scanner(System.in);

    private Executor(Organization organization) {}

    protected static void setOrganization(Organization organization) {
        Executor.organization = organization;
    }

    protected static boolean back() {
        Controller.back();
        return false;
    }

    protected static boolean logOut() {
        Controller.authorizeUser();
        return false;
    }

    protected static boolean exit() {
        return true;
    }

    protected static boolean authorizeUser() {
        System.out.print("Phone number: ");
        Scanner input = new Scanner(System.in);
        String phone = input.next();

        if (organization.getAdmin().getPhone().equals(phone)) {
            Controller.setActiveUser(organization.getAdmin());
        }
        return false;
    }

    protected static boolean adminView() {
        organization.listEntities();

        String anotherOne = "y";
        while (anotherOne.equals("y")) {
            String entityName = Utilities.getInput("Type an entity's name to show details: ", ".+");
            try {
                System.out.println(organization.getEntityByName(entityName).getEntityInfo());
            } catch (NullPointerException e) {
                System.out.println("No such entity");
            }
            anotherOne = Utilities.getInput("Get another entity? (y/n): ", "y|n");
        }
        return false;
    }

    protected static boolean adminListBeneficiaries() {
        organization.listBeneficiaries();
        System.out.println("Type a beneficiary's number to select them:");
        return false;
    }

    protected static boolean donorAddOffer() {
        organization.listEntities();

        String anotherOne = "y";
        while (anotherOne.equals("y")) {
            String entityName = Utilities.getInput("Type an entity's name to show details: ", ".+");
            try {
                Entity selectedEntity = organization.getEntityByName(entityName);
                System.out.println(selectedEntity.getEntityInfo());
                if (Utilities.getBooleanInput("Offer this entity? (y/n): ", "y|n", "y")) {
                    double offerQuantity = Double.parseDouble(
                            Utilities.getInput("Quantity/time: ", "\\d+(\\.\\d+)?")
                    );
                    RequestDonation requestDonation = new RequestDonation(selectedEntity, offerQuantity);
                    ((Donor) Controller.getActiveUser()).add(requestDonation);
                }
            } catch (NullPointerException e) {
                System.out.println("No such entity");
            }
            anotherOne = Utilities.getInput("Get another entity? (y/n): ", "y|n");
        }
        return false;
    }

    protected static boolean donorShowOffers() {
        Donor donor = (Donor) Controller.getActiveUser();
        donor.monitor();
        return false;
    }

    protected static boolean donorCommit() {
        ((Donor) Controller.getActiveUser()).commit();
        return false;
    }

    protected static boolean donorSelectOffer() {
        RequestDonation[] requestDonations = ((Donor) Controller.getActiveUser()).getRequestDonations();
        int offerNumber = Integer.parseInt(
                Utilities.getInput("Type an offer's number to select it: ", "\\d+")
        );

        Controller.setSelectedRD(requestDonations[offerNumber - 1]);
        return false;
    }

    protected static boolean donorDeleteOffer() {
        ((Donor) Controller.getActiveUser()).remove(Controller.getSelectedRD());

        Controller.back();
        return false;
    }

    protected static boolean donorEditOffer() {
        RequestDonation selectedRD = Controller.getSelectedRD();
        double newQuantity = Double.parseDouble(
                Utilities.getInput("New quantity/time: ", "\\d+(\\.\\d+)?")
        );
        selectedRD.setQuantity(newQuantity);
        ((Donor) Controller.getActiveUser()).modify(selectedRD);

        Controller.back();
        return false;
    }

    protected static boolean donorClearOffers() {
        ((Donor) Controller.getActiveUser()).reset();

        Controller.back();
        return false;
    }

    protected static boolean beneficiaryAddRequest() {
        return false;
    }

    protected static boolean beneficiaryShowRequests() {
        Beneficiary beneficiary = (Beneficiary) Controller.getActiveUser();
        beneficiary.monitor();
        return false;
    }

    protected static boolean beneficiaryCommit() {
        ((Donor) Controller.getActiveUser()).commit();
        return false;
    }

    protected static boolean beneficiarySelectRequest() {
        RequestDonation[] requestDonations = ((Donor) Controller.getActiveUser()).getRequestDonations();
        int offerNumber = Integer.parseInt(
                Utilities.getInput("Type an offer's number to select it: ", "\\d+")
        );

        Controller.setSelectedRD(requestDonations[offerNumber - 1]);
        return false;
    }

    protected static boolean beneficiaryDeleteRequest() {
        ((Beneficiary) Controller.getActiveUser()).remove(Controller.getSelectedRD());

        Controller.back();
        return false;
    }

    protected static boolean beneficiaryEditRequest() {
        RequestDonation selectedRD = Controller.getSelectedRD();
        double newQuantity = Double.parseDouble(
                Utilities.getInput("New quantity/time: ", "\\d+(\\.\\d+)?")
        );
        selectedRD.setQuantity(newQuantity);
        ((Donor) Controller.getActiveUser()).modify(selectedRD);

        Controller.back();
        return false;
    }

    protected static boolean beneficiaryClearRequests() {
        ((Beneficiary) Controller.getActiveUser()).reset();

        Controller.back();
        return false;
    }
}
