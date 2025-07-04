package Game;

public class GameEngine {
    import java.util.Scanner;
    import java.util.Random;

public class GameEngine {
    private Pemain pemain;
    private Monster[] monsters;
    private Senjata[] senjataList;
    private Random random;
    private Scanner scanner;

    public GameEngine() {
        random = new Random();
        scanner = new Scanner(System.in);
        inisialisasiGame();
    }

    private void inisialisasiGame() {
        System.out.println("Selamat datang di Monster Hunter Adventure!");
        System.out.print("Masukkan nama pemain: ");
        String namaPemain = scanner.nextLine();
        
        pemain = new Pemain(namaPemain, 100, 10);
        
        // Inisialisasi monster
        monsters = new Monster[] {
            new Monster("Goblin", "Normal", 30, 5, 20),
            new Monster("Orc", "Kuat", 50, 8, 40),
            new Monster("Dragon", "Boss", 100, 15, 100)
        };
        
        // Inisialisasi senjata
        senjataList = new Senjata[] {
            new Senjata("Pedang Kayu", 5),
            new Senjata("Pedang Besi", 10),
            new Senjata("Pedang Legendaris", 20)
        };
    }

    public void mulai() {
        boolean isRunning = true;
        
        while (isRunning && pemain.isAlive()) {
            tampilkanMenu();
            System.out.print("Pilih aksi: ");
            int pilihan = scanner.nextInt();
            
            switch (pilihan) {
                case 1:
                    berburuMonster();
                    break;
                case 2:
                    tampilkanStatus();
                    break;
                case 3:
                    gantiSenjata();
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    
        if (!pemain.isAlive()) {
            System.out.println("Game Over! " + pemain.getNama() + " telah dikalahkan.");
        }
        
        System.out.println("Terima kasih telah bermain!");
    }

    private void tampilkanMenu() {
        System.out.println("\n=== Menu Utama ===");
        System.out.println("1. Berburu Monster");
        System.out.println("2. Tampilkan Status");
        System.out.println("3. Ganti Senjata");
        System.out.println("4. Keluar");
    }

    private void berburuMonster() {
        Monster monster = monsters[random.nextInt(monsters.length)];
        System.out.println("\nKamu menemukan " + monster.getNama() + "!");
        
        while (pemain.isAlive() && monster.isAlive()) {
            System.out.println("\n" + pemain.getNama() + " (HP: " + pemain.getHealth() + ") vs " + 
                             monster.getNama() + " (HP: " + monster.getHealth() + ")");
            System.out.println("1. Serang");
            System.out.println("2. Kabur");
            System.out.print("Pilih aksi: ");
            int pilihan = scanner.nextInt();
            
            if (pilihan == 1) {
                pemain.serang(monster);
                if (monster.isAlive()) {
                    monster.serang(pemain);
                }
            } else if (pilihan == 2) {
                System.out.println("Kamu berhasil kabur!");
                return;
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }
        
        if (!monster.isAlive()) {
            System.out.println("Kamu berhasil mengalahkan " + monster.getNama() + "!");
            pemain.tambahExp(monster.getExpReward());
        }
    }

    private void tampilkanStatus() {
        System.out.println("\n=== Status Pemain ===");
        System.out.println("Nama: " + pemain.getNama());
        System.out.println("Level: " + pemain.getLevel());
        System.out.println("EXP: " + pemain.getExp() + "/" + (pemain.getLevel() * 100));
        System.out.println("HP: " + pemain.getHealth());
        System.out.println("Attack Power: " + pemain.getAttackPower());
        System.out.println("Senjata: " + pemain.getSenjata().getNama() + " (+" + pemain.getSenjata().getDamage() + " damage)");
    }

    private void gantiSenjata() {
        System.out.println("\n=== Daftar Senjata ===");
        for (int i = 0; i < senjataList.length; i++) {
            System.out.println((i+1) + ". " + senjataList[i].getNama() + " (+" + senjataList[i].getDamage() + " damage)");
        }
        
        System.out.print("Pilih senjata: ");
        int pilihan = scanner.nextInt();
        
        if (pilihan > 0 && pilihan <= senjataList.length) {
            pemain.setSenjata(senjataList[pilihan-1]);
            System.out.println("Senjata berhasil diganti ke " + pemain.getSenjata().getNama());
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }

    public static void main(String[] args) {
        GameEngine game = new GameEngine();
        game.mulai();
    }
}
