
    import java.util.Scanner;

public class Main {
    private static String[][] loginDataKasir = new String[4][2];
    private static String[][] loginDataManager = new String[4][2];

    static String menuItems[][] = new String[10][4];
    static String keranjang[][] = new String[menuItems.length][5];

    static String getUsername = "";

// Main brain code
    public static void main(String[] args) {
        setInitialLoginData();
        setInitalMenus();
        tampilkanMainMenu();
        masukkanPendapatan();
        laporanPendapatan();

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

    // static void handleTampilkanDashboard() {
    //     Scanner sc = new Scanner(System.in);

    //     System.out.println("==========DASHBOARD MANAJER==========");
    //     System.out.println();
    //     System.out.println(getUsername);
    //     System.out.println();
    //     System.out.println("1. Lihat laporan keuangan");
    //     System.out.println("0. Logout");

    //     boolean bar = true;

    //     while (bar) {
    //         System.out.print("Masukan nomor input : ");
    //         int input = sc.nextInt();

    //         if (input == 0) {
    //             bar = false;
    //             System.out.println("Sudah log out");
    //             break;
    //         }
    //     }
    // }

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

                        double hargaTiapItem[] = new double[keranjang.length];

                        if (konfirmasi.equalsIgnoreCase("y")) {
                            double totalHarga = 0;

                            for (int i = 0; i < keranjang.length; i++) {
                                for (int j = 0; j < keranjang[i].length; j++) {
                                    if (keranjang[i][j] != null) {
                                        hargaTiapItem[i] = Integer.parseInt(keranjang[i][2])
                                                * Double.parseDouble(keranjang[i][1]);
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
                    } else if (menuInput == 33) {
                        searchMenu();
                    } else {
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
                            Scanner scan = new Scanner(System.in);

                            // proses transaksi disini
                            System.out.print("Masukan jumlah pesanan : ");
                            int jumlahMenu = sc.nextInt();
                            System.out.println();

                            System.out.print("Apakah ada diskon? (y/n) : ");
                            String apakahDiskon = scan.nextLine();

                            boolean isDiskon = false;

                            if (menuInput < menuItems.length) {
                                // check jika ada diskon
                                if (apakahDiskon.equalsIgnoreCase("y")) {
                                    isDiskon = true;

                                    handleTransaksi(jumlahMenu, counter, menuInput, isDiskon);
                                } else {

                                    handleTransaksi(jumlahMenu, counter, menuInput, isDiskon);
                                }
                            } else {
                                System.out.println("Please enter a valid menu number");
                            }
                            counter++;
                        }
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
                System.out.printf("Pesanan %s\nItem : %s\nHarga : %s\nJumlah : %s\n", (i + 1),
                        keranjang[i][0],
                        keranjang[i][1], keranjang[i][2]);
                System.out.println();

            } else {
                System.out.printf("%s. Kosong...\n", (i + 1));
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
            System.out.println("1. Hapus menu");
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
            } else if (input == 2) {

            } else if (input == 3) {

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
            // handleTampilkanDashboard();
            tampilanManajer();
            setInitalMenus();
        }

    }

    // pemesanan
    static void handleTransaksi(int jumlahMenu, int counter, int menuInput, boolean isDiskon) {
        Scanner sc = new Scanner(System.in);
        boolean found = false;
        int indexKeranjang = -1;

        for (int i = 0; i < keranjang.length; i++) {
            if (keranjang[i][0] == null) {
                indexKeranjang = i;
                break;
            }
        }
        double persentasiDiskon = 0;

        if (isDiskon) {
            System.out.print("Masukan persentase diskon : ");
            persentasiDiskon = sc.nextDouble();
        }

        if (indexKeranjang == -1) {
            System.out.println("keranjang penuh");

        } else {

            for (int i = 0; i < menuItems.length; i++) {
                if (menuItems[i][0] != null) {
                    if (menuInput == Integer.parseInt(menuItems[i][0])) {

                        System.out.println("==========PESANAN ANDA==========");
                        System.out.printf("Pesanan ke-%s\nNama : %s\nHarga : %s\nJumlah : %s\nDiskon : %s Persen\n",
                                counter,
                                menuItems[i][1], menuItems[i][2], jumlahMenu, persentasiDiskon);
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

                            // hitung diskon
                            if (persentasiDiskon > 0 && persentasiDiskon <= 100) {

                                int hargaDiKeranjang = Integer.parseInt(keranjang[indexKeranjang][1]);
                                double hargaSetelahDiskon = hargaDiKeranjang * (persentasiDiskon / 100);

                                // merubah harga item dikeranjang dengan harga baru setelah didiskon
                                keranjang[indexKeranjang][1] = Double.toString(hargaDiKeranjang - hargaSetelahDiskon);
                                keranjang[indexKeranjang][4] = Double.toString(persentasiDiskon);
                            }

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

    static void searchMenu() {
        Scanner scanner = new Scanner(System.in);

        boolean foo = true;

        while (foo) {
            System.out.print("Masukkan nama menu yang ingin dicari (0 untuk keluar): ");
            String keyword = scanner.next().toLowerCase();
            boolean found = false;

            if (keyword.equalsIgnoreCase("0")) {
                foo = false;
                break;
            } else {
                System.out.println("||========>>HASIL PENCARIAN<<========||");
                System.out.println();
                for (int i = 0; i < menuItems.length; i++) {
                    if (menuItems[i][0] != null && menuItems[i][1].toLowerCase().contains(keyword)) {
                        System.out.println("Menu: " + menuItems[i][1] + ", Harga:" + menuItems[0][2]);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println();
                    System.out.println("Menu tidak ditemukan");
                }
            }
        }
    }
    static Scanner scanner = new Scanner(System.in);
    static int jumlahKasir = 3; // Misalkan jumlah kasir adalah 3
    static int jumlahBulan = 3; // Misalkan jumlah bulan adalah 3
    static String[] namaKasir = new String[jumlahKasir];
    static double[][] totalPendapatan = new double[jumlahKasir][jumlahBulan];
    static double[] pendapatanKasir = new double[jumlahKasir];

    static int tampilanManajer() {
        

                   System.out.println("============     SELAMAT DATANG      ============");
                   System.out.println("|       1. TENTANG PENDAPATAN KANTIN SEHAT      |");
                   System.out.println("|        2. KEMBALI                            |");
                   System.out.println("|                                              |");
                   System.out.println("------------------------------------------------");
                   
                   int choose = scanner.nextInt();

        switch (choose) {
                case 1:
                masukkanPendapatan();
                laporanPendapatan();
                // Menambahkan pilihan untuk kembali ke menu awal
                break;
                default:
               System.out.println("Pilihan anda Tidak valid , pilih 1-2");
                break;
        }
        return choose;
    }

    static void laporanPendapatan() {
        System.out.println("\n============ BERIKUT TAMPILAN PENDAPATAN DARI KANTIN SEHAT ===============");
        for (int i = 0; i < jumlahKasir; i++) {
            System.out.print("Kasir ke-" + (i + 1) + " (" + namaKasir[i] + "): ");
            System.out.println(pendapatanKasir[i]);
        }
    }

   static void masukkanPendapatan() {
            for (int i = 0; i < jumlahKasir; i++) {
                System.out.println("======== Masukkan nama penanggung jawab kasir ke-" + (i + 1) + " =========");
                namaKasir[i] = scanner.next();
    
                for (int bulan = 0; bulan < jumlahBulan; bulan++) {
                    System.out.println("====== Input Pendapatan " + namaKasir[i] + " untuk Bulan ke-" + (bulan + 1) + " =======");
                    double totalPendapatanBulan = 0.0;
    
                    for (int minggu = 0; minggu < 4; minggu++) {
                        System.out.print("Pendapatan Kasir " + namaKasir[i] + " minggu ke-" + (minggu + 1) + ": ");
                        double pendapatanMingguan = scanner.nextDouble();
                        totalPendapatanBulan += pendapatanMingguan;
                    }
    
                    totalPendapatan[i][bulan] = totalPendapatanBulan;
                    pendapatanKasir[i] += totalPendapatanBulan;
                }
            }
        }
}
    // static void displaymenu(){
    //     Scanner scanner = new Scanner(System.in);
    //     int choice=0;

    //     while (choice !=3) {
    //         System.out.println("\n========== MAIN Stok ==========");
    //         System.out.println("1. Tampilkan Stok");
    //         System.out.println("2. Ubah Stok menu");
    //         System.out.println("3.Keluar");
    //         System.out.println("Pilih Menu: ");
    //         choice= scanner.nextInt();

    //         switch (choice) {
    //             case 1:
    //             tampilanmenu();
    //             break;

    //             case 2:
    //             // updateMenuItems();
    //             break;

    //             case 3:
    //             System.out.println("Terimakasih !");
    //             break;
            
    //             default:
    //             System.out.println("Pilihan anda tidak valid !, pilih 1-3 !");
    //                 break;
    //         }
            
    //     }
    
    // }
    //     public static void tampilanmenu(){
    //        String[] displaymenu= {"Chicken katsu","Soto Lamongan","Udang Crispy","Lemon Tea","Milk chocolate","Coca Cola"};
    //        int[][] displaystok= {{34,23,43}};
           
    //         System.out.println(displaymenu[2]+displaymenu[1]);
           
        
        
    



