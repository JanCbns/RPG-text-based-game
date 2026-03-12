public abstract class Entity {
    private String name;
    private int hp, maxHp, attack, speed;

    public Entity(String name, int hp, int maxHp, int attack, int speed) {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.attack = attack;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getMaxHp() {
        return maxHp;
    }
    public int getAttack() {
        return attack;

    }
    public int getSpeed() {
        return speed;

    }

    void setAttack(int attack){
        this.attack = attack;
    }

    public void setHp(int hp) {
        this.hp = hp;
        if (this.hp > maxHp) this.hp = maxHp;
    }

    public void receiveDamage(int amount) {
        this.hp -= amount;
        if (this.hp <= 0) this.hp = 0;
    }

}
