package menu;

import donations.RequestDonation;
import misc.Utilities;
import users.*;

import java.util.Stack;

public final class Controller { // Singleton
    private static Organization organization;
    private static User activeUser;
    private static final Stack<Menu> menuHistory = new Stack<>();
    private static Menu activeMenu;
    private static Menu adminMenu;
    private static Menu donorMenu;
    private static Menu beneficiaryMenu;
    private static RequestDonation selectedRD;

    private Controller() {}

    static void setOrganization(Organization organization) {
        Controller.organization = organization;
    }

    static void setActiveUser(User activeUser) {
        Controller.activeUser = activeUser;
    }
    static void setActiveMenu(Menu activeMenu) {
        Controller.activeMenu = activeMenu;
    }

    static void setUserMenus(Menu adminMenu, Menu donorMenu, Menu beneficiaryMenu) {
        Controller.adminMenu = adminMenu;
        Controller.donorMenu = donorMenu;
        Controller.beneficiaryMenu = beneficiaryMenu;
    }

    static void setSelectedRD(RequestDonation selectedRD) {
        Controller.selectedRD = selectedRD;
    }

    static RequestDonation getSelectedRD() {
        return selectedRD;
    }

    static User getActiveUser() {
        return activeUser;
    }

    static Menu getActiveMenu() {
        return activeMenu;
    }

    private static User registerUser(String phone) {
        String userType = Utilities.getInput(
                "Donor or beneficiary? (donor/beneficiary): ",
                "(donor)|(beneficiary)"
        );
        String userName = Utilities.getInput("Name: ", ".+");

        User newUser;
        if (userType.equals("donor")) {
            newUser = new Donor(organization, phone, userName);
            organization.insertDonor((Donor) newUser);
        } else {
            int userFamilySize = Integer.parseInt(Utilities.getInput("Family size: ", "\\d"));
            newUser = new Beneficiary(organization, userName, phone, userFamilySize);
            organization.insertBeneficiary((Beneficiary) newUser);
        }
        return newUser;
    }

    public static void authorizeUser() {
        User user;
        while (true) {
            String phone = Utilities.getInput("Phone number: ", "\\d{10}");
            user = organization.getUserByPhone(phone);

            if (user == null) {
                String response = Utilities.getInput(
                    "Phone not found. Would you like to register? (y/n): ",
                    "y|n"
                );
                if (response.equals("y")) {
                    user = registerUser(phone);
                    break;
                }
            } else {
                break;
            }
        }
        Controller.setActiveUser(user);
        System.out.println(String.format(
                "\nWelcome, %s (%s)",
                activeUser.getName(),
                activeUser.getClass().getSimpleName()
        ));
        if (Controller.activeUser instanceof Admin) {
            Controller.setActiveMenu(adminMenu);
        } else if (Controller.activeUser instanceof Donor) {
            Controller.setActiveMenu(donorMenu);
        } else if (Controller.activeUser instanceof Beneficiary) {
            Controller.setActiveMenu(beneficiaryMenu);
        }
    }

    public static void back() {
        activeMenu = menuHistory.pop();
    }

    public static void run() {
        boolean exit = false;
        while (!exit) {
            activeMenu.printItems();
            Item selectedItem = activeMenu.getItemFromInput();
            exit = selectedItem.executeAction();

            if (selectedItem.getNextMenu() != null) {
                menuHistory.push(activeMenu);
                activeMenu = selectedItem.getNextMenu();
            }
        }
    }
}
