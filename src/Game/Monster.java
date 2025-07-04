package Game;

public class Monster {
    public class Monster extends Karakter {
    private String jenis;
    private int expReward;

    public Monster(String nama, String jenis, int health, int attackPower, int expReward) {
        super(nama, health, attackPower);
        this.jenis = jenis;
        this.expReward = expReward;
    }

    // Method khusus monster
    public String getJenis() {
        return jenis;
    }

    public int getExpReward() {
        return expReward;
    }

    // Override method serang untuk menambahkan efek khusus
    @Override
    public void serang(Karakter target) {
        System.out.println(getNama() + " menyerang dengan cakar!");
        super.serang(target);
    }
}
