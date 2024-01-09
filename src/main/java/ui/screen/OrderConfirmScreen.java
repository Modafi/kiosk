package ui.screen;

import domain.order.OrderList;
import domain.screen.YesNoCommand;
import util.InputReader;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import static domain.screen.YesNoCommand.YES;
import static util.StringFormatter.nameDescPriceQuantityTemplate;

public class OrderConfirmScreen {
    public boolean active(final OrderList orders) {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        orderTemplate(orders);
        System.out.println();
        ordersTotalPrice(orders.getTotalPrice());
        System.out.println();
        System.out.println("1. 주문          2. 매뉴판");
        return InputReader.readCommandInput(YesNoCommand::getCommand).equals(YES);
    }

    private void ordersTotalPrice(final BigDecimal price) {
        String priceToWon = NumberFormat.getInstance(Locale.KOREA)
                .format(price.divide(BigDecimal.valueOf(1000)));
        System.out.println("[ Total ]");
        System.out.printf("W %s\n", priceToWon);
    }

    private void orderTemplate(final OrderList orders) {
        System.out.println("[ Orders ]");
        final StringBuilder sb = new StringBuilder();
        orders.getOrders().forEach(order -> {
            sb.append(nameDescPriceQuantityTemplate(
                            order.getName(),
                            order.getDescription(),
                            order.getPrice(),
                            order.getQuantity()))
                    .append(" | 옵션: ")
                    .append(order.getOption())
                    .append("\n");
        });

        System.out.println(sb);
    }
}
