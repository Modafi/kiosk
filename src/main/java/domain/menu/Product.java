package domain.menu;

import java.math.BigDecimal;

public class Product extends Menu {
    private final BigDecimal price;

    public Product(final String name, final String description, final BigDecimal price) {
        super(name, description);
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                '}';
    }
}
