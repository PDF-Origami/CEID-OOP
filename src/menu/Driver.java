package menu;

import donations.Material;
import donations.RequestDonation;
import donations.Service;
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

        Admin admin = new Admin("admin s. trator", "1234567890");
        org.setAdmin(admin);

        if (phone.equals(admin.getPhone())) {
            System.out.println("wow u r admin");
        }

        Material mat1 = new Material("Clothes", "", 1024);
        Material mat2 = new Material("Water", "forms ", 2048);
        Service serv1 = new Service("Medical aid", "", 4096);

        RequestDonation rd1 = new RequestDonation(mat1, 128);
        RequestDonation rd2 = new RequestDonation(serv1, 3);

        org.addEntity(mat1);
        org.addEntity(serv1);
        org.currentDonations.add(rd1);
        org.currentDonations.add(rd2);
        org.addEntity(mat2);
        org.listEntities();

        Donor don1 = new Donor("vas", "6986997734", org);
        Donor don2 = new Donor("pat", "6986997734", org);
        don1.add(rd1);
        don1.commit();
        //org.currentDonations.monitor();
        org.insertDonor(don1);
        org.insertDonor(don2);
        org.listDonors();
        org.removeDonor(don1);

        Menu menu1 = new Menu();
        Item[] items = {new Item("Start")};
        menu1.setItems(items);

    }
}
