import java.util.Scanner;

class Main {
    static String cashierCredential[][] = new String[4][2];
    static String managerCredential[][] = new String[4][2];

    static String menus[][] = new String[6][4];
    static String cart[][] = new String[menus.length][4];

    static String getUsername = "";

    static boolean isEndOrder = false;
    static boolean isSeeCart = false;

    public static void main(String[] args) {
        setInitialCredential();
        setInitalMenus();
        // show login menu
        boolean foo = true;

        while (foo) {
            Scanner scLoginMenu = new Scanner(System.in);
            System.out.println("=====WELCOME TO APLIKASI KASIR MASBRO!!!=====");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.print("Enter input : ");
            int menuInput = scLoginMenu.nextInt();

            if (menuInput == 0) {
                foo = false;
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

    }

    static void setInitialCredential() {
        cashierCredential[0][0] = "kasir"; // username
        cashierCredential[0][1] = "kasir123123"; // password

        managerCredential[0][0] = "manager";
        managerCredential[0][1] = "manager123123";
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

    static void handleShowMenu() {
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
    }

    static void printCart() {
        for (int i = 0; i < cart.length; i++) {
            if (cart[i][0] != null) {
                System.out.printf("Order %s\nItem : %s\nPrice : %s\nAmount : %s\n", (i + 1),
                        cart[i][0],
                        cart[i][1], cart[i][2]);
                System.out.println();

            } else {
                System.out.printf("%s. Empty...\n", (i + 1));
            }
        }
    }

    static boolean handleShowCart() {
        Scanner sc = new Scanner(System.in);
        boolean cartStats = true;
        boolean isCart = true;
        int cartIndex[] = new int[cart.length];
        String getMenuName = "";

        while (isCart) {
            Scanner scan = new Scanner(System.in);
            System.out.println();
            System.out.println("==========YOUR CART===========");
            printCart();
            System.out.println();
            System.out.println("1. Add menu amount");
            System.out.println("2. Decrease menu amount");
            System.out.println("3. Remove menu");
            System.out.println("0. Exit");
            System.out.println();

            System.out.print("Enter menu number (cart) : ");
            int input = sc.nextInt();

            if (input == 0) {
                isCart = false;
                cartStats = false;
                break;
            } else if (input == 1) {
                System.out.println();
                System.out.print("Choose which menu should be added : ");
                int addMoreMenuAmount = scan.nextInt();

                for (int i = 0; i < cart.length; i++) {
                    cartIndex[i] = i;

                    if (cart[i] != null && cartIndex[i] == (addMoreMenuAmount - 1)) {
                        System.out.println(cart[i][0]);
                        break;
                    }
                }
            } else if (input == 1) {

            } else if (input == 3) {
                System.out.println();
                System.out.print("Choose which menu should be removed : ");
                int addMoreMenuAmount = scan.nextInt();

                for (int i = 0; i < cart.length; i++) {
                    cartIndex[i] = i;

                    if (cart[i] != null && cartIndex[i] == (addMoreMenuAmount - 1)) {
                        getMenuName = cart[i][0];
                        for (int j = 0; j < cart[i].length; j++) {
                            if (cart[i][j] != null) {
                                cart[i][j] = null;
                                System.out.println(getMenuName + " removed");
                                break;
                            } else {
                                System.out.println("Item already removed");
                            }
                        }
                    }
                }
            } else {
                System.out.println("Please enter a valid number input");
            }
        }
        return cartStats;
    }

    static void handleShowDashboard() {
        Scanner sc = new Scanner(System.in);

        System.out.println("==========MANAGER DASHBOARD==========");
        System.out.println();
        System.out.println(getUsername);
        System.out.println();
        System.out.println("1. See Finnance report");
        System.out.println("0. Logout");

        boolean bar = true;

        while (bar) {
            System.out.print("Enter number : ");
            int input = sc.nextInt();

            if (input == 0) {
                bar = false;
                System.out.println("Logged out");
                break;
            }
        }
    }

    static void handleShowMainMenu() {
        Scanner sc = new Scanner(System.in);

        boolean foo = true;
        while (foo) {
            System.out.println();
            System.out.println(getUsername);
            System.out.println();
            System.out.println("=====MAIN MENU=====");
            System.out.println("1. Process Transaction");
            System.out.println("2. Manage Menu");
            System.out.println("0. Logout");

            System.out.print("Enter menu number : ");
            int input = sc.nextInt();

            if (input == 0) {
                foo = false;
                System.out.println();
                System.out.println("Logged out :(");
                System.out.println();
                break;
            }

            else if (input == 1) {
                boolean bar = true;

                while (bar) {
                    System.out.println();

                    // show menu info
                    handleShowMenu();

                    System.out.println();
                    System.out.println("11. See your cart");
                    System.out.println("22. End order");
                    System.out.println("0. Go back to main menu");

                    // order logic
                    int counter = 1;
                    System.out.println();
                    System.out.print("Enter menu number : ");
                    int menuInput = sc.nextInt();

                    if (menuInput == 0) {
                        break;
                    }

                    else if (menuInput == 11) {
                        // see cart
                        boolean cartStats = handleShowCart();

                        if (cartStats) {
                            handleShowCart();
                        } else {
                            continue;
                        }
                    }

                    // end order and calculate all the order
                    else if (menuInput == 22) {

                        Scanner endOrderSc = new Scanner(System.in);
                        System.out.print("Are you sure? (y/n) : ");
                        String confirm = endOrderSc.nextLine();

                        int eachItemPrice[] = new int[cart.length];

                        if (confirm.equalsIgnoreCase("y")) {
                            int totalPrice = 0;

                            for (int i = 0; i < cart.length; i++) {
                                for (int j = 0; j < cart[i].length; j++) {

                                    if (cart[i][j] != null) {
                                        eachItemPrice[i] = Integer.parseInt(cart[i][1]) * Integer.parseInt(cart[i][2]);
                                        totalPrice += eachItemPrice[i];
                                        break;
                                    }
                                }
                            }
                            boolean isEndOrder = false;
                            System.out.println();
                            System.out.println("==========YOUR RECEIPT===========");
                            for (int i = 0; i < cart.length; i++) {
                                if (cart[i][0] != null) {
                                    System.out.printf("Item : %s, Amount : %s, Price : Rp.%s ", cart[i][0], cart[i][2],
                                            cart[i][1]);
                                    System.out.println();

                                    isEndOrder = true;
                                }
                            }
                            if (isEndOrder) {
                                System.out.println("Total : Rp." + totalPrice);

                                for (int i = 0; i < cart.length; i++) {
                                    for (int j = 0; j < cart[i].length; j++) {
                                        cart[i][j] = null;
                                    }
                                }
                                continue;
                            }
                        } else {
                            System.out.println("Order not confirmed");
                        }
                    }

                    // condition if menu already in cart and want to update the amount
                    // get index of the selected menu
                    int cartIndex = -1;
                    for (int i = 0; i < cart.length; i++) {
                        if (cart[i][0] != null && cart[i][0].equals(menus[menuInput - 1][1])) {
                            cartIndex = i;
                            break;
                        }
                    }

                    // add additional menu amount to cart
                    if (cartIndex != -1) {
                        handleAddMenuAmount(cartIndex);
                    } else {

                        // process transaction here
                        System.out.print("Enter amount of order : ");
                        int amountMenu = sc.nextInt();
                        System.out.println();

                        if (menuInput < menus.length) {
                            handleTransaction(amountMenu, counter, menuInput);

                        } else {
                            System.out.println("Please enter a valid menu number");
                        }
                        counter++;
                    }
                }
            } else if (input == 2) {
                // manage menu
                Scanner scan = new Scanner(System.in);
                boolean bar = true;

                while (bar) {
                    System.out.println("==========MANAGE MENU==========");
                    System.out.println("1. See menu");
                    System.out.println("0. Exit");

                    System.out.print("Enter menu input : ");
                    int menuInput = scan.nextInt();

                    if (menuInput == 1) {
                        System.out.println();
                        System.out.println("==========MENU==========");
                        for (int i = 0; i < menus.length; i++) {
                            if (menus[i][0] != null) {
                                System.out.printf("%s. Name : %s, price : %s, Stock : %s\n", menus[i][0], menus[i][1],
                                        menus[i][2], menus[i][3]);
                            }
                        }
                    } else if (menuInput == 0) {
                        bar = false;
                        break;
                    } else {
                        System.out.println("Please enter valid menu");
                    }
                }

            } else {
                System.out.println("Please enter a valid input menu");
            }
        }
    }

    static void handleAddMenuAmount(int cartIndex) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter additional amount of order : ");

        int additionalOrder = sc.nextInt();
        int currentAmount = Integer.parseInt(cart[cartIndex][2]);
        int totalCurrentOrder = additionalOrder + currentAmount;
        boolean stockUpdated = false;

        // Update stock of the menu item in the cart
        if (cart[cartIndex][0] != null) {
            int menuIndex = -1;
            for (int i = 0; i < menus.length; i++) {
                if (menus[i][0] != null && cart[cartIndex][0].equals(menus[i][1])) {
                    menuIndex = i;
                    break;
                }
            }
            if (menuIndex != -1) {
                int amountMenuInStock = Integer.parseInt(menus[menuIndex][3]);
                if (totalCurrentOrder > amountMenuInStock) {
                    System.out.println("Stock is not enough");
                } else {
                    int updateMenuStock = amountMenuInStock - additionalOrder;
                    menus[menuIndex][3] = Integer.toString(updateMenuStock);
                    cart[cartIndex][2] = Integer.toString(totalCurrentOrder);
                    stockUpdated = true;
                    System.out.println("Additional amount of order has been added");
                }
            } else {
                System.out.println("Menu not found in the menu list");
            }
        } else {
            System.out.println("Cart is empty at this index");
        }

        if (!stockUpdated) {
            System.out.println("Stock not updated for the item in the cart. Check order or stock availability.");
        }
    }

    // static void handleAddMenuAmount(int cartIndex) {
    // Scanner sc = new Scanner(System.in);
    // System.out.print("Enter additional amount of order : ");

    // int additionalOrder = sc.nextInt();
    // int currentAmount = Integer.parseInt(cart[cartIndex][2]);
    // int totalCurrentOrder = additionalOrder + currentAmount;
    // boolean stockUpdated = false;
    // // update stock of additional order
    // for (int i = 0; i < menus.length; i++) {
    // if (menus[i][0] != null && cart[i][0] != null) {
    // if (menus[i][3].equals("0")) {
    // System.out.printf("%s is out of stock\n", menus[i][1]);
    // break;
    // } else {
    // int updateMenuStock = Integer.parseInt(menus[i][3]) - totalCurrentOrder;
    // menus[i][3] = Integer.toString(updateMenuStock);
    // cart[cartIndex][2] = Integer.toString(totalCurrentOrder);
    // stockUpdated = true;
    // System.out.println("Addititonal amount of order has been added");
    // break;
    // }
    // }
    // }
    // if (!stockUpdated) {
    // System.out.println("Stock not updated for any item. Check order or stock
    // availability.");
    // }
    // }

    static void handleTransaction(int amountMenu, int counter, int menuInput) {
        boolean found = false;
        int cart_index = -1;

        for (int i = 0; i < cart.length; i++) {
            if (cart[i][0] == null) {
                cart_index = i;
                break;
            }
        }

        if (cart_index == -1) {
            System.out.println("Cart is full");

        } else {
            for (int i = 0; i < menus.length; i++) {
                if (menus[i][0] != null) {
                    if (menuInput == Integer.parseInt(menus[i][0])) {

                        System.out.println("==========YOUR ORDER==========");
                        System.out.printf("Order %s\nName : %s\nPrice : %s\nAmount: %s\n", counter,
                                menus[i][1], menus[i][2], amountMenu);
                        System.out.println("=================================");

                        int amountMenuInStock = Integer.parseInt(menus[i][3]);
                        if (amountMenu > amountMenuInStock) {
                            found = true;
                            System.out.println("Stock is not enough");
                        } else {

                            // push menu to cart
                            cart[cart_index][0] = menus[i][1]; // name
                            cart[cart_index][1] = menus[i][2]; // price
                            cart[cart_index][2] = Integer.toString(amountMenu); // amount
                            cart[cart_index][3] = Integer.toString(counter);

                            // update stock when first order
                            int updatedStock = Integer.parseInt(menus[i][3]) - amountMenu;
                            menus[i][3] = Integer.toString(updatedStock);
                            found = true;
                            System.out.println("Order added to cart");
                        }
                    }
                }
            }
            if (!found) {
                System.out.println("Menu not found");
            }
        }
    }

    static void handleLogin() {
        Scanner sc = new Scanner(System.in);
        boolean bar = true;
        boolean foo = true;
        boolean isContinueLoggingManager = true;
        boolean isContinueLoggingCashier = true;
        boolean isLoggedInManager = false;
        boolean isLoggedInCashier = false;

        while (bar) {
            System.out.println();
            System.out.println("=====LOGIN=====");
            System.out.println("Login as : ");
            System.out.println("1. Manager");
            System.out.println("2. Cashier");
            System.out.println("0. Exit");

            // taking input
            while (foo) {
                System.out.print("Please enter your role : ");
                int roleInput = sc.nextInt();

                if (roleInput == 1) {
                    System.out.println();
                    System.out.println("Login as manager");
                    System.out.println();

                    while (isContinueLoggingManager) {
                        Scanner managerSc = new Scanner(System.in);

                        System.out.print("Username : ");
                        String inputUsername = managerSc.nextLine();

                        System.out.print("Password : ");
                        String inputPassword = managerSc.nextLine();

                        for (int i = 0; i < managerCredential.length; i++) {
                            if (managerCredential[i][0] != null && inputUsername.equals(managerCredential[i][0])) {
                                if (inputPassword.equals(managerCredential[i][1])) {
                                    isLoggedInManager = true;

                                    getUsername = "Cashier : " + inputUsername;
                                    System.out.println();
                                    System.out.println("Login success");
                                    isContinueLoggingManager = false;
                                    foo = false;
                                    bar = false;
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
                    }

                } else if (roleInput == 2) {
                    System.out.println();
                    System.out.println("Login as cashier");
                    System.out.println();

                    while (isContinueLoggingCashier) {

                        Scanner cashierSc = new Scanner(System.in);

                        System.out.print("Username : ");
                        String inputUsername = cashierSc.nextLine();

                        System.out.print("Password : ");
                        String inputPassword = cashierSc.nextLine();

                        for (int i = 0; i < cashierCredential.length; i++) {
                            if (cashierCredential[i][0] != null && inputUsername.equals(cashierCredential[i][0])) {
                                if (inputPassword.equals(cashierCredential[i][1])) {
                                    isLoggedInCashier = true;

                                    getUsername = "Cashier : " + inputUsername;
                                    System.out.println();
                                    System.out.println("Login success");
                                    isContinueLoggingCashier = false;
                                    foo = false;
                                    bar = false;
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
                    }
                } else if (roleInput == 0) {
                    System.out.println();
                    System.out.println("Exiting to welcoming menu");
                    System.out.println();
                    foo = false;
                    bar = false;
                } else {
                    System.out.println();
                    System.out.println("Please enter valid number");
                    System.out.println();
                    continue;
                }
            }
        }

        if (isLoggedInCashier) {
            handleShowMainMenu();
        }

        if (isLoggedInManager) {
            handleShowDashboard();
        }

    }

    static void handleRegister() {
        Scanner sc = new Scanner(System.in);

        boolean bar = true;

        while (bar) {
            System.out.println();
            System.out.println("=====REGISTER=====");
            System.out.println("1. Manager");
            System.out.println("2. Cashier");
            System.out.println("0. Exit");

            System.out.print("Enter input : ");
            int input = sc.nextInt();

            if (input == 1) {

            } else if (input == 2) {

            } else if (input == 0) {
                bar = false;
            } else {

            }

            System.out.println("Please enter your username and password");
            System.out.println("Note : Password atleast must be 8 chars long");
        }

        // taking input
        boolean foo = true;

        while (foo) {
            System.out.print("Username (0 to exit) : ");
            String inputUsername = sc.nextLine();

            System.out.print("Password (0 to exit) : ");
            String inputPassword = sc.nextLine();

            if (inputUsername.equals("0") && inputPassword.equals("0")) {
                foo = false;
            }
            for (int i = 0; i < cashierCredential.length; i++) {
                if (cashierCredential[i][0] != null && inputPassword.length() < 8) {
                    System.out.println("Password must be 8 chars long");
                    break;
                } else {
                    cashierCredential[i][0] = inputUsername;
                    cashierCredential[i][1] = inputPassword;
                    foo = false;
                    System.out.println("Account successfully created");
                    break;
                }
            }
        }
    }
}
