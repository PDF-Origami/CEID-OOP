import donations.Material;
import donations.RequestDonation;
import donations.RequestDonationList;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        System.out.print("Phone number: ");
        Scanner input = new Scanner(System.in);
        String phone = input.next();
        System.out.println(phone);

        Material iron = new Material("iron", "it's iron", 1337);
        RequestDonation rd = new RequestDonation(iron, 128);
        RequestDonationList rdl = new RequestDonationList();
        System.out.println(rdl.add(rd));
        System.out.println(rdl.add(rd));
        System.out.println(rdl.get(1337));
    }
}
