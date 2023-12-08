import java.util.Scanner;

public class punyavera {
    static String[][] menuItems = {
            {"Chicken katsu",  "20000"},
            {"Soto Lamongan",  "12000"},
            {"Udang Crispy",   "10000"},
            {"LemonTea",       "10000"},
            {"Milk chocolate", "15000"},
            {"Coca Cola",      "15000"}

    };

    
    public static void displayMainMenu() {
        
        System.out.println("     ");
        System.out.println("||======== MAIN MENU ========||");
        System.out.println("||1. Login                   ||");
        System.out.println("||2. Register                ||");
        System.out.println("||0. Keluar                  ||");
        System.out.println("||===========================||");
    }

    static void login(Scanner scanner) {
        System.out.println("1. Manager");
        System.out.println("2. Kasir");
        System.out.print("Pilih jabatan anda (1 atau 2): ");
        int roleChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("=== LOGIN ===");
        System.out.print("Masukkan Username: ");
        String inputUsername = scanner.next();
        System.out.print("Masukkan Password: ");
        String inputPassword = scanner.next();

        boolean checkUsername = false;
        boolean checkPassword = false;
        String[][] users = {
                {"manajer", "123"},
                {"kasir", "321"}
        };

        for (String[] user : users) {
            if (inputUsername.equals(user[0]) && inputPassword.equals(user[1])) {
                checkUsername = true;
                checkPassword = true;
                break;
            }
        }

        if (checkUsername && checkPassword) {
            System.out.println("__ LOGIN SUCCESS! __");
            if (roleChoice == 1) {
                System.out.println("=== MENU LAPORAN PENDAPATAN ===");
                // Implement your manager menu logic here
            } else if (roleChoice == 2) {
                System.out.println("     ");
                System.out.println("=> MENU TRANSAKSI SELANJUTNYA <=");
                orderMenu(scanner);
            }

        } else {
            System.out.println("_ LOGIN GAGAL _");
            
        }
    }

    public static double HitungDiskon(double TotalPembelian, double PersentaseDiskon){
        return(PersentaseDiskon/100)*TotalPembelian;
    }
    public static double HitungTotalPembayaran(double totalPembelian, double diskon){
        return totalPembelian - diskon;
    }

    static void orderMenu(Scanner scanner) {
        int menuChoice;
        double totalHarga = 0;
        double totalTransaksiKeseluruhan = 0;
        int jumlahPesanan = 0;

        // Array untuk menyimpan informasi setiap pesanan
        double[][] pesanan = new double[100][6];

        do {
            displayMenu();
            System.out.print("Masukkan nomor menu yang ingin Anda pesan : ");
            menuChoice = scanner.nextInt();

            if (menuChoice == 0) {
                break;
            } else if (menuChoice == -1) {
                searchMenu(scanner);
            } else if (menuChoice >= 1 && menuChoice <= menuItems.length) {
                int quantity;
                System.out.print("Masukkan jumlah pesanan: ");
                quantity = scanner.nextInt();
                int harga = Integer.parseInt(menuItems[menuChoice - 1][1]);
                totalHarga += (harga * quantity);

                
                totalPembayaran = HitungTotalPembayaran(TotalHarga, diskon);

                // Menyimpan informasi pesanan ke dalam array
                pesanan[jumlahPesanan][0] = menuChoice;
                pesanan[jumlahPesanan][1] = quantity;
                pesanan[jumlahPesanan][2] = harga;
                pesanan[jumlahPesanan][3] = TotalHarga;
                pesanan[jumlahPesanan][4] = diskon;
                pesanan[jumlahPesanan][5] = totalPembayaran;

                jumlahPesanan++;

                System.out.println("Total pemebelian: Rp" + totalHarga);
                System.out.println("Diskon: Rp" + diskon);

                // Menambahkan total pembayaran ke totalTransaksiKeseluruhan
                totalTransaksiKeseluruhan += totalPembayaran[i];
            }

        }while(true);

         // Menampilkan detail setiap pesanan
        for (int i = 0; i < jumlahPesanan; i++) {
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║         --Detail Pesanan--       ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.println("Pesanan ke-" + (i + 1));
            System.out.println("Menu: " + pesanan[i][0]);
            System.out.println("Jumlah: " + pesanan[i][1]);
            System.out.println("Harga: Rp" + pesanan[i][2]);
            System.out.println("Total Pembelian: Rp" + pesanan[i][3]);
            System.out.println("Diskon: Rp" + pesanan[i][4]);
            System.out.println("Total Pembayaran: Rp" + pesanan[i][5]);
            System.out.println("-----------------------------------");

            System.out.println("Total Seluruh Transaksi: Rp" + totalTransaksiKeseluruhan);
            System.out.println("Terima kasih!");
        }
    

    }

    static void displayMenu() {
        System.out.println("||========== MENU ==========||");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println( (i + 1) + ". " + menuItems[i][0] +"   - Harga: " + menuItems[i][1]);
            
        }
        System.out.println("0. Selesai Memesan");
        System.out.println("-1. Cari Menu");
    }

    static void searchMenu(Scanner scanner) {
        System.out.print("Masukkan nama menu yang ingin dicari: ");
        String keyword = scanner.next().toLowerCase();
        boolean found = false;

        System.out.println("       ");
        System.out.println("||==================================||");
        System.out.println("||        >>HASIL PENCARIAN<<       ||");
        for (String[] menuItem : menuItems) {
            if (menuItem[0].toLowerCase().contains(keyword)) {
                System.out.println("   Menu: " + menuItem[0] + ", Harga:"+menuItem[1]);
                System.out.println("    ");
                found = true;


            }
        }

        if (!found) {
            System.out.println("||       Menu tidak ditemukan.      ||");
            System.out.println("||==================================||");
            System.out.println("          ");
        }
    }

    static void register() {
        System.out.println("Iya Register");
    }

        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMainMenu();
            System.out.print("Masukkan Pilihan: ");
            choice = scanner.nextInt();

            if (choice == 1) {
                login(scanner);
            } else if (choice == 2) {
                register();
            } else if (choice == 0) {
                System.out.println("Terima kasih telah menggunakan jasa kami :D");
            } else {
                System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }

        }while (choice != 0);

        scanner.close();
    }
}
