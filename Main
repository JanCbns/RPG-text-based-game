import java.util.Scanner;
import java.util.Random;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static CombatManager combat = new CombatManager();
    private static Player player;
    private static int choiceCounter = 0;

    public static void main(String[] args) {
        System.out.println("=== SUKADI BOI'S RPG ===");
        System.out.print("Hero Name: ");
        player = new Player(scanner.nextLine(), 100, 15, 12);

        while (player.getHp() > 0) {
            choiceCounter++;
            
            // 5th Round Boss Trigger
            if (choiceCounter == 5) {
                System.out.println("\n!!! THE BOSS APPROACHES !!!");
                combat.startCombat(player, new BossEnemy());
                choiceCounter = 0; // Reset
            } else {
                handleSelection();
            }

            if (player.getHp() > 0) {
                handleCamp();
            }
        }
        System.out.println("\nGAME OVER. " + player.getName() + " has fallen.");
    }

    private static void handleSelection() {
        System.out.println("\n[Round " + choiceCounter + "] Pick a path:");
        String[] paths = {"Combat", "Item", "Shop"};
        // Displaying 3 random choices (simplified to picking one of the types)
        System.out.println("1. " + paths[0] + " | 2. " + paths[1] + " | 3. " + paths[2]);
        
        String choice = scanner.nextLine();
        switch (choice) {
            case "2": // Item Path
                String pType = random.nextBoolean() ? "Heal Potion" : "Mana Potion";
                System.out.println("Found a " + pType + "!");
                player.addItem(new Item(pType));
                break;
            case "3": // Shop Path
                handleShop();
                break;
            default: // Combat Path
                combat.startCombat(player, getRandomEnemy());
                break;
        }
    }

    private static void handleShop() {
        System.out.println("\nSHOP (Gold: " + player.getGold() + ")");
        System.out.println("1. Heal Potion (20g) | 2. Mana Potion (20g) | 3. Leave");
        String choice = scanner.nextLine();
        if (choice.equals("1") && player.getGold() >= 20) {
            player.addItem(new Item("Heal Potion"));
            player.addGold(-20);
        } else if (choice.equals("2") && player.getGold() >= 20) {
            player.addItem(new Item("Mana Potion"));
            player.addGold(-20);
        }
    }

    private static void handleCamp() {
        System.out.println("\n--- CAMP PHASE ---");
        System.out.println("1. Heal Up (+30 HP) | 2. Prepare (+20 Temp Mana)");
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            player.setHp(player.getHp() + 30);
        } else {
            player.setTempMana(20);
        }
    }

    private static Enemy getRandomEnemy() {
        int r = random.nextInt(3);
        if (r == 0) return new Goblin();
        if (r == 1) return new Skeleton();
        return new Troll();
    }
}
