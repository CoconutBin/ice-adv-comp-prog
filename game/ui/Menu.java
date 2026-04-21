package game.ui;

import attacks.question.Subject;
import game.io.IOHandler;

public class Menu {
    private final IOHandler io;

    public Menu(IOHandler io) {
        this.io = io;
    }

    public boolean shouldSkip(game.io.IOHandler io) {
        io.print(TerminalColor.LIGHT_GREY.apply("\n[ Press 'x' to skip intro]"));
        io.inlinePrint(TerminalColor.CYAN.apply("--> "));
        
        String input = io.readLine();
        
        // Returns true if the user typed x
        return input.equalsIgnoreCase("x");
    }

    public int selectSpecialty() {
        io.print(TerminalColor.YELLOW.apply(io.center(" PICK YOUR GIFT ", 120, "=")));
        io.print(TerminalColor.PURPLE.apply("[1]") + " INTELLIGENCE");
        io.print(TerminalColor.PURPLE.apply("[2]") + " STRENGTH");
        io.print(TerminalColor.PURPLE.apply("[3]") + " CHARISMA");
        io.print(TerminalColor.YELLOW.apply(io.center("", 120, "=")));

        while (true) {
            io.inlinePrint("--> ");
            try {
                String input = io.readLine();
                int choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 3;
                    default:
                        io.print("Pick 1, 2, or 3!");
                        break;
                }
            } catch (NumberFormatException e) {
                io.print("Invalid input. Pick a number.");
            }
        }
    }

    public Subject subjectSelection() {
        io.print(TerminalColor.YELLOW.apply(io.center(" SELECT YOUR SUBJECT ", 120, "=")));
        
        for (int i = 0; i < Subject.values().length; i++) {
            io.print(TerminalColor.PURPLE.apply("[" + (i + 1) + "] ") + Subject.fromId(i + 1).getDisplayName());
            io.wait(100);
        }
        io.print(TerminalColor.YELLOW.apply(io.center("", 120, "=")));

        while (true) {
            io.inlinePrint("\nEnter subject number: ");
            
            try {
                String input = io.readLine();             
                int choice = Integer.parseInt(input);
                return Subject.fromId(choice); 
                
            } catch (NumberFormatException e) {
                io.printTyping(TerminalColor.RED.apply("Error: Please enter a valid NUMBER."));
            } catch (IllegalArgumentException e) {
                io.printTyping(TerminalColor.RED.apply("Invalid choice! Pick a number between 1 and " + Subject.values().length + "."));
            }
        }
    }
}
