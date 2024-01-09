package manager.cart;

import domain.order.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private final Map<String, Order> cartMap = new HashMap<>();

    public void insert(Order order) {
        if (cartMap.containsKey(order.getName())) {
            order = cartMap.get(order.getName());
            order.increaseQuantity();
        }

        cartMap.put(order.getName(), order);
    }

    public void removeAll() {
        cartMap.clear();
    }

    public List<Order> getOrders() {
        return new ArrayList<>(cartMap.values());
    }

    public boolean hasOrder() {
        return !cartMap.isEmpty();
    }
}
