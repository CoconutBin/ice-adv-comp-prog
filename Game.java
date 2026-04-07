import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Hello brave adventurer! What is your name?");
            String name = scanner.nextLine();
            System.out.println("Nice to meet you, " + name + "!");
            entities.Player player = new entities.Player(name);
            
        } catch(Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
