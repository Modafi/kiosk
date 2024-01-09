package domain.core;

import data.product.Option;
import domain.menu.Product;
import domain.order.Order;
import domain.order.OrderList;
import domain.screen.InputCommand;
import manager.cart.OrderManager;
import manager.history.HistoryManager;
import manager.product.OptionManager;
import manager.product.ProductManager;
import ui.screen.MainScreen;
import ui.screen.OrderConfirmScreen;
import ui.screen.ProductScreen;
import ui.screen.TotalSalesScreen;
import ui.toast.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class KioskCore {
    // Manager
    private final ProductManager productManager;
    private final HistoryManager historyManager;
    private final OptionManager optionManager;
    private final OrderManager orderManager;

    // Screen
    private final OrderConfirmScreen orderConfirmScreen;
    private final TotalSalesScreen totalSalesScreen;
    private final ProductScreen productScreen;
    private final MainScreen mainScreen;

    // Toast
    private final OrderNumberToast orderNumberToast;
    private final OrderCancelToast orderCancelToast;
    private final AddCartToast addCartToast;
    private final OptionToast optionToast;

    public KioskCore(ProductManager productManager,
                     HistoryManager historyManager,
                     OptionManager optionManager,
                     OrderManager orderManager,
                     OrderConfirmScreen orderConfirmScreen,
                     TotalSalesScreen totalSalesScreen,
                     ProductScreen productScreen,
                     MainScreen mainScreen,
                     OrderNumberToast orderNumberToast,
                     OrderCancelToast orderCancelToast,
                     AddCartToast addCartToast,
                     OptionToast optionToast) {
        this.productManager = productManager;
        this.historyManager = historyManager;
        this.optionManager = optionManager;
        this.orderManager = orderManager;
        this.orderConfirmScreen = orderConfirmScreen;
        this.totalSalesScreen = totalSalesScreen;
        this.productScreen = productScreen;
        this.mainScreen = mainScreen;
        this.orderNumberToast = orderNumberToast;
        this.orderCancelToast = orderCancelToast;
        this.addCartToast = addCartToast;
        this.optionToast = optionToast;
    }

    public void activeMainScreen() {
        final InputCommand command = mainScreen.active();
        switch (command) {
            case SHUTDOWN -> shutdown();
            case TOTAL_SALES -> activeTotalSalesScreen();
            case ORDER -> activeOrderConfirmPopUp();
            case CANCEL -> activeOrderCancelPopUp();
            default -> activeProductScreen(command.name());
        }
    }

    private void activeTotalSalesScreen() {
        final BigDecimal totalSaleAmount = historyManager.getTotalSaleAmount();
        final Map<String, BigDecimal> salesHistory = historyManager.getSalesHistory();
        totalSalesScreen.active(salesHistory, totalSaleAmount);
        activeMainScreen();
    }

    private void shutdown() {
        orderManager.clearCart();
        System.out.println("Kiosk를 종료합니다. 감사합니다.");
    }

    private void activeOrderCancelPopUp() {
        if (checkOpenOrders()) {
            activeMainScreen();
            return;
        }

        boolean isCancel = orderCancelToast.active();

        if (isCancel) {
            orderManager.clearCart();
        }

        activeMainScreen();
    }

    private boolean checkOpenOrders() {
        if (!orderManager.hasOrder()) {
            System.out.println("장바구니가 비어있습니다.");
            return true;
        }

        return false;
    }

    private void activeProductScreen(final String menu) {
        final List<Product> products = productManager.getProductsByMenu(menu);
        final Product product = productScreen.active(products, menu);
        Order order = new Order(product.getName(),
                product.getDescription(),
                product.getPrice());
        order = activeOptionToast(order, menu);
        activeAddCartPopUp(order, menu);
    }

    private Order activeOptionToast(final Order order, final String menu) {
        final List<Option> options = optionManager.getOptions(menu);
        final Option selectOption = optionToast.active(options, order);
        return new Order(
                order.getName(),
                order.getDescription(),
                order.getPrice().add(selectOption.getAddPrice()),
                selectOption.getName());
    }


    private void activeOrderNumberPopUp(final long orderNumber) {
        orderNumberToast.active(orderNumber);
        setTimer();
    }

    private void setTimer() {
        final long countTime = 3000L;
        final Timer timer = new Timer("Timer");
        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                activeMainScreen();
                timer.cancel();

            }
        };

        timer.schedule(task, countTime);
    }

    private void activeOrderConfirmPopUp() {
        if (checkOpenOrders()) {
            activeMainScreen();
            return;
        }

        final OrderList orders = orderManager.getOrders();
        final boolean confirmOrder = orderConfirmScreen.active(orders);

        if (!confirmOrder) {
            activeMainScreen();
            return;
        }

        orderManager.clearCart();
        activeOrderNumberPopUp(historyManager.makeOrder(orders));
    }

    private void activeAddCartPopUp(final Order order, final String menu) {
        final boolean isAdd = addCartToast.active(order);

        if (!isAdd) {
            activeProductScreen(menu);
            return;
        }

        orderManager.addToCart(order);
        activeMainScreen();
    }
}
