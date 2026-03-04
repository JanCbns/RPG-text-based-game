public class Enemy extends Entity {
    private int lootValue;

    public Enemy(String name, int hp, int attack, int speed, int gold) {
        super(name, hp, hp, attack, speed);
        this.lootValue = gold;
    }

    /*@Override*/
    
    public void takeTurn(Entity target) {
        System.out.println("\n--- " + this.getName().toUpperCase() + "'S TURN ---");

        System.out.println("HP: " + this.getHp() + "/" + this.getMaxHp());
        System.out.println(this.getName() + " attacks " + target.getName() + "!");

        target.receiveDamage(this.getAttack());
        System.out.println("Result: " + target.getName() + " took " + this.getAttack() + " damage!");
    }

    public int getLootValue() {
        return lootValue;
    }
}