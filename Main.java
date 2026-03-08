public class Main {
    public static void main(String[] args) {
        Player hero = new Player("Hero");
        GameManager engine = new GameManager(hero);
        engine.startGame();
    }
}
