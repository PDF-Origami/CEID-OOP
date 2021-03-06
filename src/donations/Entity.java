package donations;

public abstract class Entity {
    String name;
    String description;
    public int id;

    public Entity(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public String getEntityInfo() {
        return String.format("ID: %d; Name: %s; Description: %s", id, name, description);
    }

    public abstract String getDetails();

    @Override
    public String toString() {
        return name;
    }
}
