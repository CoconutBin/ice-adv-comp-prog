package game;

import java.util.Scanner;

public class IOHandler {
    private Scanner scanner;

    public IOHandler() {
        this.scanner = new Scanner(System.in);
    }

    public void print(String message) {
        System.out.println(message);
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public int readInt() {
        int value = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return value;
    }
}
