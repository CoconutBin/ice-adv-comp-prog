package game.io;

import java.util.Scanner;

public class IOHandler {
    private final Scanner scanner;

    public IOHandler() {
        this.scanner = new Scanner(System.in);
    }

    public void print(String message) {
        System.out.println(message);
    }

    public void inlinePrint(String message) {
        System.out.print(message);
    }

    public void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void printTyping(String message, int delay) {
        for (char c : message.toCharArray()) {
            System.out.print(c);
            System.out.flush();
            wait(delay);
        }
        System.out.println();
    }

    public void printTyping(String message){
        printTyping(message, 20);
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public int readInt() {
        int value = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return value;
    }

    public void fullClear() {
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();
    }

    public void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void clearLine(int lineNum) {
        System.out.print("\033[" + lineNum + ";1H\033[2K");
        System.out.flush();
    }
}
