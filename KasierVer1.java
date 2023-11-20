import java.util.Scanner;

public class KasierVer1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("======S E L A M A T  D A T A N G========\n");
        System.out.println(" ===SILAHKAN LOGIN TERLEBIH DAHULU==\n   ");
        System.out.println("1.LOGIN SEBAGAI MANAGER OPERASIONAL");
        System.out.println("2.LOGIN SEBAGAI MANAGER DAPUR");
        System.out.println("3.LOGIN SEBAGAI KASIR");

        System.out.println("Masukkan pilihan anda : ");
        int pilihan = scan.nextInt();

        if (pilihan == 1) {
            System.out.println("ANDA LOGIN SEBAGAI MANAGER OPERASIONAL");

            // Batasan percobaan login
            int bataspercobaan = 5;
            int percobaan = 0;
            
            while (percobaan < bataspercobaan) {
                System.out.println("SILAHKAN MASUKKAN USERNAME DAN PASSWORD ANDA");

                // Input untuk username
                System.out.print("USERNAME: ");
                String managerUsername = scan.next();

                // Input untuk password
                System.out.print("PASSWORD: ");
                String managerPassword = scan.next();
                


                // Cek apakah username dan password sesuai dengan yang diharapkan
                if (managerUsername.equals("admin") && managerPassword.equals("admin123")) {
                    System.out.println("Login berhasil!");
                System.out.println("SELAMAT DATANG KEMBALI");
                System.out.println("1.CEK LAPORAN TERKAIT RESTORAN");
                System.out.println("2.CEK KONDISI DAPUR");
                System.out.println("3.CEK LAPORAN LABA RUGI");

                
                
                int bataspilihan = 3;
                int pilihan1 = 0;
                
                while (pilihan1 < bataspilihan) {
                    System.out.print("MASUKKAN PILIHAN: ");
                    int pilihanmu= scan.nextInt();

                    // Cek pilihan
                    if (pilihanmu==1) {
                        System.out.println("BERIKUT ADALAH LAPORAN RESTORAN PER-");
                        break;
                        
                    }
                    else{
                        if (pilihanmu==2) {
                            System.out.println("BERIKUT ADALAH LAPORAN TERKAIT DAPUR");
                            break;
                            
                        }
                        else{
                            if (pilihanmu==3) {
                                System.out.println("BERIKUT ADALAH LAPORAN LABA RUGI");
                                break;
                            }
                        }
                    }

                

                    
                    
                }
            

                // Keluar dari loop jika login berhasil
                } else {
                    System.out.println("Username atau password salah. Coba lagi.");
                    percobaan++;
                }
            }

            if (percobaan == bataspercobaan) {
                System.out.println("Anda sudah mencoba login sebanyak 5 kali. Keluar dari program.");
            }
        }
    }
}
