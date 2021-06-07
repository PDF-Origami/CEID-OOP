package donations;

public class Material extends Entity {
    private double level1, level2, level3;

    public Material(String name, String description, int id, double level1, double level2, double level3) {
        super(name, description, id);
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
    }

    public String getDetails() {
        return String.format("Entity type: material. Level 1: %d; Level 2: %d; Level 3: %d", level1, level2, level3);
    }

    public double getLevel1() {
        return level1;
    }

    public double getLevel2() {
        return level2;
    }

    public double getLevel3() {
        return level3;
    }
}
