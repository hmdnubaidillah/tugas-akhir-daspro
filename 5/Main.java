import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        // user db
        String username = "admin";
        String password = "admin123";

        Scanner input = new Scanner(System.in);

        // main menu
        System.out.println("========= MAIN MENU =========");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("0. Keluar");

        System.out.print("Masukan pilihan : ");
        int number = input.nextInt();

       if (number > 3) {
        System.out.println("Harap masukan nomer yg valid");
       } 

       if (number == 0) {
        input.close();
        System.out.println("Terima kasih sudah menggunakan jasa kami :D");
       }

       if (number == 1) {

            Scanner inputLogin = new Scanner(System.in);

            System.out.println("========= LOGIN =========");
            
            System.out.print("Masukan username : ");
            String inputUsername = inputLogin.nextLine();

            System.out.print("Masukan password : ");
            String inputPassword = inputLogin.nextLine();

            if (inputUsername != username || inputPassword != password) {
                System.out.println("Username tidak ditemukan atau password salah");

            } else {
                System.out.println("Login berhasil");

                // Transaction
                String burger = "Burger";
                String pizza = "Pizza";
                String taco = "Taco";
                String cocaCola = "Coca-Cola";

                int hargaBurger = 10_000;
                int hargaPizza = 15_000;
                int hargaTaco = 15_000;
                int hargaCola = 5000;

                System.out.println("========= MENU ==========");
                System.out.printf("| 1. %s harga %d |\n", burger , hargaBurger);
                System.out.printf("| 2. %s harga %d |\n", pizza , hargaPizza);
                System.out.printf("| 3. %s harga %d |\n", taco , hargaTaco);
                System.out.printf("| 4. %s harga %d |\n", cocaCola , hargaCola);
                System.out.println("| 0. Keluar     |");
                
                Scanner inputMenu = new Scanner(System.in);
                System.out.print("Masukan pilihan : ");
                int inputUserMenu = inputMenu.nextInt();
                
                if (inputUserMenu > 4) {
                    System.out.println("Harap masukan pilihan yang valid!");
                } 

                if (inputUserMenu == 0) {
                    System.out.println("Terima kasih sudah menggunakan jasa kami :D");

                }
            }

       }

       if(number == 2 ) {
        Scanner inputRegister = new Scanner(System.in);

        System.out.println("========= REGISTER =========");

        System.out.print("Masukan username : ");
        username = inputRegister.nextLine(); 

        System.out.print("Masukan password : ");
        password = inputRegister.nextLine();

        System.out.println("Register berhasil!!! :D");

       }
    }
}