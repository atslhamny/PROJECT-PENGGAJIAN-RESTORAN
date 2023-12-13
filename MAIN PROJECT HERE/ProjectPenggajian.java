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
            System.out.println("6. Keluar");

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
                    System.out.println("========Input Izin/Cuti=======");
                    System.out.print("Masukkan Nama Karyawan yang Akan Mengajukan Izin/Cuti: ");
                    String namaIzinCuti = scanner.nextLine();
                    boolean izinCutiDitemukan = false;

                    for (int i = 0; i < jumlahKaryawan; i++) {
                        if (dataKaryawan[i][0] != null && namaIzinCuti.equalsIgnoreCase(dataKaryawan[i][0])) {
                            izinCutiDitemukan = true;
                            System.out.print("Masukkan jumlah hari Izin/Cuti: ");
                            int jumlahHariIzinCuti = scanner.nextInt();
                            scanner.nextLine();
                            int potonganGaji = jumlahHariIzinCuti * 1000;

                            if (jumlahHariIzinCuti <= 0) {
                                System.out.println("Jumlah Hari Izin/Cuti harus lebih dari 0");
                            } else {
                                dataKaryawan[i][2] = "Izin/Cuti: " + jumlahHariIzinCuti + " hari";
                                System.out.println("Izin/Cuti sebanyak " + jumlahHariIzinCuti + " hari telah diajukan");
                                System.out.println("Potongan gaji sebesar " + potonganGaji + " telah diberlakukan");
                            }
                            break;
                        }
                    }
                    if (!izinCutiDitemukan) {
                        System.out.println("Karyawan dengan nama " + namaIzinCuti + " tidak Ditemukan");
                    }
                    break;
                case 4:
                    System.out.println("===============Total Penggajian=============");
                    System.out.print("Masukkan Nama Karyawan yang Akan di Inputkan: ");
                    String namaKaryawan = scanner.nextLine();
                    karyawanDitemukan = false;
                    double bonus = 0.0;
                    int gajiPokok = 5000;

                    System.out.print("Masukkan Jumlah Jam Kerja: ");
                    int jamKerja = scanner.nextInt();
                    int totalGaji = jamKerja * 5000;

                    System.out.println("Total Gaji: " + totalGaji);

                    System.out.print("Masukkan Jumlah Porsi Makanan yang Terjual: ");
                    int jumlahPorsi = scanner.nextInt();

                    if (jumlahPorsi > 30) {
                        bonus += 0.10 * totalGaji;
                    } else if (jumlahPorsi > 20) {
                        bonus += 0.07 * totalGaji;
                    } else if (jumlahPorsi > 15) {
                        bonus += 0.05 * totalGaji;
                    }

                    System.out.println("Bonus: " + bonus);

                    //if(namaKaryawan.equalsIgnoreCase(dataKaryawan[i][0])){
                    //karyawanDitemukan = true;
                    for (int i = 0; i < jumlahKaryawan; i++) {
                        if (dataKaryawan[i][0] != null && dataKaryawan[i][1] != null && dataKaryawan[i][2] != null) {
                            namaKaryawan = dataKaryawan[i][0];
                            karyawanDitemukan = true;

                            if (dataKaryawan[i][2] != null) {
                                String[] izinCutiInfo = dataKaryawan[i][2].split(" ");
                                int jumlahHariIzinCuti = Integer.parseInt(izinCutiInfo[1].split(" ")[0]);
                                int potonganGaji = jumlahHariIzinCuti * 5000;
                                totalGaji -= potonganGaji;
                                System.out.println("Potongan Gaji Karena Izin.Cuti: " + potonganGaji);
                            }

                            System.out.println("Masukkan Jumlah Porsi Makanan yang Terjual: ");
                            jumlahPorsi = scanner.nextInt();
                            if (jumlahPorsi > 30) {
                                bonus += 0.10 * gajiPokok;
                            } else if (jumlahPorsi > 20) {
                                bonus += 0.05 * gajiPokok;
                            } else if (jumlahPorsi > 15) {
                                bonus += 0.05 * gajiPokok;
                            }
                            System.out.println("Total Gaji sebelum potongan: " + totalGaji);
                            totalGaji += bonus; //Tambahkan bonus ke totalGaji
                            System.out.println("Total gaji setelah potongan dan bonus: " + totalGaji);
                        }
                    }

                    if (!karyawanDitemukan) {
                        System.out.println("Karyawan dengan Nama " + namaKaryawan + " tidak ditemukan");
                    }
                    break;
                case 5:
                    System.out.println("===== Rekapan Laporan =====");
                    System.out.println("------------------------------------------------");
                    System.out.println("No\tNama\t\tPosisi\t\tTotal Gaji");
                    System.out.println("------------------------------------------------");

                    for (int i = 0; i < jumlahKaryawan; i++) {
                        if (dataKaryawan[i][0] != null && dataKaryawan[i][1] != null) {
                            String nama = dataKaryawan[i][0];
                            String posisi = dataKaryawan[i][1];
                            // String absensi = dataKaryawan[i][6];
                            totalGaji = 0; // Mengubah totalGaji menjadi tipe data int

                            if (dataKaryawan[i][2] != null) {
                                String[] izinCutiInfo = dataKaryawan[i][2].split(": ");
                                int jumlahHariIzinCuti = Integer.parseInt(izinCutiInfo[1].split(" ")[0]);
                                int potonganGaji = jumlahHariIzinCuti * 5000;
                                totalGaji -= potonganGaji;
                            }

                            // Hitung total gaji dengan bonus dan potongan izin/cuti
                            if (dataKaryawan[i][3] != null && dataKaryawan[i][4] != null) {
                                jamKerja = Integer.parseInt(dataKaryawan[i][3]);
                                jumlahPorsi = Integer.parseInt(dataKaryawan[i][4]);

                                gajiPokok = 5000 * jamKerja;
                                bonus = 0;

                                // Hitung bonus jika jam kerja lebih dari 8 jam
                                if (jamKerja > 8) {
                                    bonus = (int)(0.05 * gajiPokok); // Bonus 5% jika jam kerja lebih dari 8 jam
                                }

                                // Hitung bonus penjualan makanan
                                if (jumlahPorsi > 30) {
                                    bonus += (int)(0.10 * gajiPokok); // Bonus 10% jika menjual lebih dari 30 porsi
                                } else if (jumlahPorsi > 20) {
                                    bonus += (int)(0.07 * gajiPokok); // Bonus 7% jika menjual lebih dari 20 porsi
                                } else if (jumlahPorsi > 15) {
                                    bonus += (int)(0.05 * gajiPokok); // Bonus 5% jika menjual lebih dari 15 porsi
                                }

                                totalGaji = gajiPokok + (int)bonus;
                            }

                            System.out.println((i + 1) + "\t" + nama + "\t\t" + posisi + "\t\t" + totalGaji);
                        }
                    }
                    System.out.println("------------------------------------------------");
                    break;
                case 6:
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
                System.out.println("=============ABSENSI============");
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

                            }
                            if (namaAbsen.equalsIgnoreCase("Ya")) {
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

                            }
                            if (namaabsen.equalsIgnoreCase("Ya")) {
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
                System.out.println("========Izin/Cuti========");
                System.out.print("Masukkan Nama Karyawan yang Akan Mengajukan Izin/Cuti: ");
                String namaIzinCuti = scanner.nextLine();
                scanner.nextLine();
                boolean izinCutiDitemukan = false;

                for (int i = 0; i < jumlahKaryawan;) {
                    if (dataKaryawan[i][0] != null && namaIzinCuti.equalsIgnoreCase(dataKaryawan[i][0])) {
                        izinCutiDitemukan = true;
                        System.out.print("Masukkan jumlah hari Izin/Cuti: ");
                        int jumlahHariIzinCuti = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Izin/Cuti sebanyak " + jumlahHariIzinCuti + " hari telah diajukan");
                        break;
                    }
                    if (!izinCutiDitemukan) {
                        System.out.println("Karyawan dengan nama " + namaIzinCuti + " tidak ditemukan.");
                    }
                    break;
                }
                case 4:
                    System.out.println("Anda memilih Slip Gaji");
                    System.out.print("Masukkan Tanggal Permintaan Slip Gaji (format: DD/MM/YYYY): ");
                    String tanggal = scanner.next(); // Menggunakan next() untuk membaca input tanggal

                    System.out.print("Masukkan Nama Karyawan yang meminta Slip Gaji: ");
                    String nama_karyawan = scanner.next();

                    System.out.print("Masukkan Jabatan: ");
                    String jabatan = scanner.next();

                    System.out.print("Masukkan Nomor Karyawan: ");
                    String noHp = scanner.next();

                    System.out.println("-------------------------------------------------");
                    System.out.println(" \t       SLIP GAJI KARYAWAN");
                    System.out.println("-------------------------------------------------");
                    // Lanjut mencetak informasi slip gaji seperti gaji, tunjangan, dll.

                    // Output:
                    System.out.println("\t\t\t    Tanggal : " + tanggal);
                    System.out.println("Nama Karyawan: " + nama_karyawan);
                    System.out.println("Jabatan: " + jabatan);
                    System.out.println("No. Telp: " + noHp);

                    int gajiPokok = 5000; // Gaji pokok per jam
                    int jamKerja = 8; // Karyawan bekerja 8 jam per hari
                    double totalGaji = gajiPokok * jamKerja;

                    double tunjangan = 1000; // Misal, tunjangan tetap per bulan
                    double bonusTarget = 2000; // Misal, bonus target per bulan
                    double lemburRate = 1.5; // Rate lembur per jam
                    double lembur = (jamKerja > 8) ? (jamKerja - 8) * lemburRate : 0; // Hanya lembur jika jam kerja > 8 jam

                    totalGaji += tunjangan + bonusTarget + lembur;

                    System.out.println("\t\t   PENGHASILAN");
                    System.out.println("Gaji Pokok\t\t\t\t" + gajiPokok * jamKerja);
                    System.out.println("Tunjangant\t\t\t\t" + tunjangan);
                    System.out.println("Bonus Target\t\t\t\t" + bonusTarget);
                    System.out.println("Lembur\t\t\t\t\t" + lembur);

                    int potonganGaji = 0;

                    for (int i = 0; i < jumlahKaryawan; i++) {
                        if (dataKaryawan[i][0] != null && dataKaryawan[i][1] != null && dataKaryawan[i][2] != null) {
                            nama_karyawan = dataKaryawan[i][0];
                            jabatan = dataKaryawan[i][1];

                            // Hitung potongan gaji berdasarkan izin/cuti
                            String[] izinCutiInfo = dataKaryawan[i][2].split(": ");
                            int jumlahHariIzinCuti = Integer.parseInt(izinCutiInfo[1].split(" ")[0]);
                            potonganGaji = jumlahHariIzinCuti * 5000;
                            totalGaji -= potonganGaji;
                            break; // Hanya perlu satu kali potongan izin/cuti, jadi keluar dari loop setelah menemukannya
                        }
                    }

                    System.out.println("\t\t    POTONGAN");
                    System.out.println("Izin/Cuti\t\t\t\t" + potonganGaji);

                    System.out.println("Total Gaji Setelah Potongan\t\t" + totalGaji);
                    break;

                case 5:
                    System.out.println("======== Informasi Perusahaan =======");
                    System.out.print("Masukkan Event Yang Akan Berlangsung: ");
                    String event = scanner.nextLine();
                    System.out.print("Masukkan Tanggal Event Berlangsung: ");
                    String Tanggal = scanner.nextLine();

                    System.out.println(event + "Berlangsung Pada" + Tanggal);
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