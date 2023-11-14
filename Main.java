import java.util.Scanner;
public class Main {
    private static Scanner input = new Scanner(System.in);
    private static String username[] = {"admin", "gacor"};
    private static String password[] = {"admin123", "gacormas"};

    // menus
    private static String menuItems[][] = {
        {"Burger", "10000"},
        {"Pizza", "15000"},
        {"Taco", "15000"},
        {"Cola", "5000"}
};

    public static void main(String[] args) {
        showMainMenu();
    }

    private static void showMainMenu() {
        int choice;
                
        do {
            System.out.println("========= MAIN MENU =========");
            System.out.println("1. Login");
            System.out.println("2. Register");
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
                for (int i = 0; i < menuItems.length; i++) {
                    System.out.printf("| %d. %s harga %s |\n", i + 1, menuItems[i][0], menuItems[i][1]);
                }
                System.out.println("| 0. Keluar     |");

                System.out.print("Masukkan nomor : ");
                int inputMenu = input.nextInt();

                // transaction
                for (int i = 0; i < menuItems.length; i++) {
                    if (inputMenu - 1 == i) {
                        handleOrder(menuItems[i][0], Integer.parseInt(menuItems[i][1]));
                        break;
                    }
                    if (inputMenu > menuItems.length) {
                        System.out.println("Harap masukkan nomor yang valid");
                        break;
                    }
                    if (inputMenu == 0) {
                        System.out.println("Terima kasih telah menggunakan layanan kami :D");
                        continueOrdering = false;
                        break;
                    }
                }
            }
        } else {
            System.out.println("Username atau password salah");
        }
    }

    private static void handleOrder(String itemName, int itemPrice) {
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

        // // System.out.println("Register berhasil!!! :D");
    }
}
    

