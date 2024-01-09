package domain.screen;

import java.util.Arrays;

public enum YesNoCommand {
    YES(1),
    NO(2);

    private final int number;

    YesNoCommand(final int number) {
        this.number = number;
    }

    public static YesNoCommand getCommand(final int number) {
        return Arrays.stream(YesNoCommand.values())
                .filter(yesNoCommand -> yesNoCommand.number == number)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getNumber() {
        return number;
    }

    public static boolean isYes(final int number) {
        if (YES.number != number) {
            throw new IllegalArgumentException();
        }

        return true;
    }
}
