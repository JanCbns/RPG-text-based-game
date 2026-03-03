public class BossEnemy extends Enemy {
    public BossEnemy() {
        super("Infernal Witch", 120, 20, 15, 500);
    }

    @Override
    public void takeTurn(Entity target) {
        System.out.println("\n--- !!! BOSS TURN !!! ---");
        System.out.println("Infernal Witch unleashes a Sunstrike on " + target.getName() + "!");

        target.receiveDamage(this.getAttack());
        System.out.println("Result: " + target.getName() + " took " + this.getAttack() + " damage!");
    }
}