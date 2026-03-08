public class Player extends Entity {
    private int mana;
    private int tempMana;
    private int gold;

    public Player(String name) {
        super(name, 100, 100, 20, 12);
        this.mana = 50;
        this.tempMana = 0;
        this.gold = 50;
    }

    public int getTotalMana() {
        return mana + tempMana;
    }

    public void useMana(int amount) {
        if (tempMana >= amount) {
            tempMana -= amount;
        } else {
            int remaining = amount - tempMana;
            tempMana = 0;
            mana -= remaining;
        }
    }

    public void flushTempMana() {
        this.tempMana = 0;
    }

    public void addTempMana(int amount) {
        this.tempMana += amount;
    }

    public void addGold(int amount) { this.gold += amount; }
    public int getGold() { return gold; }
}
