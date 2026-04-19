package game.ui;

import game.io.IOHandler;

public class Menu {
    private final IOHandler io;
    private final String[] subjects = {
        "Calculus I",
        "Physics I",
        "Calculus II",
        "Physics II",
        "Computer Programming",
        "Advance Computer Programming",
        "Probability and Statistics for Data Analysis"
    };

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

    public int SubjectSelection() {
        System.out.println(TerminalColor.YELLOW.apply("============== SELECT YOUR SUBJECT =============="));
        
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(TerminalColor.PURPLE.apply("[" + (i + 1) + "] ") + subjects[i]);
            io.wait(100);
        }
        System.out.println(TerminalColor.YELLOW.apply("================================================="));

        int choice;
        while (true) {
            System.out.print("\nEnter subject number: ");
            choice = io.readInt(); // Using your clean IOHandler method!

            if (choice >= 1 && choice <= subjects.length) {
                return choice; // Exit the method with the valid choice
            } else {
                io.printTyping(TerminalColor.RED.apply("Invalid choice! Please pick a number between 1 and " + subjects.length + "."));
            }
        }
    }

    // A helper method so App can get the name of the subject later
    public String getSubjectName(int index) {
        return subjects[index - 1];
    }
}
