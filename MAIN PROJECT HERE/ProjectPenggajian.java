import java.util.Scanner;

public class ProjectPenggajian {

    public static void main(String[] args) {
        // Array untuk menyimpan username, password, dan role (admin atau user)
        String[] usernames = {"admin", "user1", "user2"};
        String[] passwords = {"adminpass", "user1pass", "user2pass"};
        String[] roles = {"admin", "user"};

        // Membuat objek Scanner untuk input dari pengguna
        Scanner scanner = new Scanner(System.in);

        // Memanggil metode login untuk mendapatkan informasi role (admin atau user)
        String role = login(usernames, passwords, roles, scanner);

        // Menampilkan menu sesuai dengan role
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nMenu Utama:");

            if (role.equals("admin")) {
                System.out.println("1. Menu Admin - Pilihan 1");
                System.out.println("2. Menu Admin - Pilihan 2");
            } else {
                System.out.println("1. Menu User - Pilihan 1");
                System.out.println("2. Menu User - Pilihan 2");
            }

            System.out.println("3. Keluar");

            System.out.print("Pilih menu (1-3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Anda memilih Pilihan 1");
                    break;
                case 2:
                    System.out.println("Anda memilih Pilihan 2");
                    break;
                case 3:
                    System.out.println("Keluar dari program. Sampai jumpa!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-3.");
            }
        }

        // Menutup Scanner setelah pengguna keluar dari program
        scanner.close();
    }

    // Metode untuk login dengan array username, password, dan role
    private static String login(String[] usernames, String[] passwords, String[] roles, Scanner scanner) {
        boolean isLoggedIn = false;
        String role = "";

        while (!isLoggedIn) {
            System.out.print("Masukkan username: ");
            String inputUsername = scanner.next();

            System.out.print("Masukkan password: ");
            String inputPassword = scanner.next();

            // Memeriksa kecocokan username dan password
            for (int i = 0; i < usernames.length; i++) {
                if (usernames[i].equals(inputUsername) && passwords[i].equals(inputPassword)) {
                    System.out.println("Login berhasil! Selamat datang, " + inputUsername + ".");
                    isLoggedIn = true;
                    role = roles[i];
                    break;
                }
            }

            if (!isLoggedIn) {
                System.out.println("Username atau password salah. Coba lagi.");
            }
        }

        return role;
    }
}
