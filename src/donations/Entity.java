package donations;

public abstract class Entity {
    String name;
    String description;
    int id;

    public Entity(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public String getEntityInfo() {
        return " ";
    }

    public abstract String getDetails();

    public String toString() {
        return " ";
    }
}
