package domain.order;

import java.util.HashMap;
import java.util.Map;

public enum OrderCategory {
    ORDER("Order", "장바구니를 확링 후 주문합니다."),
    CANCEL("Cancel", "진행중인 주문을 취소합니다.");

    private final String name;
    private final String description;

    OrderCategory(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    public static Map<String, OrderCategory> getOrderCategoryMap() {
        final Map<String, OrderCategory> map = new HashMap<>();

        for (OrderCategory category : OrderCategory.values()) {
            map.put(category.name.toUpperCase(), category);
        }

        return map;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
