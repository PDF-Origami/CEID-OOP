package donations;

public abstract class Entity {
    String name;
    String description;
    int id;

    public String getEntityInfo() {
        return " ";
    }

    public abstract String getDetails();


}
