import java.util.Scanner;

public class penambahanTran {
    // Fungsi untuk menghitung diskon
    public static double hitungDiskon(double totalPembelian, double persentaseDiskon) {
        return (persentaseDiskon / 100) * totalPembelian;
    }

    // Fungsi untuk menghitung total pembayaran setelah diskon
    public static double hitungTotalPembayaran(double totalPembelian, double diskon) {
        return totalPembelian - diskon;
    }

    // Fungsi untuk menampilkan menu
    public static void displayMenu() {
        System.out.println("1. Menu 1 - Harga Rp10000");
        System.out.println("2. Menu 2 - Harga Rp15000");
        // Tambahkan menu lainnya sesuai kebutuhan
        System.out.println("0. Selesai");
        System.out.println("-1. Cari Menu");
    }

    // Fungsi untuk mencari menu
    public static void searchMenu(Scanner scanner) {
        // Implementasi pencarian menu
        System.out.println("Implementasi pencarian menu");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuChoice;
        double totalHarga = 0;
        double totalTransaksiKeseluruhan = 0;
        int jumlahPesanan = 0;

        // Array untuk menyimpan informasi setiap pesanan
        double[][] pesananArray = new double[100][6]; // Misalnya, kita batasi hingga 100 pesanan

        do {
            displayMenu();
            System.out.print("Masukkan nomor menu yang ingin Anda pesan : ");
            menuChoice = scanner.nextInt();

            if (menuChoice == 0) {
                break;
            } else if (menuChoice == -1) {
                searchMenu(scanner);
            } else if (menuChoice >= 1 && menuChoice <= 2) { // Ubah sesuai dengan jumlah menu yang Anda miliki
                int quantity;
                System.out.print("Masukkan jumlah pesanan: ");
                quantity = scanner.nextInt();
                int harga = (menuChoice == 1) ? 10000 : 15000; // Sesuaikan harga berdasarkan menu
                double diskon = 0;

                System.out.print("Apakah ada diskon? (Ya/Tidak): ");
                String inputDiskon = scanner.next();

                if (inputDiskon.equalsIgnoreCase("Ya")) {
                    System.out.print("Masukkan persentase diskon: ");
                    double persentaseDiskon = scanner.nextDouble();
                    diskon = hitungDiskon(harga * quantity, persentaseDiskon);
                }

                double totalPembelian = harga * quantity;
                double totalPembayaran = hitungTotalPembayaran(totalPembelian, diskon);

                // Menyimpan informasi pesanan ke dalam array
                pesananArray[jumlahPesanan][0] = menuChoice;
                pesananArray[jumlahPesanan][1] = quantity;
                pesananArray[jumlahPesanan][2] = harga;
                pesananArray[jumlahPesanan][3] = totalPembelian;
                pesananArray[jumlahPesanan][4] = diskon;
                pesananArray[jumlahPesanan][5] = totalPembayaran;

                jumlahPesanan++;

                System.out.println("Total pembelian: Rp" + totalPembelian);
                System.out.println("Diskon: Rp" + diskon);
                System.out.println("Total pembayaran setelah Diskon: Rp" + totalPembayaran);

                // Menambahkan total pembayaran ke totalTransaksiKeseluruhan
                totalTransaksiKeseluruhan += totalPembayaran;

            } else {
                System.out.println("Nomor menu tidak valid. Silakan pilih lagi.");
            }

        } while (true);

        // Menampilkan detail setiap pesanan
        System.out.println("Detail Pesanan:");
        for (int i = 0; i < jumlahPesanan; i++) {
            System.out.println("Pesanan ke-" + (i + 1));
            System.out.println("Menu: " + pesananArray[i][0]);
            System.out.println("Jumlah: " + pesananArray[i][1]);
            System.out.println("Harga: Rp" + pesananArray[i][2]);
            System.out.println("Total Pembelian: Rp" + pesananArray[i][3]);
            System.out.println("Diskon: Rp" + pesananArray[i][4]);
            System.out.println("Total Pembayaran: Rp" + pesananArray[i][5]);
            System.out.println("--------------------------");
        }

        System.out.println("Total Seluruh Transaksi: Rp" + totalTransaksiKeseluruhan);
        System.out.println("Terima kasih!");

        scanner.close();
    }
}


