public class Troll extends Enemy {

    public Troll() {
        super("Troll", 65, 13, 15, 18);
    }

    @Override
    public void takeTurn(Entity target) {
        System.out.println("\n--- " + this.getName().toUpperCase() + "'S TURN ---");

        System.out.println("HP: " + this.getHp() + "/" + this.getMaxHp());
        System.out.println("The Zombie moans and bites at " + target.getName() + "!");

        target.receiveDamage(this.getAttack());
        System.out.println("Result: " + target.getName() + " took " + this.getAttack() + " damage!");
    }
}