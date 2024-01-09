package ui.screen;

import data.category.MenuCategory;
import domain.order.OrderCategory;
import domain.screen.InputCommand;
import ui.common.CommonTemplate;
import util.InputReader;

import java.util.List;
import java.util.Map;

public class MainScreen {
    public InputCommand active() {
        CommonTemplate.showHeader();
        showMenuCategory();
        showOrderCategory();
        return InputReader.readCommandInput(InputCommand::getCommand);
    }

    private void showMenuCategory() {
        CommonTemplate.showMenuTitle("NBC PUB");
        final List<InputCommand> menuInputCommand = InputCommand.getMenuInputCommand();
        final Map<String, MenuCategory> menuCategoryMap = MenuCategory.getMenuCategoryMap();
        final StringBuilder sb = new StringBuilder();
        menuInputCommand.forEach(command -> {
            MenuCategory category = menuCategoryMap.get(command.name());
            sb.append(command.getNumber())
                    .append(". ")
                    .append(categoryTemplate(category.getName(), category.getDescription()))
                    .append("\n");
        });

        System.out.println(sb);
    }

    private void showOrderCategory() {
        CommonTemplate.showMenuTitle("ORDER");
        final List<InputCommand> orderInputCommand = InputCommand.getOrderInputCommand();
        final Map<String, OrderCategory> orderCategoryMap = OrderCategory.getOrderCategoryMap();
        final StringBuilder sb = new StringBuilder();
        orderInputCommand.forEach(command -> {
            OrderCategory category = orderCategoryMap.get(command.name());
            sb.append(command.getNumber())
                    .append(". ")
                    .append(categoryTemplate(category.getName(), category.getDescription()))
                    .append("\n");
        });

        System.out.println(sb);
    }

    private String categoryTemplate(final String name, final String desc) {
        return String.format("%-10s | %s", name, desc);
    }
}
