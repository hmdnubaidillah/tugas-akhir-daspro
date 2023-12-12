import java.util.Scanner;

public class Mengidentifikasi {

    public static String[][] membuatmenu(int maxmenu) {
        String[][] menu = new String[maxmenu][2];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < maxmenu; i++) {
            System.out.print("Masukkan nama menu: ");
            menu[i][0] = scanner.nextLine();
            System.out.print("Masukkan harga item: ");
            menu[i][1] = scanner.nextLine();
        }
        return menu;
    }

    public static void tampilanbarang(String[][] menu, int maxmenu) {
        System.out.println("\nMenu yang disimpan: ");
        for (int i = 0; i < maxmenu; i++) {
            System.out.println(menu[i][0] + " - Rp " + menu[i][1]);
        }
    }

    public static void searchmenu(String[][] menu, int maxmenu) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPanggil salah satu Menu: ");
        System.out.print("Masukkan nama Menu yang ingin dipanggil: ");
        String searchmenu = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < maxmenu; i++) {
            if (menu[i][0].equalsIgnoreCase(searchmenu)) {
                System.out.println("\nMenu ditemukan!");
                System.out.println(menu[i][0] + " - Rp " + menu[i][1]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nMenu tidak ditemukan");
        }
    }

    public static void main(String[] args) {
        int maxmenu = 5;
        String[][] menu = membuatmenu(maxmenu);
        tampilanbarang(menu, maxmenu);
        searchmenu(menu, maxmenu);
    }

}
