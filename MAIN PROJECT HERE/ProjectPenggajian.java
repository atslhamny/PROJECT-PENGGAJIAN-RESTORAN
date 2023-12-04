import java.util.Scanner;

public class ProjectPenggajian {
    static Scanner scanner = new Scanner(System.in);

    static String skip;
    static int jumlahKaryawan = 10;
    static String dataKaryawan[][] = new String[jumlahKaryawan][10];
    static boolean[][] absensiKaryawan = new boolean[jumlahKaryawan][31];

    public static void main(String[] args) {
        // Array untuk menyimpan username, password, dan role (admin atau user)
        String[] usernames = {
            "admin",
            "user1",
            "user2",
            "user3"
        };
        String[] passwords = {
            "adminpass",
            "user1pass",
            "user2pass",
            "userpass3"
        };
        String[] roles = {
            "admin",
            "user"
        };


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
            } else
                break;
        }

        // Menutup Scanner setelah pengguna keluar dari program
        scanner.close();
    }

    // Metode untuk login dengan array username, password, dan role
    public static String login(String[] usernames, String[] passwords, String[] roles, Scanner scanner) {
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
    public static void adminMenu(Scanner scanner) {
        boolean isAdminMenu = true;

        while (isAdminMenu) {
            System.out.println("Menu Admin:");
            System.out.println("1. Input Data Karyawan");
            System.out.println("2. Input Absensi");
            System.out.println("3. Input Izin/Cuti");
            System.out.println("4. Total Penggajian");
            System.out.println("5. Rekapan Penggajian");

            System.out.print("Pilih MENU: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("========Input Data Karyawan=======");
                    for (int i = 0; i < jumlahKaryawan; i++) { //Perulangan untuk menginput dataKaryawan
                        System.out.println("\nData Karyawan ke-" + (i + 1));
                        System.out.print("Nama: ");
                        dataKaryawan[i][0] = scanner.nextLine();
                        System.out.print("Posisi: ");
                        dataKaryawan[i][1] = scanner.nextLine();
                        System.out.print("Nomor Rekening: ");
                        dataKaryawan[i][2] = scanner.nextLine(); //Menggunakan nextLine untuk membaca seluruh baris

                        System.out.println("Apakah Anda ingin Melihat Data Karyawan yang telah di Inputkan? Ya/Tidak");
                        skip = scanner.nextLine(); //Membersihkan newLine

                        if (skip.equalsIgnoreCase("Ya")) {
                            System.out.println("------------------------------------------------------");
                            System.out.println("---------------------Data Karyawan--------------------");
                            System.out.println("------------------------------------------------------");
                            System.out.println("No\tNama\t\tPosisi\tNomor Rekening");
                            for (int j = 0; j < jumlahKaryawan; j++) {
                                if (dataKaryawan[j][0] != null) {
                                    System.out.println((j + 1) + "\t" + dataKaryawan[j][0] + "\t\t" + dataKaryawan[j][1] + "\t\t" + dataKaryawan[j][2]);
                                } else {
                                    break;
                                }
                            }
                        }

                        System.out.println("Apakah Anda ingin memasukkan Data Karyawan lagi? Ya/Tidak");
                        skip = scanner.nextLine();
                        if (!skip.equalsIgnoreCase("Ya")) {
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("========Input Absensi=======");
                    System.out.print("Masukkan Nama Karyawan: ");
                    String namaAbsen = scanner.nextLine();
                    boolean karyawanDitemukan = false;

                    for (int i = 0; i < jumlahKaryawan; i++) {
                        if (namaAbsen.equalsIgnoreCase(dataKaryawan[i][0])) {
                            karyawanDitemukan = true;
                            System.out.println("\nAbsensi Karyawan ke-" + (i + 1));
                            System.out.print("Apakah " + dataKaryawan[i][0] + " hadir? Y/T: ");
                            String absensi = scanner.nextLine();

                            if (absensi.equalsIgnoreCase("Y")) {
                                absensiKaryawan[i][30] = true; // Menggunakan indeks 30 untuk merepresentasikan hadir
                                                               // pada bulan ini
                                System.out.println("Absensi berhasil diinputkan untuk Karyawan ke-" + (i + 1));
                            } else if (absensi.equalsIgnoreCase("T")) {
                                absensiKaryawan[i][30] = false; // Menggunakan indeks 30 untuk merepresentasikan absen
                                                                // pada bulan ini
                                System.out.println("Absensi berhasil diinputkan untuk Karyawan ke-" + (i + 1));
                            } else {
                                System.out.println("Invalid input. Harap masukkan Y atau T.");
                                i--; // Ulangi loop untuk karyawan yang sama
                            }
                        }
                    }

                    if (!karyawanDitemukan) {
                        System.out.println("Karyawan dengan nama " + namaAbsen + " tidak ditemukan.");
                    }
                    break;
                case 3:
                    // Add your attendance feature logic here
                    System.out.print("Masukkan Nama Karyawan yang Akan Mengajukan Izin/Cuti: ");
                    String namaIzinCuti = scanner.nextLine();
                    boolean izinCutiDitemukan = false;
            
                    for(int i = 0; i < jumlahKaryawan; i++){
                        if(dataKaryawan[i][0] != null && namaIzinCuti.equalsIgnoreCase(dataKaryawan[i][0])){
                            izinCutiDitemukan = true;
                            System.out.print("Masukkan jumlah hari Izin/Cuti: ");
                            int jumlahHariIzinCuti = scanner.nextInt();
                            scanner.nextLine();
                            int potonganGaji = jumlahHariIzinCuti * 5000;
            
                            if(jumlahHariIzinCuti <= 0){
                                System.out.println("Jumlah Hari Izin/Cuti harus lebih dari 0");
                            }else{
                            dataKaryawan[i][2] = "Izin/Cuti: " + jumlahHariIzinCuti + " hari";
                            System.out.println("Izin/Cuti sebanyak " + jumlahHariIzinCuti + " hari telah diajukan");
                            System.out.println("Potongan gaji sebesar " + potonganGaji + " telah diberlakukan");
                        }
                        break;
                    }
                }
                if(!izinCutiDitemukan){
                    System.out.println("Karyawan dengan nama " + namaIzinCuti + " tidak Ditemukan");
                }
                break;
                case 4:
                System.out.println("Masukkan Nama Karyawan yang Akan di Inputkan: ");
                String namaKaryawan = scanner.nextLine();
                karyawanDitemukan = false;
                double bonus = 0.0;
        
                for(int i = 0; i < jumlahKaryawan; i++){
                    if(namaKaryawan.equalsIgnoreCase(dataKaryawan[i][0])){
                        karyawanDitemukan = true;
                
                        System.out.println("Masukkan Jumlah Jam Kerja: ");
                        int jamKerja = scanner.nextInt();
                        int gajiPokok = jamKerja * 5000;
        
                        double totalGaji = gajiPokok;
        
                        if(dataKaryawan[i][2] != null){
                            String[] izinCutiInfo = dataKaryawan[i][2].split(" ");
                            int jumlahHariIzinCuti = Integer.parseInt(izinCutiInfo[1].split(" ")[0]);
                            int potonganGaji = jumlahHariIzinCuti * 5000;
                            totalGaji -= potonganGaji;
                            System.out.println("Potongan Gaji Karena Izin.Cuti: " + potonganGaji);
                        }
                
                        System.out.println("Masukkan Jumlah Porsi Makanan yang Terjual: ");
                        int jumlahPorsi = scanner.nextInt();
                        if(jumlahPorsi > 30){
                            bonus += 0.10 * gajiPokok;
                        }else if (jumlahPorsi > 20){
                            bonus += 0.05 * gajiPokok;
                        }else if (jumlahPorsi > 15){
                            bonus += 0.05 * gajiPokok;
                        }

                        totalGaji += bonus;//Tambahkan bonus ke totalGaji
                        System.out.println("Total Gaji sebelum potongan: " + totalGaji);
                        System.out.println("Total gaji setelah potongan dan bonus: " + totalGaji);
                    }
                }
            
                if(!karyawanDitemukan){
                System.out.println("Karyawan dengan Nama " + namaKaryawan + " tidak ditemukan"); 
                }  
                break;
                case 5:
                    System.out.println("Kembali ke Menu Utama");
                    isAdminMenu = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // Fungsi untuk menampilkan menu user
    public static void userMenu(Scanner scanner) {
        boolean isUserMenuRunning = true;

        while (isUserMenuRunning) {
            System.out.println("Menu User:");
            System.out.println("1. Absensi");
            System.out.println("2. Izin/Cuti");
            System.out.println("3. Slip Gaji");
            System.out.println("4. Informasi Perusahaan");

            System.out.print("Pilih menu (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Anda memilih Pilihan 1");
                    break;
                case 2:
                    System.out.println("Anda memilih Izin/Cuti");
                case 3:
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