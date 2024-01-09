import domain.core.KioskCore;
import manager.cart.OrderManager;
import manager.history.HistoryManager;
import manager.product.OptionManager;
import manager.product.ProductManager;
import ui.screen.MainScreen;
import ui.screen.OrderConfirmScreen;
import ui.screen.ProductScreen;
import ui.screen.TotalSalesScreen;
import ui.toast.*;

public class Kiosk {
    public static void main(String[] args) {
        // Manager
        final ProductManager productManager = new ProductManager();
        final HistoryManager historyManager = new HistoryManager();
        final OptionManager optionManager = new OptionManager();
        final OrderManager orderManager = new OrderManager();

        // Screen
        final OrderConfirmScreen orderConfirmScreen = new OrderConfirmScreen();
        final TotalSalesScreen totalSalesScreen = new TotalSalesScreen();
        final ProductScreen productScreen = new ProductScreen();
        final MainScreen mainScreen = new MainScreen();

        // Toast
        final OrderNumberToast orderNumberToast = new OrderNumberToast();
        final OrderCancelToast orderCancelToast = new OrderCancelToast();
        final AddCartToast addCartToast = new AddCartToast();
        final OptionToast optionToast = new OptionToast();

        final KioskCore core = new KioskCore(
                productManager,
                historyManager,
                optionManager,
                orderManager,
                orderConfirmScreen,
                totalSalesScreen,
                productScreen,
                mainScreen,
                orderNumberToast,
                orderCancelToast,
                addCartToast,
                optionToast
        );

        core.activeMainScreen();
    }
}
