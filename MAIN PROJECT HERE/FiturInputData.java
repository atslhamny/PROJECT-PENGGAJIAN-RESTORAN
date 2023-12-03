import java.util.Scanner;

public class FiturInputData {
    public static void main(String[] args) {
        String namaKaryawan, jabatan;
        String cetak;
        int no.rek;
        //Menyimpan input dari user melalui scanner
        Scanner input = new Scanner(System.in);
    
        //Membaca input data karyawan
        System.out.println("Masukkan Nama Karyawan: ");
        namaKaryawan = input.nextLine();
        System.out.println("Masukkan Jabatan: ");
        jabatan = input.nextLine();
        System.out.println("No. Rekening: ");
        no.rek = input.nextInt();

        //Menampilkan pilihan untuk mencetak data karyawan
        System.out.println("Apakah anda ingin mencetak data karyawan? Ya/Tidak");
        cetak = input.nextLine();

        //Menampilkan data karyawan
        if (cetak.equalsIgnoreCase("Ya")) {
            System.out.println("=================================");
            System.out.println("--------| Data Karyawan |--------");
            System.out.println("=================================");
            System.out.println("Nama Karyawan: " + namaKaryawan);
            System.out.println("Jabatan: " + jabatan);
            System.out.println("No. Rekening: " + no.rek);
        }else if (cetak.equalsIgnoreCase("Tidak")) {
        
        }
    }
}