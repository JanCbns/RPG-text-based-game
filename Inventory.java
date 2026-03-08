import java.util.Scanner;

public class Inventory {

    static Weapon[] weapons = {
        new Weapon("Sword"),
        new Weapon("Bow"),
        new Weapon("Knife")
    };

    static Item[] items = {
        new Item("Heal Potion"),
        new Item("Mana Potion")
    };

    public static void open() {
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
            System.out.println("You picked: " + weapons[pick - 1].name);

        } else if (choice == 2) {
            System.out.println("\n--- ITEMS ---");
            for (int i = 0; i < items.length; i++) {
                System.out.println((i + 1) + ". " + items[i].name);
            }
            System.out.print("Pick an item: ");
            int pick = scanner.nextInt();
            System.out.println("You picked: " + items[pick - 1].name);
        }
    }
}
