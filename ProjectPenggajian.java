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
                    System.out.println("========Input Izin/Cuti=======");
                    break;
                case 4:
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
            System.out.println("1. Input Data");
            System.out.println("2. Absensi");
            System.out.println("3. Izin/Cuti");
            System.out.println("4. Slip Gaji");
            System.out.println("5. Informasi Perusahaan");

            System.out.print("Pilih menu (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("================Input Data===============");
                    for (int i = 0; i < jumlahKaryawan; i++) {
                        System.out.println("\nData Karyawan ke-" + (i + 1));
                        System.out.print("Masukkan Nama: ");
                        scanner.nextLine();
                        dataKaryawan[i][0] = scanner.nextLine();
                        System.out.print("Masukkan Posisi: ");
                        dataKaryawan[i][1] = scanner.nextLine();
                    
                    System.out.println("Apakah anda ingin menambahkan data karyawan lagi? Ya/Tidak");
                    skip = scanner.nextLine();
                    if (!skip.equalsIgnoreCase("Ya")) {
                        break;
                    }
                }
                    break;
                case 2:
                    System.out.println("=============ABSENSI===========");
                    System.out.println("1. Absensi Masuk");
                    System.out.println("2. Absensi Pulang");

                    System.out.print("Pilih: ");
                    int pilih = scanner.nextInt();
                    scanner.nextLine();

                    switch (pilih) {
                        case 1:
                            System.out.println("========ABSENSI MASUK======");
                            System.out.print("Masukkan Nama: ");
                            String namaAbsen = scanner.nextLine();
                            boolean karyawanDitemukan = false;
                            int j = 0;

                            for (int i = 0; i < jumlahKaryawan; i++) {
                                if (namaAbsen.equalsIgnoreCase(dataKaryawan[i][0])) {
                                    karyawanDitemukan = true;
                                    System.out.println("Apakah anda ingin melakukan absen? Ya/Tidak: ");
                                    String absensi = scanner.nextLine();
                                
                                } if (namaAbsen.equalsIgnoreCase("Ya")) {
                                    absensiKaryawan[j][30] = true; // Menggunakan indeks 30 untuk merepresentasikan hadir
                                                               // pada bulan ini
                                    System.out.println("Absensi masuk berhasil dicatat." + (i + 1));
                                } else if (namaAbsen.equalsIgnoreCase("Tidak")) {
                                    absensiKaryawan[j][30] = false; // Menggunakan indeks 30 untuk merepresentasikan hadir
                                                               // pada bulan ini
                                }
                            }

                            if (!karyawanDitemukan) {
                                System.out.println("Karyawan dengan nama " + namaAbsen + " tidak ditemukan.");
                            }
                        break;
                        case 2:
                            System.out.println("========ABSENSI PULANG======");
                            System.out.print("Masukkan Nama: ");
                            String namaabsen = scanner.nextLine();
                            boolean karyawanditemukan = false;
                            int J = 0;

                            for (int i = 0; i < jumlahKaryawan; i++) {
                                if (namaabsen.equalsIgnoreCase(dataKaryawan[i][0])) {
                                    karyawanDitemukan = true;
                                    System.out.println("Apakah anda ingin melakukan absen? Ya/Tidak: ");
                                    String absensi = scanner.nextLine();
                                
                                } if (namaabsen.equalsIgnoreCase("Ya")) {
                                    absensiKaryawan[J][30] = true; // Menggunakan indeks 30 untuk merepresentasikan hadir
                                                               // pada bulan ini
                                    System.out.println("Absensi pulang berhasil dicatat." + (i + 1));
                                } else if (namaabsen.equalsIgnoreCase("Tidak")) {
                                    absensiKaryawan[J][30] = false; // Menggunakan indeks 30 untuk merepresentasikan hadir
                                                               // pada bulan ini
                                }
                            }
                            
                            if (!karyawanditemukan) {
                                System.out.println("Karyawan dengan nama " + namaabsen + " tidak ditemukan.");
                            }
                    }
                    break;
                case 3:
                    System.out.println("Anda memilih izin/cuti");
                    break;
                case 4:
                    System.out.println("Slip gaji");
                    break;
                case 5:
                    System.out.println("Informasi perusahaan");
                    break;
                case 6:
                    System.out.println("Kembali ke Menu Utama");
                    isUserMenuRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-4.");
            }
        }
    }
}