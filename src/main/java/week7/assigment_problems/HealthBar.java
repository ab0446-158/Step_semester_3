public class HealthBar {

    private int health;
    private final int maximumHealth;

    public HealthBar(int maximumHealth) {
        this.maximumHealth = maximumHealth;
        this.health = maximumHealth;
    }

    public void takeDamage(int amount) {
        health = health - amount;

        if (health < 0) {
            health = 0;
        }
    }

    public void heal(int amount) {
        health = health + amount;

        if (health > maximumHealth) {
            health = maximumHealth;
        }
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {

        HealthBar c = new HealthBar(100);

        c.takeDamage(30);
        System.out.println("After 30 damage: " + c.getHealth());

        c.heal(50);
        System.out.println("After 50 healing: " + c.getHealth());

        c.takeDamage(150);
        System.out.println("After 150 damage: " + c.getHealth());
    }
}