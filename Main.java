import java.util.Scanner;

class Main {
    public static void main(String[] args) {
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

         // user db
            String username = "123";
            String password = "123";

       if (number == 1) {
            Scanner inputLogin = new Scanner(System.in);

            System.out.println("========= LOGIN =========");
            
            System.out.print("Masukan username : ");
            String inputUsername = inputLogin.nextLine();

            System.out.print("Masukan password : ");
            String inputPassword = inputLogin.nextLine();

            if ( inputUsername.equals(username)) {

                if (inputPassword.equals(password)){
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
                    
                    System.out.print("Masukan nomor : ");
                    int menuInput = input.nextInt();

                    if (menuInput == 1) {
                        Scanner inputMenu = new Scanner(System.in);
                        Scanner inputDiskon = new Scanner(System.in);
                        System.out.println("Anda memesan : " + burger);
                        
                        // add jumlah pesanan
                        System.out.println("Jumlah Pesanan : ");
                        int jumlahPesanan = inputMenu.nextInt();
                        int totalPembayaran  = jumlahPesanan * hargaBurger;

                        // jika ada diskon
                        System.out.println("Apakah ada diskon? (Y/T) : ");
                        String isDiscount = inputDiskon.nextLine();

                        if (isDiscount.toLowerCase().equals("y")){
                            System.out.print("Masukan diskon : ");
                            double diskon = inputMenu.nextDouble();
                            double totalDiskon = totalPembayaran * diskon / 100;
                            double hargaAkhir = totalPembayaran - totalDiskon;
                            System.out.printf("Anda memesan : %s\nJumlah : %d\nHarga : %d\nTotal pembayaran : %s\n", burger, jumlahPesanan, hargaBurger, hargaAkhir );
                        } 
                        else {
                            System.out.printf("Anda memesan : %s\nJumlah : %d\nHarga : %d\nTotal pembayaran : %d\n", burger, jumlahPesanan, hargaBurger,totalPembayaran );
                            
                        }
                        // lanjutkan kodingan menunya dibawah 
                        // ----------



                        // ----------
                    }
                } else {
                    System.out.println("Username atau password salah");
                }
            }  else {
                System.out.println("Username atau password salah");
            }
            
       }

       if (number == 2 ) {
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