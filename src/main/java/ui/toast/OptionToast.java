package ui.toast;

import data.product.Option;
import domain.order.Order;
import domain.screen.YesNoCommand;
import util.InputReader;
import util.StringFormatter;

import java.util.List;

import static util.StringFormatter.nameDescPriceTemplate;

public class OptionToast {
    public Option active(final List<Option> options, final Order order) {
        showOptionTemplate(order);
        System.out.println();
        System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
        showOptionChoice(options);
        YesNoCommand yesNoCommand = InputReader.readCommandInput(YesNoCommand::getCommand);
        return options.get(yesNoCommand.getNumber() - 1);
    }

    private void showOptionChoice(final List<Option> options) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < options.size(); i++) {
            sb.append(i + 1)
                    .append(".")
                    .append(options.get(i).getName())
                    .append("( +W " + StringFormatter.priceToWon(options.get(i).getAddPrice()) + ")")
                    .append("          ");
        }

        System.out.println(sb);
    }

    private void showOptionTemplate(final Order order) {
        final String orderTemplate = nameDescPriceTemplate(
                order.getName(),
                order.getDescription(),
                order.getPrice());

        System.out.println("\"" + orderTemplate + "\"");
    }
}
