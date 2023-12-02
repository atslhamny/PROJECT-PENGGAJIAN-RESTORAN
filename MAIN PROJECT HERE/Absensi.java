import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
    public class Absensi {
    
    private List <String> namaKaryawan = new ArrayList<>();
    private List <Boolean> kehadiran = new ArrayList<>();

    public void absensi(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Masukkan Nama Karyawan (atau ketik 'selesai' untuk berhenti): ");
            String nama = sc.nextLine();

            if(nama.equalsIgnoreCase("selesai")){
                break;
            }
            namaKaryawan.add(nama);
            System.out.println("Apakah " + nama + " hadir? (Ya/Tidak): ");
            String jawaban = sc.nextLine();
            kehadiran.add(jawaban.equalsIgnoreCase("Ya"));
        }
    }
    public void tampilanKehadiran(){
        System.out.println("\n======Informasi Kehadiran======");
        System.out.println("No\tNama\t\tKehadiran");

        for(int i = 0; i < namaKaryawan.size(); i++){
            String nama = namaKaryawan.get(i);
            boolean hadir = kehadiran.get(i);

            System.out.println((i + 1) + "\t" + nama + "\t\t" + (hadir? "Hadir" : "Tidak Hadir"));
        }
    }

    public static void main(String[] args) {
        Absensi absensi = new Absensi();
        
        absensi.absensi();
        absensi.tampilanKehadiran();
    }
}
     