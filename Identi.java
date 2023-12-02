import java.util.Scanner;

public class Identi{

    static void Login(){
        Scanner input= new Scanner(System.in);
        int idmasuk=12345;
        String passwordmasuk="admin";
        int kesempatan=0;

        while (kesempatan < 5) {
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
    if (kesempatan >=5) {
        System.out.println("ANDA TELAH MENCOBA SELAMA 5 KALI,SISTEM KELUAR");
        
    }
  }

  static void Identifikasi(){
    Scanner input= new Scanner(System.in);

    System.out.println("===========ANDA MEMASUKKI IDENTIFIKASI STOK============= ");
    System.out.println("=========================================================");
    System.out.println("========BERIKUT IDENTIFIKASI YANG DAPAT DILIHAT==========");
    System.out.println("1.CEK STOK");
    System.out.println("2.TAMBAHKAN STOK");
    System.out.println("3.KURANGI STOK");
    System.out.println("4.PERBARUI STOK");
    System.out.println("5.TELUSURI HISTORI STOK");
    System.out.println("6.KELUAR..");
    System.out.println("MASUKKAN PILIHAN: ");
    int pilihaniden= input.nextInt();

      
    }

    static void cekstok(String namabarang,int jumlahbarang){
      Scanner input= new Scanner(System.in);

      System.out.println("==== STOK BARANG ==== ");
      System.out.println("1.BIG MAC");
      System.out.println("2.KEBAB");
      System.out.println("3.NASI GORENG");
      System.out.println("MASUKKAN PILIHAN ANDA: ");
      String stokbarang= input.nextLine();

      if (stokbarang=="BIGMAC") {
        System.out.println("BERIKUT INFORMASI TERKAIT BIG MAC");
        System.out.println(" NAMA MAKANAN: BIG MAC");
        System.out.println(" BAHAN PENDUKUNG:  ");
        System.out.println("");
        
      }
    }

    }
  
  public static void main(String[] args) {
    Login();
    Identifikasi();
  }

}