package game.ui;

import game.io.IOHandler;
import attacks.question.Subject;

public class Menu {
    private final IOHandler io;

    public Menu(IOHandler io) {
        this.io = io;
    }

    public boolean shouldSkip(game.io.IOHandler io) {
        System.out.println(TerminalColor.LIGHT_GREY.apply("\n[ Press 'x' to skip intro]"));
        System.out.print(TerminalColor.CYAN.apply("--> "));
        
        String input = io.readLine();
        
        // Returns true if the user typed x
        return input.equalsIgnoreCase("x");
    }

    public Subject SubjectSelection() {
        System.out.println(TerminalColor.YELLOW.apply("============== SELECT YOUR SUBJECT =============="));
        
        for (int i = 0; i < Subject.values().length; i++) {
            System.out.println(TerminalColor.PURPLE.apply("[" + (i + 1) + "] ") + Subject.fromId(i + 1).getDisplayName());
            io.wait(100);
        }
        System.out.println(TerminalColor.YELLOW.apply("================================================="));

        while (true) {
            System.out.print("\nEnter subject number: ");
            int choice = io.readInt(); // Using your clean IOHandler method!

            try {
                return Subject.fromId(choice); 
            } catch (IllegalArgumentException e) {
                io.printTyping(TerminalColor.RED.apply("Invalid choice! Please pick a number between 1 and " + Subject.values().length + "."));
            }
        }
    }
}
