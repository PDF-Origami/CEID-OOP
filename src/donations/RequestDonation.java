package donations;

public class RequestDonation {
    protected Entity entity;
    protected double quantity;

    public RequestDonation(Entity entity, double quantity) {
        this.entity = entity;
        this.quantity = quantity;
    }

    public Entity getEntity() {
        return entity;
    }

    public double getQuantity() {
        return quantity;
    }
}
