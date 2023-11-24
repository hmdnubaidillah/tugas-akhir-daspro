import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static String[][] loginData = {
            { "admin", "admin123" },
            { "gacor", "gacormas" }
    };
    // menus
    private static String menuItems[][] = {
            { "Burger", "10000" },
            { "Pizza", "15000" },
            { "Taco", "15000" },
            { "Cola", "5000" }
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
            System.out.println("3. Table Register");
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
                    pemesananmeja();
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
        for (String[] loginInfo : loginData) {
            if (loginInfo[0].equals(inputUsername) && loginInfo[1].equals(inputPassword)) {
                foundUsername = true;
                foundPassword = true;
                break;
            }
        }

        if (foundUsername && foundPassword) {
            System.out.println("Login berhasil");
            boolean continueOrdering = true;

            while (continueOrdering) {
                System.out.println("=========MENU==========");
                // loop array menuName and menuPrice
                for (int i = 0; i < menuItems.length; i++) {
                    System.out.printf("| %d. %s harga %s |\n", i + 1, menuItems[i][0], menuItems[i][1]);
                }
                System.out.println("0. Selesai");

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
        }
    }

    private static void handleOrder(String itemName, int itemPrice) {
        Scanner inputMenu = new Scanner(System.in);
        Scanner inputDiskon = new Scanner(System.in);

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

    private static void pemesananmeja() {
        // jumlah meja pada restoran
        Scanner sc = new Scanner(System.in);
        int jumlahMeja = 20;

        int[] statusMeja = new int[jumlahMeja];

        // Inisialisasi status awal semua meja (semua kosong)
        for (int i = 0; i < jumlahMeja; i++) {
            statusMeja[i] = 0;
        }

        boolean StatusMeja = true;
        while (true) {

            // Untuk memasukkan nomor meja
            System.out.print("\nMasukkan nomor meja: ");
            int nomorMeja = sc.nextInt();

            // Untuk keluar program apabila memasukkan angka 0
            if (nomorMeja == 0) {
                break;
            }
            // Untuk memeriksa kevalidan meja
            if (nomorMeja < 1 || nomorMeja > jumlahMeja) {
                System.out.println("Nomor meja tidak valid, mohon masukkan nomor meja yang telah disediakan");
                continue;
            }
            // Untuk memeriksa meja terisi atau belum
            if (statusMeja[nomorMeja - 1] == 1) {
                System.out.println("Mohon maaf meja telah terisi, mohon memilih meja yang masih kosong");

                // Untuk memesan meja
            } else {
                statusMeja[nomorMeja - 1] = 1;
                System.out.println("Meja" + nomorMeja + "berhasil dipesan");
            }
            // tampilkan daftar meja beserta statusnya
            System.out.println("\nDaftar Meja: ");
            for (int i = 0; i < jumlahMeja; i++) {
                System.out.println("Meja " + (i + 1) + ": " + (statusMeja[i] == 1 ? "Terisi" : "Kosong"));
            }
        }
    }
}