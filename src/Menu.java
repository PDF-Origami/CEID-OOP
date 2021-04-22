import donations.Material;
import donations.RequestDonation;
import donations.RequestDonationList;
import users.Donor;
import users.Organization;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        System.out.print("Phone number: ");
        Scanner input = new Scanner(System.in);
        String phone = input.next();
        System.out.println(phone);

        Organization org = new Organization();

        Material iron = new Material("iron", "it's iron", 1337);
        Material copper = new Material("copper", "forms patina", 2048);

        RequestDonation rd = new RequestDonation(iron, 128);

        org.addEntity(iron);
        org.addEntity(copper);
        org.removeEntity(iron);
        org.listEntities();

        Donor don1 = new Donor("vas", "6986997734");
        Donor don2 = new Donor("pat", "6986997734");
        org.insertDonor(don1);
        org.insertDonor(don2);
        org.listDonors();
        org.removeDonor(don1);
        org.listDonors();
    }
}
