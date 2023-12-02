import java.util.Scanner;

class Main {
    static String credentials[][] = new String[4][2];
    static String menus[][] = new String[6][4];
    static String cart[][] = new String[10][3];

    static boolean isLoggedIn = false;
    static String getUsername = "";
    static boolean isEndOrder = false;
    static boolean isSeeCart = false;

    public static void main(String[] args) {
        setInitialCredential();
        setInitalMenus();

        // show login menu
        System.out.println("=====WELCOME TO APLIKASI KASIR MASBRO!!!=====");
        System.out.println("1. login");
        System.out.println("2. register");
        System.out.println("0. exit");

        Scanner scLoginMenu = new Scanner(System.in);
        System.out.print("Enter input : ");
        int menuInput = scLoginMenu.nextInt();

        if (menuInput == 0) {
            scLoginMenu.close();
            System.out.println("Thanks for using our service :D");
        } else if (menuInput == 1) {
            handleLogin();

        } else if (menuInput == 2) {
            handleRegister();
            handleLogin();

        } else {
            System.out.println("Please enter a valid input number!");
        }

    }

    static void setInitialCredential() {
        credentials[0][0] = "admin"; // username
        credentials[0][1] = "admin123123"; // password
    }

    static void setInitalMenus() {
        menus[0][0] = "1"; // id
        menus[0][1] = "Bakso"; // name
        menus[0][2] = "10000"; // price
        menus[0][3] = "5"; // stocks

        menus[1][0] = "2"; // id
        menus[1][1] = "Soto"; // name
        menus[1][2] = "5000"; // price
        menus[1][3] = "5"; // stocks

        menus[2][0] = "3"; // id
        menus[2][1] = "Rendang"; // name
        menus[2][2] = "20000"; // price
        menus[2][3] = "5"; // stocks
    }

    static void handleShowMainMenu() {
        Scanner sc = new Scanner(System.in);

        boolean foo = true;

        while (foo) {
            System.out.println();
            System.out.println("Hello " + getUsername);
            System.out.println();
            System.out.println("=====MAIN MENU=====");
            System.out.println("1. Process Transaction");
            System.out.println("2. Manage Menu");
            System.out.println("0. Exit");

            System.out.print("Enter menu number : ");
            int input = sc.nextInt();

            if (input == 0) {
                foo = false;
                System.out.println("Thanks for using our service :D");
                sc.close();

            }

            else if (input == 1) {
                boolean bar = true;

                while (bar) {
                    System.out.println();

                    // show menu info
                    System.out.println("====MENU====");
                    for (int i = 0; i < menus.length; i++) {
                        for (int j = 0; j < menus[i].length; j++) {
                            if (menus[i][j] != null) {

                                System.out.printf("%s. Nama: %s, Harga : %s \n",
                                        menus[i][0],
                                        menus[i][1],
                                        menus[i][2],
                                        menus[i][3]);
                                break;
                            }
                        }
                    }

                    System.out.println("00. See your cart");

                    // order logic
                    int counter = 1;
                    System.out.println();
                    System.out.print("Enter menu number : ");
                    int menuInput = sc.nextInt();

                    // see cart
                    if (menuInput == 00) {
                        bar = false;
                        for (int i = 0; i < cart.length; i++) {
                            for (int j = 0; j < cart[i].length; j++) {
                                if (cart[i][j] != null) {
                                    System.out.println(cart[i][j]);
                                }
                            }
                            break;
                        }
                    } else {
                        System.out.print("Enter amount of order : ");
                        int amountMenu = sc.nextInt();
                        System.out.println();
                        if (menuInput < menus.length) {
                            boolean found = false;

                            for (int i = 0; i < menus.length; i++) {
                                for (int j = 0; j < menus[i].length; j++) {
                                    if (menus[i][j] != null) {
                                        if (menuInput == Integer.parseInt(menus[i][0])) {
                                            // handleTransaction(menus[i][1], Integer.parseInt(menus[i][2]), amountMenu,
                                            // Integer.parseInt(menus[i][3]), counter);

                                            System.out.println("==========YOUR ORDER==========");
                                            System.out.printf("Order %s\nName : %s\nPrice : %s\nAmount: %s\n", counter,
                                                    menus[i][1], menus[i][2], amountMenu);
                                            System.out.println("=================================");

                                            cart[i][0] = menus[i][1];
                                            cart[i][1] = menus[i][2];
                                            cart[i][2] = Integer.toString(amountMenu);

                                            found = true;
                                            break;
                                        }
                                    }
                                }
                            }

                            if (!found) {
                                System.out.println("Menu not found");
                            }
                        } else if (menuInput == 0) {
                            sc.close();
                            System.out.println("Thanks for using our service :D");
                        }

                        else {
                            System.out.println("Please enter a valid menu number");
                        }
                    }

                    counter++;
                }

            } else if (input == 2) {

            } else {
                System.out.println("Please enter a valid input menu");
            }
        }
    }

    static void handleTransaction(String name, int price, int amount, int stock, int counter) {

        // adding menu items to cart
        for (int i = 0; i < cart.length; i++) {
            for (int j = 0; i < cart[i].length; j++) {

                cart[i][j] = name;
                cart[i][j] = Integer.toString(price);
                cart[i][j] = Integer.toString(amount);

            }

        }

    }

    static void handleLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("=====LOGIN=====");
        System.out.println("Please enter your username and password");

        // taking input
        boolean foo = true;

        while (foo) {
            System.out.print("Username : ");
            String inputUsername = sc.nextLine();

            System.out.print("Password : ");
            String inputPassword = sc.nextLine();

            for (int i = 0; i < credentials.length; i++) {
                for (int j = 0; j < credentials[i].length; j++) {

                    if (inputUsername.equals(credentials[i][0])) {
                        if (inputPassword.equals(credentials[i][1])) {
                            isLoggedIn = true;
                            getUsername = inputUsername;
                            System.out.println();
                            System.out.println("Login success");
                            foo = false;
                            break;

                        } else {
                            System.out.println("Password incorrect");
                            break;
                        }
                    } else {
                        System.out.println("Username not found");
                        break;
                    }
                }
                break;
            }

            if (isLoggedIn) {
                handleShowMainMenu();
            }
        }
    }

    static void handleRegister() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("=====REGISTER=====");
        System.out.println("Please enter your username and password");
        System.out.println("Note : Password atleast must be 8 chars long");

        // taking input
        boolean foo = true;

        while (foo) {
            System.out.print("Username : ");
            String inputUsername = sc.nextLine();

            System.out.print("Password : ");
            String inputPassword = sc.nextLine();

            for (int i = 0; i < credentials.length; i++) {
                for (int j = 0; j < credentials[i].length; j++) {

                    if (inputPassword.length() < 8) {
                        System.out.println("Password must be 8 chars long");
                        break;
                    } else {
                        credentials[i][0] = inputUsername;
                        credentials[i][1] = inputPassword;
                        foo = false;
                        System.out.println("Account successfully created");
                        break;
                    }
                }
                break;
            }
        }
    }
}