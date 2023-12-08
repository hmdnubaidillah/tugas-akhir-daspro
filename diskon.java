import java.util.Scanner;

public class diskon{
    static String[][] menuItems = {
    {"Chicken katsu",  "20000"},
    {"Soto Lamongan",  "12000"},
    {"Udang Crispy",   "10000"},
    {"LemonTea",       "10000"},
    {"Milk chocolate", "15000"},
    {"Coca Cola",      "15000"}

};
    public static double HitungDiskon(double TotalPembelian, double PersentaseDiskon){
        return(PersentaseDiskon/100) * TotalPembelian;
    }
    public static double HitungTotalPembayaran(double totalPembelian, double diskon){
        return totalPembelian - diskon;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int totalHarga = 0;
        int menuChoice;
        double diskon=0;
        double persentaseDiskon;
        double totalTransaksiKeseluruhan = 0;
        String InputDiskon;
        int jumlahPesanan=0;

        //penyimanan untuk pemesanan
        double[][] pemesanan = new double[100][6];

        System.out.print("Masukkan nomor menu yang ingin Anda pesan : ");
            menuChoice = scanner.nextInt();

                int quantity;
                System.out.print("Masukkan jumlah pesanan: ");
                quantity = scanner.nextInt();
                int harga = Integer.parseInt(menuItems[menuChoice - 1][1]);
                totalHarga += (harga * quantity);

                System.out.print("Apakah ada diskon?(Ya/Tidak) ");
                InputDiskon= scanner.next();

                if (InputDiskon.equalsIgnoreCase("Ya")) {
                    System.out.print("Masukkan persentase diskon: ");
                    persentaseDiskon = scanner.nextDouble();
                    diskon = HitungDiskon(harga * quantity, persentaseDiskon);
                }

                double totalPembelian = harga * quantity;
                double totalPembayaran = HitungTotalPembayaran(totalPembelian, diskon);

                // Menyimpan informasi pesanan ke dalam array
                pemesanan[jumlahPesanan][0] = menuChoice;
                pemesanan[jumlahPesanan][1] = quantity;
                pemesanan[jumlahPesanan][2] = harga;
                pemesanan[jumlahPesanan][3] = totalPembelian;
                pemesanan[jumlahPesanan][4] = diskon;
                pemesanan[jumlahPesanan][5] = totalPembayaran;

                System.out.println("Total pembelian: Rp" + totalPembelian);
                System.out.println("Diskon: Rp" + diskon);
                System.out.println("Total pembayaran setelah Diskon: Rp" + totalPembayaran);

                // Menambahkan total pembayaran ke totalTransaksiKeseluruhan
                totalTransaksiKeseluruhan += totalPembayaran;

                jumlahPesanan++;

                
}} 
