package menu;

import donations.Material;
import donations.RequestDonation;
import users.Admin;
import users.Donor;
import users.Organization;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        System.out.print("Phone number: ");
        Scanner input = new Scanner(System.in);
        String phone = input.next();
        Organization org = new Organization();

        Admin admin = new Admin("admni s. trator", "1234567890");
        org.setAdmin(admin);

        if (phone.equals(admin.getPhone())) {
            System.out.println("wow u r admin");
        }

        Material iron = new Material("iron", "it's iron", 1337);
        Material copper = new Material("copper", "forms patina", 2048);

        RequestDonation rd1 = new RequestDonation(iron, 128);

        org.addEntity(iron);
        org.addEntity(copper);
        org.removeEntity(iron);
        org.listEntities();

        Donor don1 = new Donor("vas", "6986997734", org);
        Donor don2 = new Donor("pat", "6986997734", org);
        don1.add(rd1);
        don1.commit();
        org.currentDonations.monitor();
        org.insertDonor(don1);
        org.insertDonor(don2);
        org.listDonors();
        org.removeDonor(don1);
        org.listDonors();

        Menu menu1 = new Menu();
        Item[] items = {new Item("Start")};
        menu1.setItems(items);

    }
}
