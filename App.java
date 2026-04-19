public class App {
    public static void main(String[] args) {
        game.GameEngine gameEngine = new game.GameEngine();

        gameEngine.initializeGame();
        gameEngine.startGameLoop();
    }
}
