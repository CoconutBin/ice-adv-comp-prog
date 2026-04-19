import java.util.Random;
import java.util.Scanner;

public class App {

    public static final String RESET = "\u001B[0m";
    public static final String RED    = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN  = "\u001B[32m";
    public static final String CYAN   = "\u001B[36m";
    public static final String BLUE   = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String ORANGE = "\u001B[38;2;255;165;0m";
    public static final String PINK   = "\u001B[38;2;255;192;203m";
    public static final String LIGHT_GREY = "\u001B[90m";

    public static void fullClear() {
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void clearLine(int lineNum) {
        System.out.print("\033[" + lineNum + ";1H\033[2K");
        System.out.flush();
    }

    public static void wait(int ms){
        try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
    }
    public static int delay = 20;
    public static void typing(String message) {
        for (char c : message.toCharArray()) {
            System.out.print(c);
            System.out.flush();
            wait(delay);
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        
        final game.IOHandler ioHandler = new game.IOHandler();
        
        entities.boss.Boss boss = new entities.boss.Boss(100);
        fullClear();
        
        System.out.println(RED     + "   /██████  /██   /██ /██████ /████████        /██████  /██        /██████  /██     /██ /████████ /███████ " + RESET);
        System.out.println(ORANGE  + " /██__  ██| ██  | ██|_  ██_/|_____ ██        /██__  ██| ██       /██__  ██|  ██   /██/| ██_____/| ██__  ██" + RESET);
        System.out.println(YELLOW  + "| ██  \\ ██| ██  | ██  | ██       /██/       | ██  \\__/| ██      | ██  \\ ██ \\  ██ /██/ | ██      | ██  \\ ██" + RESET);
        System.out.println(GREEN   + "| ██  | ██| ██  | ██  | ██      /██/        |  ██████ | ██      | ████████  \\  ████/  | █████   | ███████/" + RESET);
        System.out.println(CYAN    + "| ██  | ██| ██  | ██  | ██     /██/          \\____  ██| ██      | ██__  ██   \\  ██/   | ██__/   | ██__  ██" + RESET);
        System.out.println(BLUE    + "| ██/██ ██| ██  | ██  | ██    /██/           /██  \\ ██| ██      | ██  | ██    | ██    | ██      | ██  | ██" + RESET);
        System.out.println(PURPLE  + "|  ██████/|  ██████/ /██████ /████████      |  ██████/| ████████| ██  | ██    | ██    | ████████| ██  | ██" + RESET);
        System.out.println(PINK    + " \\____ ███ \\______/ |______/|________/       \\______/ |________/|__/  |__/    |__/    |________/|__/  |__/" + RESET);
        System.out.println(PINK    + "      \\__/                                                                                                " + RESET);
        System.out.println("\n                                           - Press Enter to start -");
        
        Thread cleaner = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {

                    clearLine(11);
                    
                    Thread.sleep(500);

                    System.out.print("\033[11;1H" + "                                           - Press Enter to start -" + RESET);
                    System.out.flush();

                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {}
        });

        cleaner.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); 
        cleaner.interrupt();

        fullClear();

        System.out.println(YELLOW + "============== SELECT YOUR SUBJECT ==============" + RESET);
        String[] subjects = {
            "Calculus I", 
            "Physics I", 
            "Calculus II", 
            "Physics II", 
            "Computer Programming", 
            "Advance Computer Programming", 
            "Probability and Statistics for Data Analysis"
        };

        for (int i = 0; i < subjects.length; i++) {
            System.out.println(PURPLE + "[" + (i + 1) + "] " + RESET + subjects[i]);
            wait(100);
        }
        System.out.println(YELLOW + "=================================================" + RESET);

        // 6. Handle Selection
        int choice = -1; // Initialize with an invalid value
        
        while (true) {
            System.out.print("\nEnter subject number: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                // Check if the number is within the valid range
                if (choice >= 1 && choice <= subjects.length) {
                    // SUCCESS: Valid choice, break the loop
                    break; 
                } else {
                    // ERROR: Number out of range
                    typing(RED + "Invalid choice! Please pick a number between 1 and " + subjects.length + "." + RESET);
                }
            } else {
                // ERROR: User entered text instead of a number
                System.out.println(RED + "Error: That's not a number. Try again." + RESET);
                scanner.next(); // CRITICAL: Clear the "junk" input from the scanner buffer
            }
        }

        fullClear();
        typing(YELLOW + "--- " + subjects[choice - 1].toUpperCase() + " ---" + RESET);
        wait(1000);

        typing(PURPLE + "[!] THE VOID OPENS (smells like cheap coffee and regret)..." + RESET);
        typing("A voice echoes: 'State your name, mortal, so we can misspell it on your final certificate.'");
        System.out.print(CYAN + "--> " + RESET);

        String playerName = ioHandler.readLine();
        entities.Player player = new entities.Player(playerName.isEmpty() ? "Academic Probation" : playerName, 100);

        String BossName = attacks.question.QuestionBank.getInstance().getBossName(choice);
        String BossIntro = attacks.question.QuestionBank.getInstance().getBossIntro(choice);

        typing("\n" + YELLOW + "Ah, " + player.getName() + "..." + RESET);
        wait(500);
        typing("You stand at the threshold of the Seven Subjects. A place where dreams go to be graded.");
        typing("Knowledge is your blade. Logic is your shield. A Calculator with low battery is your only friend.");
        wait(800);
        typing("If you falter, your GPA will be lower than the bar for a TikTok challenge.");
        wait(1500);

        typing("Searching for a spark of intelligence...");
        wait(800);
        typing("Error: Spark not found. Proceeding anyway...");
        wait(500);
        typing("Simulating student loan interest rates...");
        wait(500);
        typing("Destroying your eyesights..." + RESET);
        wait(1000);
        clearScreen();
        typing(RED + "--- " + BossName + " --- descends" + RESET);
        wait(1000);
        typing(BossIntro);
        wait(1000);
        while (boss.getHp() > 0 && player.getHp() > 0) {

            attacks.question.Question question = attacks.question.QuestionBank.getInstance().getUniqueQuestion(choice);
            String playerAnswer = question.askQuestion(ioHandler);
            boolean isCorrect = question.isCorrect(playerAnswer);
            ioHandler.clearTerminal();

            Random rand = new Random();

            if (isCorrect) {
                typing(GREEN + "[!] CORRECT! The answer is: " + YELLOW + question.getAnswer() + GREEN + "\nPrepare your strike! " + RESET);
                System.out.println("Striking [1] Head [2] Body [3] Legs");
                
                int aim = scanner.nextInt();
                int weakPoint = rand.nextInt(3) + 1; // Randomly chooses 1, 2, or 3
                int blockedPoint = (weakPoint % 3) + 1; // Different from weakPoint

                if (aim == weakPoint) {
                    typing(YELLOW + "CRITICAL HIT! You found the weak spot!" + RESET);
                    boss.updateHp(-10);
                } else if (aim == blockedPoint) {
                    typing(LIGHT_GREY + "Change your glasses, the boss is on the other side." + RESET);
                    boss.updateHp(0);
                } else {
                    typing(CYAN + "Average strike to the " + (aim == 1 ? "Head" : aim == 2 ? "Body" : "Legs") + "." + RESET);
                    boss.updateHp(-5);
                }
                            
                // Simple health bar representation
                String bossBar = "";
                String bossBarMissing = "";
                for (int i = 0; i < 20; i++) {
                    if (i < Math.max(0, boss.getHp() / 5)){
                        bossBar += "█";
                    }
                    else{
                        bossBarMissing += "█";
                    }
                }
                System.out.println(RED + BossName + " HP: " + bossBar + LIGHT_GREY + bossBarMissing + RESET);
            } 
            else {

                typing(RED + "[X] WRONG! The answer is " + CYAN + question.getAnswer() + RED + "\nThe boss counters! DODGE!" + RESET);
                System.out.println("Dodge to [1] Left [2] Right [3] Duck");

                int dodge = scanner.nextInt();
                int safeZone = rand.nextInt(3) + 1;
                int trapZone = (safeZone % 3) + 1;

                if (dodge == safeZone) {
                    typing(GREEN + "PERFECT DODGE! You took no damage." + RESET);
                    player.updateHp(0);
                } else if (dodge == trapZone) {
                    typing(RED + "??? You jumped right into the blade!" + RESET);
                    player.updateHp(-10);
                } else {
                    typing(LIGHT_GREY + "A glancing blow. You took standard damage." + RESET);
                    player.updateHp(-5);
                }
                
                String playerBar = "";
                String playerBarMissing = "";
                for (int i = 0; i < 20; i++) {
                    if (i < Math.max(0, player.getHp() / 5)){
                        playerBar += "█";
                    }
                    else{
                        playerBarMissing += "█";
                    }
                }
                System.out.println(GREEN + player.getName() + " HP: " + playerBar + LIGHT_GREY + playerBarMissing + RESET);
            }

            wait(1000);
            clearScreen();
        }

        if (player.getHp() <= 0) {      //this part is not done yet
            System.out.println("\n" + RED + "========================================" + RESET);
            typing(RED + " [X] FATAL BLOW SUSTAINED... " + RESET);
            typing(LIGHT_GREY + " Your vision fades as the Boss stands over you." + RESET);
            typing(RED + " G A M E   O V E R " + RESET);
            System.out.println(RED + "========================================" + RESET);
            System.exit(0); // Ends the program
        }

        if (boss.getHp() <= 0) {
            System.out.println("\n" + YELLOW + "****************************************" + RESET);
            typing(GREEN + " [!] THE BEAST FALLS! " + RESET);
            typing(CYAN + " " + player.getName() + " has conquered the Quiz Slayer challenge!" + RESET);
            typing(YELLOW + " V I C T O R Y   A C H I E V E D " + RESET);
            System.out.println(YELLOW + "****************************************" + RESET);
            
            // Maybe show a final score?
            typing(PURPLE + " Final Health: " + player.getHp() + " HP" + RESET);
        }
    }
}
