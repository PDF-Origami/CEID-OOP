package menu;

import misc.Utilities;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {
    private final ArrayList<Item> items;

    public Menu(Item[] items) {
        this.items = new ArrayList<>(Arrays.asList(items)); // Lists returned by asList don't support addition

        Item logOut = new Item("Log out", "logOut");
        Item exit = new Item("Exit program", "exit");
        this.items.add(logOut);
        this.items.add(exit);

        for (Item item : items) {
            item.setParentMenu(this);
        }
    }

    public void printItems() {
        Utilities.printNumberedList(items);
    }

    public Item getItemFromInput() {
        int itemNumber = Integer.parseInt(Utilities.getInput("Type an item's number to select it: ", "\\d+"));
        return items.get(itemNumber - 1);
    }
}
