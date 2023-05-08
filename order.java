import java.util.ArrayList;
import java.util.List;

public class order extends Item {
    private List<Item> items;
    private Address shippingAddress;
    private PaymentMethod paymentMethod;
    private boolean isPaid;

    public boolean cancel() {
        // Logic to cancel the order
        // ...

        return true;
    }

    public double getTotal() {
        // Logic to calculate the total price of the order
        // ...

        return 0.0;
    }
}