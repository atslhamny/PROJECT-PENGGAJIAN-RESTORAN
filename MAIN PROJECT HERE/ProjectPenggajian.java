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

            if (role.equalsIgnoreCase("admin")) {
                adminMenu(scanner);
            } else if (role.equalsIgnoreCase("user")) {
                userMenu(scanner);
            }else
            break;
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

    // Fungsi untuk menampilkan menu admin
    private static void adminMenu(Scanner scanner) {
        boolean isUserMenuRunning = true;

        while (isUserMenuRunning) {
            System.out.println("Menu User:");
            System.out.println("1. Menu User - Pilihan 1");
            System.out.println("2. Menu User - Pilihan 2");
            System.out.println("3. Absensi");
            System.out.println("4. Kembali ke Menu Utama");

            System.out.print("Pilih menu (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Anda memilih Pilihan 1");
                    break;
                case 2:
                    System.out.println("Anda memilih Pilihan 2");
                    break;
                case 3:
                    // Add your attendance feature logic here
                    System.out.println("Anda memilih Absensi");
                    break;
                case 4:
                    System.out.println("Kembali ke Menu Utama");
                    isUserMenuRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-4.");
            }
        }
    }

    // Fungsi untuk menampilkan menu user
    private static void userMenu(Scanner scanner) {
        boolean isUserMenuRunning = true;

        while (isUserMenuRunning) {
            System.out.println("Menu User:");
            System.out.println("1. Menu User - Pilihan 1");
            System.out.println("2. Menu User - Pilihan 2");
            System.out.println("3. Absensi");
            System.out.println("4. Kembali ke Menu Utama");

            System.out.print("Pilih menu (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Anda memilih Pilihan 1");
                    break;
                case 2:
                    System.out.println("Anda memilih Pilihan 2");
                    break;
                case 3:
                    // Add your attendance feature logic here
                    System.out.println("Anda memilih Absensi");
                    break;
                case 4:
                    System.out.println("Kembali ke Menu Utama");
                    isUserMenuRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-4.");
            }
        }
    }
}