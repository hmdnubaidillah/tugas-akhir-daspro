import java.util.Scanner;
public class Main {
    private static Scanner input = new Scanner(System.in);
    private static String username = "123";
    private static String password = "123";

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
                    exitProgram();
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

    private static void exitProgram() {
        input.close();
        System.out.println("Terima kasih sudah menggunakan jasa kami :D");
    }

    private static void login() {
        Scanner inputLogin = new Scanner(System.in);

        System.out.println("========= LOGIN =========");

        System.out.print("Masukan username : ");
        String inputUsername = inputLogin.nextLine();

        System.out.print("Masukan password : ");
        String inputPassword = inputLogin.nextLine();

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login berhasil");

            boolean continueOrdering = true;

            while (continueOrdering) {
                // Transaction
                String burger = "Burger";
                String pizza = "Pizza";
                String taco = "Taco";
                String cocaCola = "Coca-Cola";

                int hargaBurger = 10_000;
                int hargaPizza = 15_000;
                int hargaTaco = 15_000;
                int hargaCola = 5_000;

                System.out.println("========= MENU ==========");
                System.out.printf("| 1. %s harga %d |\n", burger, hargaBurger);
                System.out.printf("| 2. %s harga %d |\n", pizza, hargaPizza);
                System.out.printf("| 3. %s harga %d |\n", taco, hargaTaco);
                System.out.printf("| 4. %s harga %d |\n", cocaCola, hargaCola);
                System.out.println("| 0. Keluar     |");

                System.out.print("Masukan nomor : ");
                int menuInput = input.nextInt();

                switch (menuInput) {
                    case 0:
                        continueOrdering = false;
                        break;
                    case 1:
                        handleOrder(burger, hargaBurger);
                        break;
                    case 2:
                        handleOrder(pizza, hargaPizza);
                        break;
                    case 3:
                        handleOrder(taco, hargaTaco);
                        break;
                    case 4:
                        handleOrder(cocaCola, hargaCola);
                        break;
                    default:
                        System.out.println("Harap masukkan nomor yang valid");
                        break;
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
        Scanner inputRegister = new Scanner(System.in);
        System.out.println("========= REGISTER =========");

        System.out.print("Masukan username : ");
        username = inputRegister.nextLine();

        System.out.print("Masukan password : ");
        password = inputRegister.nextLine();

        System.out.println("Register berhasil!!! :D");
    }
}

    

