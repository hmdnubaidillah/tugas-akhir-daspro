import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        String burger = "Burger";
        String Pizza = "Pizza";
        String Taco = "Taco";

        int hargaBurger = 10_000;
        int hargaPizza = 15_000;
        int hargaTaco = 15_000;

        System.out.println("======MENU=======");
        System.out.println("1." + burger +"=" + hargaBurger);
        System.out.println("2." + Pizza  +"=" + hargaPizza);
        System.out.println("3." + Taco   +"=" + hargaTaco);
        System.out.println("0.Keluar");

        Scanner input = new Scanner(System.in);

        System.out.println("Pilih menu : ");
        String namaMenu1 = input.nextLine();
        String namaMenu2 = input.nextLine();
        
        System.out.println("Masukan harga : ");
        int harga1 = input.nextInt();
        int harga2 = input.nextInt();

        int totalPembayaran = harga1 + harga2;

        System.out.println("Anda memesan : " + namaMenu1 + " " + namaMenu2);
        System.out.println("Total pembayaran : "  + totalPembayaran);
    }
}