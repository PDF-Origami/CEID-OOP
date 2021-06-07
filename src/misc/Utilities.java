package misc;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Utilities {
    private static final Scanner scanner = new Scanner(System.in);

    public static <T> void printNumberedList(Iterable<? extends T> iterable) {
        System.out.print("\n");

        int i = 0;
        for (T item : iterable) {
            System.out.println((i + 1) + ". " + item.toString());
            i++;
        }
    }

    public static String getInput(String prompt, String pattern) {
        Pattern p = Pattern.compile(pattern);
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (p.matcher(input).matches()) {
                return input;
            }
        }
    }

    // pattern must only accept two values
    public static boolean getBooleanInput(String prompt, String pattern, String trueVal) {
        String input;
        while (true) {
            System.out.print(prompt);
            try {
                input = scanner.next(pattern);
                return (input.equals(trueVal));
            } catch (InputMismatchException e) {
                scanner.next();
            }
        }
    }
}
