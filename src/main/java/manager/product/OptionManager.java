package manager.product;

import data.product.Option;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static domain.option.GlassSizeOption.LARGE;
import static domain.option.GlassSizeOption.MEDIUM;
import static domain.option.SauceSizeOption.HONEY;
import static domain.option.SauceSizeOption.NONE;

public class OptionManager {
    private final Map<String, List<Option>> options = new HashMap<>();

    public OptionManager() {
        options.put("LARGER", List.of(LARGE, MEDIUM));
        options.put("ALE", List.of(LARGE, MEDIUM));
        options.put("SALAD", List.of(HONEY, NONE));
        options.put("PIZZA", List.of(HONEY, NONE));
        options.put("SODA", List.of(LARGE, MEDIUM));
    }

    public List<Option> getOptions(final String productName) {
        return options.get(productName);
    }
}
