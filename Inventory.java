import java.util.*;

public class Inventory {

    static Weapon[] weapons = {
        new Weapon("Sword", 15, 0),
        new Weapon("Bow", 10, 0),
        new Weapon("Knife", 5, 0),
        new Weapon("Axe", 20, 0),
        new Weapon("Magic Staff", 12, 20)
    };

    static Item[] items = {
        new Item("Heal Potion"),
        new Item("Mana Potion")
    };

    public static void open(Player player) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== INVENTORY ===");
        System.out.println("1. Weapons");
        System.out.println("2. Items");
        System.out.print("Choose: ");

        int choice = scanner.nextInt();

        if (choice == 1) {

            System.out.println("\n--- WEAPONS ---");

            for (int i = 0; i < weapons.length; i++) {
                System.out.println((i + 1) + ". " + weapons[i].name);
            }

            System.out.print("Pick a weapon: ");
            int pick = scanner.nextInt();

            if (pick >= 1 && pick <= weapons.length) {
                Weapon selected = weapons[pick - 1];

                player.setAttack(player.getAttack() + selected.attackBonus);
                player.addTempMana(selected.manaBonus);

                System.out.println("You picked " + selected.name + "!");
            } else {
                System.out.println("Invalid choice!");
            }
        }

        else if (choice == 2) {

            System.out.println("\n--- ITEMS ---");

            for (int i = 0; i < items.length; i++) {
                System.out.println((i + 1) + ". " + items[i].name);
            }

            System.out.print("Pick an item: ");
            int pick = scanner.nextInt();

            if (pick == 1) {
                player.setHp(player.getHp() + 50);
                System.out.println("You used Heal Potion! +50 HP");
            }
            else if (pick == 2) {
                player.addTempMana(40);
                System.out.println("You used Mana Potion! +40 Mana");
            }
            else {
                System.out.println("Invalid choice!");
            }
        }

        else {
            System.out.println("Invalid category!");
        }
    }
}
