package game;

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

    public boolean shouldSkip(game.IOHandler io) {
        System.out.println(game.TerminalTools.LIGHT_GREY + "\n[ Press 'x' to skip intro]" + game.TerminalTools.RESET);
        System.out.print(game.TerminalTools.CYAN + "--> " + game.TerminalTools.RESET);
        
        String input = io.readLine();
        
        // Returns true if the user typed x
        return input.equalsIgnoreCase("x");
    }

    public int SubjectSelection() {
        System.out.println(TerminalTools.YELLOW + "============== SELECT YOUR SUBJECT ==============" + TerminalTools.RESET);
        
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(TerminalTools.PURPLE + "[" + (i + 1) + "] " + TerminalTools.RESET + subjects[i]);
            TerminalTools.wait(100);
        }
        System.out.println(TerminalTools.YELLOW + "=================================================" + TerminalTools.RESET);

        int choice;
        while (true) {
            System.out.print("\nEnter subject number: ");
            choice = io.readInt(); // Using your clean IOHandler method!

            if (choice >= 1 && choice <= subjects.length) {
                return choice; // Exit the method with the valid choice
            } else {
                TerminalTools.typing(TerminalTools.RED + "Invalid choice! Please pick a number between 1 and " + subjects.length + "." + TerminalTools.RESET);
            }
        }
    }

    // A helper method so App can get the name of the subject later
    public String getSubjectName(int index) {
        return subjects[index - 1];
    }
}
