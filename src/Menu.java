import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        System.out.print("Phone number: ");
        Scanner input = new Scanner(System.in);
        String phone = input.next();
        System.out.println(phone);
    }
}
