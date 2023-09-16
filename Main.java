import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {    
        // menu
        String burger = "Burger";
        String pizza = "Pizza";
        String taco = "Taco";

        int hargaBurger = 10_000;
        int hargaPizza = 15_000;
        int hargaTaco = 15_000;

        System.out.println("==========MENU==========");
        System.out.println("1." + burger + " = " + hargaBurger);
        System.out.println("2." + pizza + " = " + hargaPizza);
        System.out.println("3." + taco + " = " + hargaTaco);
        System.out.println("0.Keluar");

        boolean ulang = true;

        while (ulang) {

            Scanner input  = new Scanner(System.in);
            System.out.print("\nPilih menu (nomor) : ");

            int userInput = input.nextInt();

            ArrayList<Integer> transaksi = new ArrayList<>();
            
            if (userInput == 1 ) {
                System.out.println("Anda memilih " +  burger + " harga " + hargaBurger);

                transaksi.add(hargaBurger);
                System.out.println(transaksi);
            } 
            if (userInput == 2) {
                 System.out.println("Anda memilih " +  pizza + " harga " + hargaPizza);
            }

            // keluar program
            if (userInput == 0) {
                ulang = false;
            }
           
        }
        System.out.println("Terima kasih sudah memesan");

    }
}