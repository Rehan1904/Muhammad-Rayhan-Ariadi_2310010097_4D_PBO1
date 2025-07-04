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
}
