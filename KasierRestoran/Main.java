package KasierRestoran;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static Scanner input = new Scanner(System.in);
    private static String username[] = {"admin", "gacor"};
    private static String password[] = {"admin123", "gacormas"};
    private static String[][] riwayatPesanan = new String[100][3];
    private static int orderCount = 0;
    // menus
    private static String menuName[] = {"Burger", "Pizza", "Taco", "Cola"};
    private static int menuPrice[] = {10_000, 15_000, 15_000, 5_000};

    public static void main(String[] args) {
        showMainMenu();
    }

    private static void showMainMenu() {
        int choice;
                
        do {
            System.out.println("========= MAIN MENU =========");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3.Riwayat pesanan anda");
            System.out.println("0. Keluar");

            System.out.print("Masukan pilihan : ");
            choice = input.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Terima kasih sudah menggunakan jasa kami :D");
                    break;
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    Riwayat();
                     break;

                default:
                    System.out.println("Harap masukan nomer yg valid");
                    break;
            }
        } while (choice != 0);
    }

    private static void login() {
        Scanner inputLogin = new Scanner(System.in);

        System.out.println("========= LOGIN =========");

        System.out.print("Masukan username : ");
        String inputUsername = inputLogin.nextLine();

        System.out.print("Masukan password : ");
        String inputPassword = inputLogin.nextLine();

        boolean foundUsername = false;
        boolean foundPassword = false;

        // authentication
        for (String item : username) {
            if (item.equals(inputUsername)){
                foundUsername = true;
                break;
            }
        }
        for (String item : password) {
              if (item.equals(inputPassword)){
                foundPassword = true;
                break;
            }
        }

        if (foundUsername && foundPassword ){
            System.out.println("Login berhasil");
            boolean continueOrdering = true;

            while (continueOrdering) {
                System.out.println("========= MENU ==========");
                
                // loop array menuName and menuPrice
                for (int i = 0 ; i < menuName.length; i++) {
                    System.out.printf("| %s. %s harga %d |\n",i + 1, menuName[i], menuPrice[i]);  
                }
                System.out.println("| 0. Keluar     |");

                System.out.print("Masukan nomor : ");
                int menuInput = input.nextInt();

                // transaction
                for (int i = 0 ; i < menuName.length; i++) {
                    if (menuInput - 1 == i) {
                        handleOrder(menuName[i], menuPrice[i]);
                        break;
                    }
                    if (menuInput > menuName.length) {
                        System.out.println("Harap memasukan nomor yg valid");
                        break;
                    }
                    if (menuInput == 0 ) {
                        System.out.println("Terima kasih sudah menggunakan jasa kami :D");
                        continueOrdering = false;
                        break;
                    }
                }
            }
        } else {
            System.out.println("Username atau password salah");
        }
    }

    public static void handleOrder(String itemName, int itemPrice) {
        Scanner inputMenu = new Scanner(System.in);
        Scanner inputDiskon = new Scanner(System.in);

        System.out.println("Anda memesan : " + itemName);

        // add jumlah pesanan
        System.out.println("Jumlah Pesanan : ");
        int jumlahPesanan = inputMenu.nextInt();
        int totalPembayaran = jumlahPesanan * itemPrice;

        // jika ada diskon
        System.out.println("Apakah ada diskon? (Y/T) : ");
        String isDiscount = inputDiskon.nextLine();

        if (isDiscount.toLowerCase().equals("y")) {
            System.out.print("Masukan diskon : ");
            double diskon = inputMenu.nextDouble();
            double totalDiskon = totalPembayaran * diskon / 100;
            double hargaAkhir = totalPembayaran - totalDiskon;
            System.out.printf("Anda memesan : %s\nJumlah : %d\nHarga : %d\nTotal pembayaran : %s\n",
                    itemName, jumlahPesanan, itemPrice, hargaAkhir);
        } else {
            System.out.printf("Anda memesan : %s\nJumlah : %d\nHarga : %d\nTotal pembayaran : %d\n", itemName,
                    jumlahPesanan, itemPrice, totalPembayaran);
        }
    }

    private static void register() {
        // Scanner inputRegister = new Scanner(System.in);
        // System.out.println("========= REGISTER =========");

        // System.out.print("Masukan username : ");
        // username = inputRegister.nextLine();

        // System.out.print("Masukan password : ");
        // password = inputRegister.nextLine();

        // System.out.println("Register berhasil!!! :D");
    }   
        

public static void handleOrder(String itemName, int itemPrice, int jumlahPesanan, double totalPembayaran){
    Scanner inputMenu= new Scanner(System.in);

    System.out.println("Anda memesan :" + itemName);

    System.out.println("Jumlah pesanan : ");
    int jumlahpesanan= inputMenu.nextInt();

    riwayatPesanan[orderCount][0] = itemName;
    riwayatPesanan[orderCount][1] = String.valueOf(itemPrice);
    riwayatPesanan[orderCount][2] = String.valueOf(jumlahPesanan);

    orderCount++;
}
public static void Riwayat(){
    System.out.println("========= RIWAYAT PESANAN =========");
       
    for(int i= 0; i < orderCount; i++){
        String itemName = riwayatPesanan[i][0];
        int itemPrice = Integer.parseInt(riwayatPesanan[i][1]);
        

        System.out.printf("Pesanan: %s, Harga: %d, Jumlah: %d%n", itemName,itemPrice);
    }

    System.out.println("=====================");
}
   
            
        
        

        
    } 


    


