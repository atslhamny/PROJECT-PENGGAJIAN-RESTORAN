import java.util.Scanner;
    public class InputDataKaryawan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String skip;
        int jumlahKaryawan = 100;
        String dataKaryawan [][] = new String [jumlahKaryawan][10];

        while (true){
            for (int i = 0; i < jumlahKaryawan; i++){//Perulangan untuk menginput dataKaryawan
                System.out.println("\nData Karyawan ke-" + (i + 1));
                System.out.print("Nama: ");
                dataKaryawan[i][0] = sc.nextLine();
                System.out.print("Posisi: ");
                dataKaryawan[i][1] = sc.nextLine();
                System.out.print("Nomor Rekening: ");
                dataKaryawan[i][2] = sc.nextLine();//Menggunakan nextLine untuk membaca seluruh baris
               
                System.out.println("Apakah Anda ingin Melihat Data Karyawan yang telah di Inputkan? Ya/Tidak");
                skip = sc.nextLine();//Membersihkan newLine

                if(skip.equalsIgnoreCase("Ya")){
                    System.out.println("------------------------------------------------------");
                    System.out.println("---------------------Data Karyawan--------------------");
                    System.out.println("------------------------------------------------------");
                    System.out.println("No\tNama\t\tPosisi\tNomor Rekening");
                    for (int j = 0; j < jumlahKaryawan; j++){
                        if(dataKaryawan [j][0] != null){
                            System.out.println((j + 1) + "\t" + dataKaryawan[j][0] +"\t\t" + dataKaryawan[j][1]+ "\t\t" + dataKaryawan[j][2]);//Menambah output nomor rekening
                        }else{
                            break;
                        }
                    }
                }

                System.out.println("Apakah Anda ingin memasukkan Data Karyawan lagi? Ya/Tidak");
                skip = sc.nextLine();
                if(!skip.equalsIgnoreCase("Ya")){
                    break;
                }
            }
            sc.close();
        }
    }
}


 
       