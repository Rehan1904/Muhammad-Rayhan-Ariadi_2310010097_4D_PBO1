package Game;

public class Senjata {
    public class Senjata {
    private String nama;
    private int damage;

    public Senjata(String nama, int damage) {
        this.nama = nama;
        this.damage = damage;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
