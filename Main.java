import java.util.Scanner;

public class Main {
    private static String[][] loginDataKasir = new String[4][2];
    private static String[][] loginDataManager = new String[4][2];

    static String menuItems[][] = new String[10][4];
    static String keranjang[][] = new String[menuItems.length][4];

    static String getUsername = "";

    public static void main(String[] args) {
        setInitialLoginData();
        setInitalMenus();
        tampilkanMainMenu();
    }

    // function memasukan data login pas pertama kali program berjalan
    static void setInitialLoginData() {
        loginDataKasir[0][0] = "kasir"; // username
        loginDataKasir[0][1] = "kasir123123"; // password

        loginDataManager[0][0] = "manager";
        loginDataManager[0][1] = "manager123123";
    }

    // function memasukan data menu pas pertama kali program berjalan
    static void setInitalMenus() {
        menuItems[0][0] = "1"; // id
        menuItems[0][1] = "Chicken katsu"; // name
        menuItems[0][2] = "20000"; // price
        menuItems[0][3] = "5"; // stocks

        menuItems[1][0] = "2"; // id
        menuItems[1][1] = "Soto Lamongan"; // name
        menuItems[1][2] = "12000"; // price
        menuItems[1][3] = "5"; // stocks

        menuItems[2][0] = "3"; // id
        menuItems[2][1] = "Udang Crispy"; // name
        menuItems[2][2] = "10000"; // price
        menuItems[2][3] = "5"; // stocks

        menuItems[3][0] = "4"; // id
        menuItems[3][1] = "Lemon Tea"; // name
        menuItems[3][2] = "10000"; // price
        menuItems[3][3] = "5"; // stocks

        menuItems[4][0] = "5"; // id
        menuItems[4][1] = "Milk chocolate"; // name
        menuItems[4][2] = "15000"; // price
        menuItems[4][3] = "5"; // stocks

        menuItems[5][0] = "6"; // id
        menuItems[5][1] = "Coca Cola"; // name
        menuItems[5][2] = "15000"; // price
        menuItems[5][3] = "5"; // stocks
    }

    private static void tampilkanMainMenu() {
        Scanner input = new Scanner(System.in);
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
                    handleLogin();
                    break;
                case 2:
                    // register();
                    break;

                default:
                    System.out.println("Harap masukan nomer yg valid");
                    break;
            }
        } while (choice != 0);
    }

    static void handleTampilkanDashboard() {
        Scanner sc = new Scanner(System.in);

        System.out.println("==========DASHBOARD MANAJER==========");
        System.out.println();
        System.out.println(getUsername);
        System.out.println();
        System.out.println("1. Lihat laporan keuangan");
        System.out.println("0. Logout");

        boolean bar = true;

        while (bar) {
            System.out.print("Masukan nomor input : ");
            int input = sc.nextInt();

            if (input == 0) {
                bar = false;
                System.out.println("Sudah log out");
                break;
            }
        }
    }

    static void handleTampilkanMainMenuKasir() {
        Scanner sc = new Scanner(System.in);
        boolean foo = true;
        while (foo) {
            System.out.println();
            System.out.println(getUsername);
            System.out.println();
            System.out.println("=====MAIN MENU=====");
            System.out.println("1. Proses transaksi");
            System.out.println("2. Inventaris menu");
            System.out.println("0. Logout");

            System.out.print("Masukan nomor input : ");
            int input = sc.nextInt();

            if (input == 0) {
                foo = false;
                System.out.println();
                System.out.println("Sudah logout :(");
                System.out.println();
                break;
            }

            else if (input == 1) {
                boolean bar = true;

                while (bar) {
                    System.out.println();

                    // tampilkan menu makanan
                    handleTampilkanMenuMakanan();

                    System.out.println();
                    System.out.println("11. Lihat keranjang");
                    System.out.println("22. Selesaikan pesanan");
                    System.out.println("33. Cari menu");
                    System.out.println("0. Kembali ke main menu");

                    // logika pemesanan
                    int counter = 1;

                    System.out.println();
                    System.out.print("Masukan nomor input : ");
                    int menuInput = sc.nextInt();

                    if (menuInput == 0) {
                        break;
                    }

                    else if (menuInput == 11) {
                        // see keranjang
                        boolean statusKeranjang = handleTampilkanKeranjang();

                        if (statusKeranjang) {
                            handleTampilkanKeranjang();
                        } else {
                            continue;
                        }
                    }

                    // selesaikan pesananan dan hitung semua pesanan
                    else if (menuInput == 22) {
                        Scanner selesaiKanOrderSc = new Scanner(System.in);
                        System.out.print("Apa anda yakin? (y/n) : ");
                        String konfirmasi = selesaiKanOrderSc.nextLine();

                        int hargaTiapItem[] = new int[keranjang.length];

                        if (konfirmasi.equalsIgnoreCase("y")) {
                            int totalHarga = 0;
                            for (int i = 0; i < keranjang.length; i++) {
                                for (int j = 0; j < keranjang[i].length; j++) {
                                    if (keranjang[i][j] != null) {
                                        hargaTiapItem[i] = Integer.parseInt(keranjang[i][1])
                                                * Integer.parseInt(keranjang[i][2]);
                                        totalHarga += hargaTiapItem[i];
                                        break;
                                    }
                                }
                            }

                            // tampilkan struk belanja
                            boolean apakahOrderSelesai = false;
                            System.out.println();
                            System.out.println("==========STRUK BELANJA ANDA===========");
                            for (int i = 0; i < keranjang.length; i++) {
                                if (keranjang[i][0] != null) {
                                    System.out.printf("Item : %s, Jumlah : %s, Harga : Rp.%s ", keranjang[i][0],
                                            keranjang[i][2],
                                            keranjang[i][1]);
                                    System.out.println();
                                    apakahOrderSelesai = true;
                                }
                            }

                            if (apakahOrderSelesai) {
                                System.out.println("Total : Rp." + totalHarga);

                                for (int i = 0; i < keranjang.length; i++) {
                                    for (int j = 0; j < keranjang[i].length; j++) {
                                        keranjang[i][j] = null;
                                    }
                                }
                                continue;
                            }
                        } else {
                            System.out.println("Pesanan tidak terkonfirmasi");
                        }
                    }

                    // kondisi jika menu sudah ada di keranjang dan ingin meng update jumlahnya
                    // mendapatkan index dari menu yang dipilih

                    int indexKeranjang = -1;
                    for (int i = 0; i < keranjang.length; i++) {
                        if (keranjang[i][0] != null && keranjang[i][0].equals(menuItems[menuInput - 1][1])) {
                            indexKeranjang = i;
                            break;
                        }
                    }

                    // tambah tambahan jumlah menu ke keranjang
                    if (indexKeranjang != -1) {
                        handleTambahJumlahMenu(indexKeranjang);
                    } else {

                        // proses transaksi disini
                        System.out.print("Masukan jumlah pesanan : ");
                        int jumlahMenu = sc.nextInt();
                        System.out.println();

                        if (menuInput < menuItems.length) {
                            handleTransaksi(jumlahMenu, counter, menuInput);

                        } else {
                            System.out.println("Please enter a valid menu number");
                        }
                        counter++;
                    }
                }
            } else if (input == 2) {
                // manage menu
                Scanner scan = new Scanner(System.in);
                boolean bar = true;

                while (bar) {
                    System.out.println("==========INVENTARIS MENU==========");
                    System.out.println("1. Lihat menu");
                    System.out.println("0. Keluar");

                    System.out.print("Masukan nomor input : ");
                    int menuInput = scan.nextInt();

                    if (menuInput == 1) {
                        System.out.println();
                        System.out.println("==========MENU==========");
                        for (int i = 0; i < menuItems.length; i++) {
                            if (menuItems[i][0] != null) {
                                System.out.printf("%s. Menu : %s, Harga : %s, Stok : %s\n", menuItems[i][0],
                                        menuItems[i][1],
                                        menuItems[i][2], menuItems[i][3]);
                            }
                        }
                    } else if (menuInput == 0) {
                        bar = false;
                        break;
                    } else {
                        System.out.println("Tolong masukan nomor yang valid");
                    }
                }
            } else {
                System.out.println("Tolong masukan nomor yang valid");
            }
        }
    }

    static void handleTambahJumlahMenu(int indexKeranjang) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukan jumlah menu tambahan : ");

        int tambahanMenu = sc.nextInt();
        int jumlahYgAdaDiKeranjang = Integer.parseInt(keranjang[indexKeranjang][2]);
        int totalJumlahPesananTerbaru = tambahanMenu + jumlahYgAdaDiKeranjang;
        boolean stokSudahDiUpdate = false;

        // Update menu stok di keranjang
        if (keranjang[indexKeranjang][0] != null) {
            int menuIndex = -1;

            for (int i = 0; i < menuItems.length; i++) {
                if (menuItems[i][0] != null && keranjang[indexKeranjang][0].equals(menuItems[i][1])) {
                    menuIndex = i;
                    break;
                }
            }
            if (menuIndex != -1) {
                int jumlahStokMenu = Integer.parseInt(menuItems[menuIndex][3]);
                if (totalJumlahPesananTerbaru > jumlahStokMenu) {
                    System.out.println("Stok tidak cukup");
                } else {
                    int StokMenuYgSudahDiUpdate = jumlahStokMenu - jumlahYgAdaDiKeranjang;
                    menuItems[menuIndex][3] = Integer.toString(StokMenuYgSudahDiUpdate);
                    keranjang[indexKeranjang][2] = Integer.toString(totalJumlahPesananTerbaru);
                    stokSudahDiUpdate = true;
                    System.out.println("Tambahan jumlah menu pesanan sudah ditambahkan");
                }
            } else {
                System.out.println("Menu tidak ditemukan");
            }
        } else {
            System.out.println("keranjang kosong di indeks ini");
        }

        if (!stokSudahDiUpdate) {
            System.out.println("Stock not updated for the item in the keranjang. Check order or stock availability.");
        }
    }

    static void printkeranjang() {
        for (int i = 0; i < keranjang.length; i++) {
            if (keranjang[i][0] != null) {
                System.out.printf("Order %s\nItem : %s\nPrice : %s\nAmount : %s\n", (i + 1),
                        keranjang[i][0],
                        keranjang[i][1], keranjang[i][2]);
                System.out.println();

            } else {
                System.out.printf("%s. Empty...\n", (i + 1));
            }
        }
    }

    static boolean handleTampilkanKeranjang() {
        Scanner sc = new Scanner(System.in);
        boolean statusKeranjang = true;
        boolean apakahKeranjang = true;

        int indexKeranjang[] = new int[keranjang.length];
        String getNamaMenu = "";

        while (apakahKeranjang) {
            Scanner scan = new Scanner(System.in);
            System.out.println();
            System.out.println("==========KERANJANG ANDA===========");
            // print keranjang
            printkeranjang();
            System.out.println();
            System.out.println("1. Tambah jumlah menu");
            System.out.println("2. Kurangi jumlah menu");
            System.out.println("3. Hapus menu");
            System.out.println("0. Keluar");
            System.out.println();

            System.out.print("Masukan nomor menu : ");
            int input = sc.nextInt();

            if (input == 0) {
                apakahKeranjang = false;
                statusKeranjang = false;
                break;

            } else if (input == 1) {
                System.out.println();
                System.out.print("Pilih menu yang akan ditambahkan jumlahnya : ");
                int tambahJumlahMenuTambahan = scan.nextInt();

                for (int i = 0; i < keranjang.length; i++) {
                    indexKeranjang[i] = i;

                    if (keranjang[i] != null && indexKeranjang[i] == (tambahJumlahMenuTambahan - 1)) {
                        System.out.println(keranjang[i][0]);
                        break;
                    }
                }
            } else if (input == 2) {

            } else if (input == 3) {
                System.out.println();
                System.out.print("Pilih menu yang akan dihapus : ");
                int tambahJumlahMenuTambahan = scan.nextInt();

                for (int i = 0; i < keranjang.length; i++) {
                    indexKeranjang[i] = i;

                    if (keranjang[i] != null && indexKeranjang[i] == (tambahJumlahMenuTambahan - 1)) {
                        getNamaMenu = keranjang[i][0];
                        for (int j = 0; j < keranjang[i].length; j++) {
                            if (keranjang[i][j] != null) {
                                keranjang[i][j] = null;
                                System.out.println(getNamaMenu + " dihapus");
                                break;
                            } else {
                                System.out.println("Item sudah dihapus");
                            }
                        }
                    }
                }
            } else {
                System.out.println("Masukan input yang valid");
            }
        }
        return statusKeranjang;
    }

    static void handleTampilkanMenuMakanan() {
        System.out.println("====MENU====");
        for (int i = 0; i < menuItems.length; i++) {
            for (int j = 0; j < menuItems[i].length; j++) {
                if (menuItems[i][j] != null) {
                    System.out.printf("%s. Nama: %s, Harga : %s \n",
                            menuItems[i][0],
                            menuItems[i][1],
                            menuItems[i][2],
                            menuItems[i][3]);
                    break;
                }
            }
        }
    }

    static void handleLogin() {
        Scanner sc = new Scanner(System.in);
        boolean bar = true;
        boolean foo = true;

        boolean lanjutkanLoginManager = true;
        boolean lanjutkanLoginKasir = true;
        boolean apakahLoginSbgManajer = false;
        boolean apakahLoginSbgKasir = false;

        while (bar) {
            System.out.println();
            System.out.println("=====LOGIN=====");
            System.out.println("Login sebagai : ");
            System.out.println("1. Manajer");
            System.out.println("2. kasir");
            System.out.println("0. Keluar");

            // taking input
            while (foo) {
                System.out.print("Masukan jabatan : ");
                int inputJabatan = sc.nextInt();

                if (inputJabatan == 1) {
                    System.out.println();
                    System.out.println("Login sebagai manajer");
                    System.out.println();

                    while (lanjutkanLoginManager) {
                        Scanner managerSc = new Scanner(System.in);

                        System.out.print("Username : ");
                        String inputUsername = managerSc.nextLine();

                        System.out.print("Password : ");
                        String inputPassword = managerSc.nextLine();

                        for (int i = 0; i < loginDataManager.length; i++) {
                            if (loginDataManager[i][0] != null && inputUsername.equals(loginDataManager[i][0])) {
                                if (inputPassword.equals(loginDataManager[i][1])) {
                                    apakahLoginSbgManajer = true;

                                    getUsername = "Kasir : " + inputUsername;
                                    System.out.println();
                                    System.out.println("Login sukses");

                                    // untuk keluar dari looping while di function handleLogin
                                    lanjutkanLoginManager = false;
                                    foo = false;
                                    bar = false;
                                    break;

                                } else {
                                    System.out.println("Password salah");
                                    break;
                                }
                            } else {
                                System.out.println("Username tidak ketemu");
                                break;
                            }
                        }
                    }

                } else if (inputJabatan == 2) {
                    System.out.println();
                    System.out.println("Login sebagai kasir");
                    System.out.println();

                    while (lanjutkanLoginKasir) {
                        Scanner cashierSc = new Scanner(System.in);

                        System.out.print("Username : ");
                        String inputUsername = cashierSc.nextLine();

                        System.out.print("Password : ");
                        String inputPassword = cashierSc.nextLine();

                        for (int i = 0; i < loginDataKasir.length; i++) {
                            if (loginDataKasir[i][0] != null && inputUsername.equals(loginDataKasir[i][0])) {
                                if (inputPassword.equals(loginDataKasir[i][1])) {
                                    apakahLoginSbgKasir = true;

                                    getUsername = "Cashier : " + inputUsername;
                                    System.out.println();
                                    System.out.println("Login success");
                                    // untuk keluar dari loooping while di function handleLogin
                                    lanjutkanLoginKasir = false;
                                    foo = false;
                                    bar = false;
                                    break;

                                } else {
                                    System.out.println("Password salah");
                                    break;
                                }
                            } else {
                                System.out.println("Username tidak ditemukan");
                                break;
                            }
                        }
                    }

                } else if (inputJabatan == 0) {
                    System.out.println();
                    System.out.println("Keluar ke main menu");
                    System.out.println();
                    foo = false;
                    bar = false;

                } else {
                    System.out.println();
                    System.out.println("Tolong masukan nomor input yang valid");
                    System.out.println();
                    continue;
                }
            }
        }

        if (apakahLoginSbgKasir) {
            handleTampilkanMainMenuKasir();
        }

        if (apakahLoginSbgManajer) {
            handleTampilkanDashboard();
        }

    }

    // pemesanan
    static void handleTransaksi(int jumlahMenu, int counter, int menuInput) {
        boolean found = false;
        int indexKeranjang = -1;

        for (int i = 0; i < keranjang.length; i++) {
            if (keranjang[i][0] == null) {
                indexKeranjang = i;
                break;
            }
        }

        if (indexKeranjang == -1) {
            System.out.println("keranjang penuh");

        } else {

            for (int i = 0; i < menuItems.length; i++) {
                if (menuItems[i][0] != null) {
                    if (menuInput == Integer.parseInt(menuItems[i][0])) {

                        System.out.println("==========PESANAN ANDA==========");
                        System.out.printf("Pesanan ke-%s\nMenu : %s\nHarga : %s\nJumlah : %s\n", counter,
                                menuItems[i][1], menuItems[i][2], jumlahMenu);
                        System.out.println("=================================");
                        int jumlahMenuDalamStok = Integer.parseInt(menuItems[i][3]);

                        if (jumlahMenu > jumlahMenuDalamStok) {
                            found = true;
                            System.out.println("Stok tidak cukup");
                        } else {

                            // masukan menu ke keranjang
                            keranjang[indexKeranjang][0] = menuItems[i][1]; // nama menu
                            keranjang[indexKeranjang][1] = menuItems[i][2]; // harga
                            keranjang[indexKeranjang][2] = Integer.toString(jumlahMenu); // jumlah menu
                            keranjang[indexKeranjang][3] = Integer.toString(counter); // urutan menu

                            // update stok ketika pertama kali order
                            int stokYgSudahDiUpdate = Integer.parseInt(menuItems[i][3]) - jumlahMenu;
                            menuItems[i][3] = Integer.toString(stokYgSudahDiUpdate);

                            found = true;
                            System.out.println("Pesanan ditambahkan ke keranjang");
                        }
                    }
                }
            }
            if (!found) {
                System.out.println("Menu not found");
            }
        }
    }

    // static void orderMenu(Scanner scanner) {
    // int totalHarga = 0;
    // int menuChoice;

    // do {
    // // displayMenu();
    // System.out.print("Masukkan nomor menu yang ingin Anda pesan : ");
    // menuChoice = scanner.nextInt();

    // if (menuChoice == 0) {
    // break;
    // } else if (menuChoice == -1) {
    // // searchMenu(scanner);
    // } else if (menuChoice >= 1 && menuChoice <= menuItems.length) {
    // int quantity;
    // System.out.print("Masukkan jumlah pesanan: ");
    // quantity = scanner.nextInt();
    // int harga = Integer.parseInt(menuItems[menuChoice - 1][1]);
    // totalHarga += (harga * quantity);
    // } else {
    // System.out.println("Nomor menu tidak valid. Silakan pilih lagi.");
    // }

    // } while (true);

    // System.out.println("Total Harga: " + totalHarga);
    // }
}

// static void login() {
// Scanner scanner = new Scanner(System.in);

// System.out.println();
// System.out.println("Login sebagai? ");
// System.out.println("1. Manager");
// System.out.println("2. Kasir");

// System.out.print("Pilih jabatan anda (1 atau 2): ");
// int roleChoice = scanner.nextInt();
// scanner.nextLine();

// System.out.println("=== LOGIN ===");
// System.out.print("Masukkan Username: ");
// String inputUsername = scanner.next();
// System.out.print("Masukkan Password: ");
// String inputPassword = scanner.next();

// boolean checkUsername = false;
// boolean checkPassword = false;

// for (String[] user : loginDataKasir) {
// if (inputUsername.equals(user[0]) && inputPassword.equals(user[1])) {
// checkUsername = true;
// checkPassword = true;
// break;
// }
// }

// if (checkUsername && checkPassword) {
// System.out.println("____ LOGIN SUCCESS! ____");
// if (roleChoice == 1) {
// System.out.println("=== MENU LAPORAN PENDAPATAN ===");
// // Implement your manager menu logic here

// } else if (roleChoice == 2) {
// System.out.println(" ");
// System.out.println("=> MENU TRANSAKSI SELANJUTNYA <=");
// orderMenu(scanner);

// }

// } else {
// System.out.println("___ LOGIN GAGAL ___");

// }
// }

// private static void handleOrder(String itemName, int itemPrice) {
// Scanner inputMenu = new Scanner(System.in);
// Scanner inputDiskon = new Scanner(System.in);

// // add jumlah pesanan
// System.out.println("Jumlah Pesanan : ");
// int jumlahPesanan = inputMenu.nextInt();
// int totalPembayaran = jumlahPesanan * itemPrice;

// // jika ada diskon
// System.out.println("Apakah ada diskon? (Y/T) : ");
// String isDiscount = inputDiskon.nextLine();

// if (isDiscount.toLowerCase().equals("y")) {
// System.out.print("Masukan diskon : ");
// double diskon = inputMenu.nextDouble();
// double totalDiskon = totalPembayaran * diskon / 100;
// double hargaAkhir = totalPembayaran - totalDiskon;
// System.out.printf("Anda memesan : %s\nJumlah : %d\nHarga : %d\nTotal
// pembayaran : %s\n",
// itemName, jumlahPesanan, itemPrice, hargaAkhir);
// } else {
// System.out.printf("Anda memesan : %s\nJumlah : %d\nHarga : %d\nTotal
// pembayaran : %d\n", itemName,
// jumlahPesanan, itemPrice, totalPembayaran);
// }
// }
