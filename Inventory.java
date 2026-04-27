import java.util.*;

public class Inventory {

    static Weapon[] weapons = {
        new Weapon("Sword"),
        new Weapon("Bow"),
        new Weapon("Knife")
        new Weapon("Axe"),        
        new Weapon("Magic Staff")
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
            if (pick == 1) {   // sa sword ni siya
                player.setAttack(player.getAttack() + 15);
                System.out.println("You picked sword");
            }

            else if (pick == 2) {   // sa bow ni
                player.setAttack(player.getAttack() + 10);
                System.out.println("You picked Bow");
            }

            else if (pick == 3) {   // knife/kutsilyo
                player.setAttack(player.getAttack() + 5);
                System.out.println("You picked Knife");
            }
        }

        else if (choice == 2) {
            System.out.println("\n--- ITEMS ---");
            for (int i = 0; i < items.length; i++) {
                System.out.println((i + 1) + ". " + items[i].name);
            }

            System.out.print("Pick an item: ");
            int pick = scanner.nextInt();

            if (pick == 1) {   // heal potion
                player.setHp(player.getHp() + 50);
                System.out.println("You used Heal Potion! +50 HP");
            }

            else if (pick == 2) {   // mana potion
                player.addTempMana(40);
                System.out.println("You used Mana Potion! +40 Mana");
            }
        }
    }
}
 
