package menu;

import users.Organization;

import java.lang.reflect.Method;

public class Item {
    private Menu parentMenu;
    private Menu nextMenu = null;
    private final String label;
    private final String actionMethodName;

    public Item(String label, String actionMethodName) {
        this.label = label;
        this.actionMethodName = actionMethodName;
    }

    public Item(String label, String actionMethodName, Menu nextMenu) {
        this.label = label;
        this.actionMethodName = actionMethodName;
        this.nextMenu = nextMenu;
    }

    public  Menu getNextMenu() {
        return nextMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public boolean executeAction() {
        try {
            Class<?> cls = Class.forName("menu.Executor");
            Method method = cls.getDeclaredMethod(actionMethodName);
            return (boolean) method.invoke(null);
        } catch (Throwable e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public String toString() { return label; }
}

// Item: option that opens a new Menu and/or performs an action
// Menu: list of Items