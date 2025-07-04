package Game;

public class Karakter {
    private String nama;
    private int health;
    private int attackPower;

    public Karakter(String nama, int health, int attackPower) {
        this.nama = nama;
        this.health = health;
        this.attackPower = attackPower;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    // Method untuk menyerang
    public void serang(Karakter target) {
        target.terimaDamage(this.attackPower);
    }

    // Method untuk menerima damage
    public void terimaDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    // Method untuk cek apakah masih hidup
    public boolean isAlive() {
        return health > 0;
    }
}