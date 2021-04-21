package donations;

public class RequestDonation {
    Entity entity;
    double quantity;

    public RequestDonation(Entity entity, double quantity) {
        this.entity = entity;
        this.quantity = quantity;
    }
}
