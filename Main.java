import Menu.MenuItem;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // menus
        MenuItem burger = new MenuItem(1,"Burger", 10_000);
        MenuItem fries = new MenuItem(2,"Fries", 8000 );
        MenuItem soda = new MenuItem(3,"Soda", 5000 );

        System.out.println("==========MENU==========");
        System.out.println(burger.getIndex() + "." + burger.getName() + ": Harga " + burger.getPrice());
        System.out.println(fries.getIndex() + "." + fries.getName() + " : Harga " + fries.getPrice());
        System.out.println(soda.getIndex() + "." + soda.getName() + "  : Harga " + soda.getPrice());
        
        // input user
        Scanner input = new Scanner(System.in);
        System.out.print("Pilih menu (nomor): ");
        int userInput = input.nextInt();
        
      
        
        



    }
    
}
