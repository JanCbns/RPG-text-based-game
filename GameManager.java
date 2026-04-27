import java.util.Scanner;
import java.util.Random;

public class GameManager {
    private Player player;
    private int choiceCounter = 0;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public GameManager(Player player) {
        this.player = player;
    }

    public void startGame() {
        while (player.getHp() > 0) {
            choiceCounter++;

            if (choiceCounter % 5 == 0) {
                System.out.println("\n!!! BOSS ENCOUNTER !!!");
                startCombat(new BossEnemy());
                choiceCounter = 0; // Reset after boss
            } else {
                showEventSelection();
            }

            if (player.getHp() > 0) {
                enterCampPhase();
            }
        }
        System.out.println("GAME OVER.");
    }

    private void showEventSelection() {
        System.out.println("\n--- Round " + choiceCounter + " ---");
        System.out.println("1. Combat | 2. Shop | 3. Open Inventory");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> startCombat(generateRandomEnemy());
            case 2 -> openShop();
            case 3 -> Inventory.open(player);
            default -> System.out.println("You wander aimlessly...");
        }
    }

    private Enemy generateRandomEnemy() {
        int rand = random.nextInt(3);
        return switch (rand) {
            case 0 -> new Goblin();
            case 1 -> new Skeleton();
            default -> new Troll();
        };
    }

    private void startCombat(Enemy enemy) {
        System.out.println("A " + enemy.getName() + " appears!");

        while (player.getHp() > 0 && enemy.getHp() > 0) {
            if (player.getSpeed() >= enemy.getSpeed()) {
                playerTurn(enemy);
                if (enemy.getHp() > 0) enemy.takeTurn(player);
            } else {
                enemy.takeTurn(player);
                if (player.getHp() > 0) playerTurn(enemy);
            }
        }

        if (player.getHp() > 0) {
            System.out.println("Victory! + " + enemy.getLootValue() + " gold.");
            player.addGold(enemy.getLootValue());
            player.flushTempMana(); // Clear temp mana after fight
        }
    }

    private void playerTurn(Enemy enemy) {
        System.out.println("\n--- YOUR TURN ---");
        System.out.println("HP: " + player.getHp() + " | Mana: " + player.getTotalMana());
        System.out.println("1. Attack | 2. Use Skill | 3. Open Inventory");
        int action = scanner.nextInt();

        if (action == 1) {
            int damage = player.getAttack();
            enemy.receiveDamage(damage);
            System.out.println("You hit " + enemy.getName() + " for " + damage + " damage!");
        } else if (action == 2) {
            useSkill(enemy);
        } else {
            Inventory.open(player);
        }
    }

    private void useSkill(Enemy enemy) {
        System.out.println("\n--- SKILLS (Mana: " + player.getTotalMana() + ") ---");
        System.out.println("1. Fireball (20 dmg, 30 mana)");
        System.out.println("2. Wind Slash (25 dmg, 40 mana)");
        System.out.println("3. Hydro Pulse (30 dmg, 50 mana)");
        int choice = scanner.nextInt();

        int damage = 0;
        int manaCost = 0;

        switch (choice) {
            case 1 -> { damage = 20; manaCost = 30; }
            case 2 -> { damage = 25; manaCost = 40; }
            case 3 -> { damage = 30; manaCost = 50; }
            default -> { System.out.println("Invalid choice!"); return; }
        }

        if (player.getTotalMana() >= manaCost) {
            player.useMana(manaCost);
            enemy.receiveDamage(damage);
            System.out.println("You cast the skill and dealt " + damage + " damage to " + enemy.getName() + "!");
        } else {
            System.out.println("Not enough mana!");
        }
    }


    private void openShop() {
        System.out.println("\n--- SHOP --- Gold: " + player.getGold());
        System.out.println("1. Buy " + Inventory.items[0].name + " (25g)");
        System.out.println("2. Exit");
        int choice = scanner.nextInt();

        if (choice == 1 && player.getGold() >= 25) {
            player.addGold(-25);
            System.out.println("Bought " + Inventory.items[0].name + "!");
        }
    }

    private void enterCampPhase() {
        System.out.println("\n--- CAMP PHASE ---");
        System.out.println("1. Heal Up | 2. Prepare (Temp Mana)");
        int choice = scanner.nextInt();

        if (choice == 1) {
            player.setHp(player.getHp() + 30);
            System.out.println("Restored HP.");
        } else {
            player.addTempMana(20);
            System.out.println("Prepared for the next battle!");
        }
    }


}    
