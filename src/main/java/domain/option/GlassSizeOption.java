package domain.option;

import data.product.Option;

import java.math.BigDecimal;

public enum GlassSizeOption implements Option {
    LARGE("750ml", BigDecimal.valueOf(2000)),
    MEDIUM("500ml", BigDecimal.ZERO);

    private final String name;
    private final BigDecimal addPrice;

    GlassSizeOption(final String name, final BigDecimal addPrice) {
        this.name = name;
        this.addPrice = addPrice;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getAddPrice() {
        return addPrice;
    }
}
