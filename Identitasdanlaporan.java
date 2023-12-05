import java.util.Scanner;
public class Identitasdanlaporan {
    static void Login(){
        Scanner input= new Scanner(System.in);
        int idmasuk=12345;
        String passwordmasuk="admin";
        int kesempatan=0;

        while (kesempatan < 20) {
        System.out.println("=========SELAMAT DATANG========");
        System.out.println("=========            ==========");
        System.out.println("====        WELCOME        ====");
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
    System.out.println("3.LAPORAN PENDAPATAN");
    int pilihan= sc.nextInt();
    if (pilihan==1) {
        tentangMenu();
        
    }

    }
    

   
// DALAMANNYA  MENU 1
static void tentangMenu() {
    Scanner sc = new Scanner(System.in);
    System.out.println("=====DAFTAR MENU=====");
    System.out.println("Burger");
    System.out.println("TACO");
    System.out.println("ES KRIM");
    String pilihan2 = sc.nextLine();

    
    if (pilihan2.equalsIgnoreCase("Burger")) {
        System.out.println("Informasi mengenai Burger:\n" +
        "NAMA MENU : BURGER\n"+ 
        "JENIS MENU: MAKANAN BERAT\n"+
        "STATION: DAPUR 2B\n"); 
    } else if (pilihan2.equalsIgnoreCase("TACO")) {
        System.out.println("Informasi mengenai TACO: ..."); 
    } else if (pilihan2.equalsIgnoreCase("ES KRIM")) {
        System.out.println("Informasi mengenai ES KRIM: ..."); 
    } else {
        System.out.println("Pilihan tidak valid");
    }
}
static void cekmenu(){
    Scanner sc= new Scanner(System.in);
    System.out.println("====BERIKUT TAMPILAN MENU TERSEDIA SAAT INI====");
    System.out.println("====                BURGER                 ====");
    System.out.println("====                 TACO                  ====");
    System.out.println("====                ESKRIM                 ====");
    System.out.println("====                 ====                  ====");
    System.out.println("===============================================");
    String pilihan3=sc.nextLine();
   switch (pilihan3.toLowerCase()) {
    case "Burger":
    tampilkanResepBurger();
    break;
    case "TACO":
    tampilkanResepTaco();
    break;
    case "eskrim":
    tampilkanResepEskrim();
    break;
    default:
    System.out.println("Menu tidak valid.Silahkanpilih kembali ");
    cekmenu();
    break;
   }
    }

    public static void tampilkanResepBurger(){
        System.out.println("Resep Burger:");
        System.out.println("1. Siapkan roti burger, patty daging, keju, sayuran, dan saus.");
        System.out.println("2. Panggang patty daging hingga matang.");
        System.out.println("3. Susun roti, patty, keju, dan sayuran.");
        System.out.println("4. Tambahkan saus sesuai selera.");
    }

    public static void tampilkanResepTaco() {
        System.out.println("Resep Taco:");
        System.out.println("1. Siapkan kulit tortilla, daging cincang, sayuran, dan saus.");
        System.out.println("2. Tumis daging cincang hingga matang.");
        System.out.println("3. Letakkan daging di atas kulit tortilla dan tambahkan sayuran.");
        System.out.println("4. Gulung tortilla dan sajikan.");
    }

    public static void tampilkanResepEskrim() {
        System.out.println("Resep Eskrim:");
        System.out.println("1. Siapkan susu, gula, telur, dan perisa eskrim.");
        System.out.println("2. Campurkan susu, gula, dan telur dalam panci.");
        System.out.println("3. Panaskan aduk-aduk hingga meleleh.");
        System.out.println("4. Tambahkan perisa eskrim dan dinginkan dalam freezer.");
    }
    
static int  LaporanPendapatan(int pendapatan,int kerugian,int imbang){
    Scanner sc= new Scanner(System.in);
    System.out.println("BERIKUT ADALAH UNTUK PENDAPATAN PER HARI INI: ");
    System.out.println("Masukkan total pendapatan hari ini: ");
    int barangterjual= sc.nextInt();
    System.out.println("Masukkan modal jualan untuk hari ini: ");
    int modaljualan= sc.nextInt();
    pendapatan= barangterjual-modaljualan;
    return pendapatan;
    

  
}
public static void main(String[] args) {
    Login();
    Inputmenu();
    tentangMenu();
    LaporanPendapatan(0, 0, 0);
    System.out.println("Total pendapatan"+LaporanPendapatan(0, 0, 0));
}
}



