package donations;

public class Material extends Entity {
    private int level1, level2, level3;

    public Material(String name, String description, int id) {
        super(name, description, id);
    }

    public String getDetails() {
        return "Entity type: material. Level1: ";
    }
}
