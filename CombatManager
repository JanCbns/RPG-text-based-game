import java.util.Scanner;

public class CombatManager {
    private Scanner scanner = new Scanner(System.in);

    public void startCombat(Player player, Enemy enemy) {
        System.out.println("\n--- BATTLE START: " + player.getName() + " vs " + enemy.getName() + " ---");

        while (enemy.getHp() > 0 && player.getHp() > 0) {
            // Compare Player.speed vs Enemy.speed for turn order
            if (player.getSpeed() >= enemy.getSpeed()) {
                playerTurn(player, enemy);
                if (enemy.getHp() > 0) enemy.takeTurn(player);
            } else {
                enemy.takeTurn(player);
                if (player.getHp() > 0) playerTurn(player, enemy);
            }
        }

        if (player.getHp() > 0) {
            System.out.println("\nVICTORY! Gained " + enemy.getLootValue() + " gold.");
            player.addGold(enemy.getLootValue());
            player.clearTempMana(); // Flushed after combat
        }
    }

    private void playerTurn(Player player, Enemy enemy) {
        System.out.println("\n" + player.getName() + " HP: " + player.getHp() + " | Mana: " + (player.getMana() + player.getTempMana()));
        System.out.println("1. Attack | 2. Skill (15 Mana) | 3. Use Item");
        
        String choice = scanner.nextLine();
        switch (choice) {
            case "2":
                if (player.useMana(15)) {
                    System.out.println("Used Skill! Double Damage!");
                    enemy.receiveDamage(player.getAttack() * 2);
                } else {
                    System.out.println("Lacking mana! Basic attack used.");
                    enemy.receiveDamage(player.getAttack());
                }
                break;
            case "3":
                player.useItem();
                break;
            default:
                System.out.println("You attack!");
                enemy.receiveDamage(player.getAttack());
                break;
        }
    }
}
