import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        // user db
        String username = "123";
        String password = "123";

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

            if (inputUsername != username) {
                System.out.println("Username tidak ditemukan");
                

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