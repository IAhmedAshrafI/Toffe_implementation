import java.util.ArrayList;
import java.util.List;

public class Item extends Catalog {
    private String name;
    private Category category;
    private String description;
    private Brand brand;
    private double price;
    private double discountPercentage;

    public double calculatePrice(int quantity) {
        // Logic to calculate the price based on quantity and discount
        // ...

        return 0.0;
    }
}