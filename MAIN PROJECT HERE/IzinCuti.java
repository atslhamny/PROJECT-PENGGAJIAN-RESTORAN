import java.util.Scanner;
    public class IzinCuti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int jumlahKaryawan = 100;
        String[][] dataKaryawan = new String[jumlahKaryawan][10];

        System.out.print("Masukkan Nama Karyawan yang Akan Mengajukan Izin/Cuti: ");
        String namaIzinCuti = sc.nextLine();
        boolean izinCutiDitemukan = false;

        for(int i = 0; i < jumlahKaryawan; i++){
            if(dataKaryawan[i][0] != null && namaIzinCuti.equalsIgnoreCase(dataKaryawan[i][0])){
                izinCutiDitemukan = true;
                System.out.println("Masukkan jumlah hari Izin/Cuti: ");
                int jumlahHariIzinCuti = sc.nextInt();
                sc.nextLine();
                int potonganGaji = jumlahHariIzinCuti * 5000;

                if(jumlahHariIzinCuti <= 0){
                    System.out.println("Jumlah Hari Iin/Cuti harus lebih dari 0");
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
    }
}
