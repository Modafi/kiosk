package util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class StringFormatter {

    public static final int STANDARD_UNIT = 1000;

    private StringFormatter() {
    }

    public static String namePriceTemplate(final String name,
                                           final BigDecimal price) {

        return String.format("%-20s | W %s", name, priceToWon(price));
    }

    public static String nameDescPriceTemplate(final String name,
                                               final String desc,
                                               final BigDecimal price) {

        return String.format("%-20s | W %s | %s", name, priceToWon(price), desc);
    }

    public static String nameDescPriceQuantityTemplate(final String name,
                                                       final String desc,
                                                       final BigDecimal price,
                                                       final int quantity) {

        return String.format("%-20s | W %s | %d개 | %s",
                name, priceToWon(price), quantity, desc);
    }

    public static String priceToWon(final BigDecimal price) {
        return NumberFormat.getInstance(Locale.KOREA)
                .format(price.divide(BigDecimal.valueOf(STANDARD_UNIT)));
    }
}
