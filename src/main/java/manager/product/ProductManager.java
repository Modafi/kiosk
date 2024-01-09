package manager.product;

import domain.menu.Product;

import java.util.Arrays;
import java.util.List;

import static data.product.Product.values;

public class ProductManager {
    public List<Product> getProductsByMenu(final String menu) {
        return Arrays.stream(values())
                .filter(value -> value.getCategory().name().equals(menu))
                .map(value
                        -> new Product(value.getName(),
                        value.getDescription(),
                        value.getPrice())
                )
                .toList();
    }
}
