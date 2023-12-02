import java.util.Scanner;

public class FiturInputData {
    public static void main(String[] args) {
        String namaKaryawan, jabatan;
        String cetak;
        //Menyimpan input dari user melalui scanner
        Scanner input = new Scanner(System.in);
    
        //Membaca input data karyawan
        System.out.println("Masukkan Nama Karyawan: ");
        namaKaryawan = input.nextLine();
        System.out.println("Masukkan Jabatan: ");
        jabatan = input.nextLine();

        //Menampilkan pilihan untuk mencetak data karyawan
        System.out.println("Apakah anda ingin mencetak data karyawan? Ya/Tidak");
        cetak = input.nextLine();

        //Menampilkan data karyawan
        if (cetak.equalsIgnoreCase("Ya")) {
            System.out.println("--------| Data Karyawan |--------");
            System.out.println("---------------------------------");
            System.out.println("Nama Karyawan: " + namaKaryawan);
            System.out.println("Jabatan: " + jabatan);
        }else if (cetak.equalsIgnoreCase("Tidak")) {
        
        }
    }
}