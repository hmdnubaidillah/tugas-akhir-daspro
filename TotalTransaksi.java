import java.util.Scanner;

public class TotalTransaksi {

        int totalHarga = 0;
        int menuChoice;
        double diskon=0;
        double TotalHarga=0;
        double totalTransaksiKeseluruhan = 0;
        String InputDiskon;
        int jumlahPesanan=0;

    //penyimanan untuk pemesanan
    double[][] pemesanan = new double[100][6];

    // Menyimpan informasi pesanan ke dalam array
    pemesanan[jumlahPesanan][0] = menuChoice;
    pemesanan[jumlahPesanan][1] = quantity;
    pemesanan[jumlahPesanan][2] = harga;
    pemesanan[jumlahPesanan][3] = totalPembelian;
    pemesanan[jumlahPesanan][4] = diskon;
    pemesanan[jumlahPesanan][5] = totalPembayaran;

    for (int i = 0; i < jumlahPesanan; i++) {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║         --Detail Pesanan--       ║");
        System.out.println("╚══════════════════════════════════╝");
        System.out.println("Pesanan ke-" + (i + 1));
        System.out.println("Menu: " + pemesanan[i][0]);
        System.out.println("Jumlah: " + pemesanan[i][1]);
        System.out.println("Harga: Rp" + pemesanan[i][2]);
        System.out.println("Total Pembelian: Rp" + pemesanan[i][3]);
        System.out.println("Diskon: Rp" + pemesanan[i][4]);
        System.out.println("Total Pembayaran: Rp" + pemesanan[i][5]);
        System.out.println("-----------------------------------");
    }
    System.out.println("Total Seluruh Transaksi: Rp" + totalTransaksiKeseluruhan);
    System.out.println("Terima kasih!");
}
}
