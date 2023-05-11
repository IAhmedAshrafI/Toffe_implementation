import java.util.List;

public class CatalogController {
    private Catalog catalog;

    public CatalogController(Catalog catalog) {
        this.catalog = catalog;
    }

    public List<Item> getItems() {
        return catalog.getItems();
    }

    public List<Category> getCategories() {
        return catalog.getCategories();
    }

    public List<Item> searchItems(String name, String brand) {
        return catalog.searchItems(name, brand);
    }

    public List<Item> filterItems(String category) {
        return catalog.filterItems(category);
    }
}
