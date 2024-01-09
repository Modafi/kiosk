package domain.screen;

import java.util.Arrays;
import java.util.List;

public enum InputCommand {
    SHUTDOWN(2024),
    TOTAL_SALES(0),
    LARGER(1),
    ALE(2),
    PIZZA(3),
    SALAD(4),
    SODA(5),
    ORDER(6),
    CANCEL(7);

    private final int number;

    InputCommand(final int number) {
        this.number = number;
    }

    public static InputCommand getCommand(final int number) {
        return Arrays.stream(InputCommand.values())
                .filter(inputCommand -> inputCommand.number == number)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getNumber() {
        return number;
    }

    public static List<InputCommand> getMenuInputCommand() {
        return List.of(LARGER, ALE, PIZZA, SALAD, SODA);
    }

    public static List<InputCommand> getOrderInputCommand() {
        return List.of(ORDER, CANCEL);
    }
}
