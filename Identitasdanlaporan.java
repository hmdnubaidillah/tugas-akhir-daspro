import java.util.Scanner;
public class Identitasdanlaporan {
    static void Login(){
        Scanner input= new Scanner(System.in);
        int idmasuk=12345;
        String passwordmasuk="admin";
        int kesempatan=0;

        while (kesempatan < 20) {
        System.out.println("SELAMAT DATANG DI LAPORAN RESTO");
        System.out.println("===============================");
        System.out.println("====       WELCOME         ====");
        System.out.println("===============================\n");
        System.out.println("SILAHKAN LOGIN TERLEBIH DAHULU");
        System.out.println("MASUKKAN ID: ");
        int idpengguna=input.nextInt(); 
        input.nextLine();
        System.out.println("MASUKKAN PASSWORD: ");
        String passwordpengguna= input.nextLine();
        

         if (idpengguna==idmasuk&&passwordpengguna.equals(passwordmasuk)) {
            System.out.println("\nLOGIN BERHASIL !\n");
            return;
         }else{
            System.out.println("LOGIN GAGAL SILAHKAN MASUKKAN KEMBALI ID DAN PASSWORD ANDA"+(kesempatan+1));
            kesempatan++;
         }
    }
    if (kesempatan >=20) {
        System.out.println("ANDA TELAH MENCOBA,MOHON MAAF SISTEM KELUAR");
    }
   }
   static void Inputmenu(){
    Scanner sc= new Scanner(System.in);
    System.out.println("====SELAMAT DATANG====");
    System.out.println("1.TENTANG MENU");
    System.out.println("2.CEK MENU");
    System.out.println("3.TAMBAHKAN MENU");
    System.out.println("4.KURANGI MENU");
    int pilihan= sc.nextInt();
    

   }

static void tentangMenu() {
    Scanner sc = new Scanner(System.in);
    System.out.println("=====DAFTAR MENU=====");
    System.out.println("Burger");
    System.out.println("TACO");
    System.out.println("ES KRIM");
    String pilihan2 = sc.nextLine();

    // Menggunakan pernyataan if-else untuk menampilkan informasi sesuai dengan pilihan
    if (pilihan2.equalsIgnoreCase("Burger")) {
        System.out.println("Informasi mengenai Burger:" +
        "NAMA MENU : BURGER "+ 
        "JENIS MENU: MAKANAN BERAT"); // Tambahkan informasi mengenai burger di sini
    } else if (pilihan2.equalsIgnoreCase("TACO")) {
        System.out.println("Informasi mengenai TACO: ..."); // Tambahkan informasi mengenai TACO di sini
    } else if (pilihan2.equalsIgnoreCase("ES KRIM")) {
        System.out.println("Informasi mengenai ES KRIM: ..."); // Tambahkan informasi mengenai ES KRIM di sini
    } else {
        System.out.println("Pilihan tidak valid");
    }
}
}


