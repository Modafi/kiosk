package ui.toast;

import domain.screen.YesNoCommand;
import util.InputReader;

import static domain.screen.YesNoCommand.YES;

public class OrderCancelToast {
    public boolean active() {
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인          2. 취소");
        YesNoCommand yesNoCommand = InputReader.readCommandInput(YesNoCommand::getCommand);

        if (yesNoCommand.equals(YES)) {
            System.out.println("진행하던 주문이 취소되었습니다.");
            System.out.println();
        }

        return yesNoCommand.equals(YES);
    }
}
