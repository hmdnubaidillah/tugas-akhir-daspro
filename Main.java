import java.util.Scanner;

public class Main{

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
  public static void main(String[] args) {
    Login();
  }

}