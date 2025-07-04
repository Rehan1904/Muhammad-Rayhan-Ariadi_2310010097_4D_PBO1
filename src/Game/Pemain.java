package Game;

public class Pemain {
    public class Pemain extends Karakter {
    private int level;
    private int exp;
    private Senjata senjata;

    public Pemain(String nama, int health, int attackPower) {
        super(nama, health, attackPower);
        this.level = 1;
        this.exp = 0;
        this.senjata = new Senjata("Tangan Kosong", 0);
    }

    // Override method serang untuk menambahkan efek senjata
    @Override
    public void serang(Karakter target) {
        int totalDamage = getAttackPower() + senjata.getDamage();
        System.out.println(getNama() + " menyerang dengan " + senjata.getNama() + "!");
        target.terimaDamage(totalDamage);
    }

    // Method untuk naik level
    public void tambahExp(int jumlah) {
        exp += jumlah;
        if (exp >= level * 100) {
            level++;
            exp = 0;
            setAttackPower(getAttackPower() + 5);
            setHealth(getHealth() + 20);
            System.out.println("Level up! Sekarang level " + level);
        }
    }

    // Getter dan Setter
    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public Senjata getSenjata() {
        return senjata;
    }

    public void setSenjata(Senjata senjata) {
        this.senjata = senjata;
    }
}
