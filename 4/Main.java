import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        String burger = "Burger";
        String pizza = "Pizza";
        String taco = "Taco";
        String cocaCola = "Coca - Cola";

        int hargaBurger = 10_000;
        int hargaPizza = 15_000;
        int hargaTaco = 15_000;
        int hargaCola = 5000;

        System.out.println("-----MENU-----");
        System.out.printf("| 1. %s harga %d |\n", burger , hargaBurger);
        System.out.printf("| 2. %s harga %d |\n", pizza , hargaPizza);
        System.out.printf("| 3. %s harga %d |\n", taco , hargaTaco);
        System.out.printf("| 3. %s harga %d |\n", cocaCola , hargaCola);
        
        Scanner input = new Scanner(System.in);

        System.out.print("Masukan nama menu : ");
        String namaMenu = input.nextLine();

        System.out.print("Masukan jumlah : ");
        int jumlahPesanan = input.nextInt();

        System.out.print("Masukan harga : ");
        int harga = input.nextInt(); 


        int totalHarga = harga * jumlahPesanan;
        
        System.out.print("Masukan uang anda : ");
        int uangCustomer = input.nextInt();

        int kembalian = uangCustomer - totalHarga;

        System.out.println("==========STRUK PEMBAYARAN==========");
        System.out.printf("Anda memesan : %s\nJumlah pesanan : %d\nTotal pembayaran : %d\nTunai : %d\nKembalian : %d\n", namaMenu, jumlahPesanan, totalHarga, uangCustomer, kembalian);
    }
}