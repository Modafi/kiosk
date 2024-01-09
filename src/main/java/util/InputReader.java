package util;

import java.util.Scanner;
import java.util.function.IntFunction;

public class InputReader {
    public static final String INVALID_USER_INPUT = "잘못된 입력입니다. 다시 입력해주세요.";

    private InputReader() {
    }

    private static String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static <T> T readCommandInput(final IntFunction<T> resultMapper) {
        T result;
        while (true) {
            try {
                result = resultMapper.apply(Integer.parseInt(read()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_USER_INPUT);
            }
        }

        return result;
    }

    public static <T> T readProductInput(final IntFunction<T> resultMapper) {
        T result;
        while (true) {
            try {
                result = resultMapper.apply(Integer.parseInt(read()) - 1);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_USER_INPUT);
            }
        }

        return result;
    }
}
