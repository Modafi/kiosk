package ui.toast;

import domain.order.Order;
import domain.screen.YesNoCommand;
import util.InputReader;

import static domain.screen.YesNoCommand.YES;
import static util.StringFormatter.nameDescPriceTemplate;

public class AddCartToast {
    public boolean active(final Order order) {
        showAddCartTemplate(order);
        YesNoCommand yesNoCommand = InputReader.readCommandInput(YesNoCommand::getCommand);

        if (yesNoCommand.equals(YES)) {
            System.out.println(order.getName() + " 가 장바구니에 추가되었습니다.");
        }

        return yesNoCommand.equals(YES);
    }

    private void showAddCartTemplate(final Order order) {
        final String orderTemplate = nameDescPriceTemplate(
                order.getName(),
                order.getDescription(),
                order.getPrice());
        System.out.println("\"" + orderTemplate + "\"");
        System.out.println();
        System.out.println("위 메뉴를 장바구니에 추하시겠습니까?");
        System.out.println("1. 확인          2. 취소");
    }
}
