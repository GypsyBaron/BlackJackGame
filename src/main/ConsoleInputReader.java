package main;

import java.util.Scanner;

public class ConsoleInputReader {

    ConsoleOutput output = new ConsoleOutput();

    public int readUserIntegerInput() {
        String input;
        int result = 0;

        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

        try {
            result = Integer.parseInt(input);
        } catch (Exception e) {
            output.print("Invalid number expression.");
        }

        return result;
    }
}
