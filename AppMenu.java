import java.util.Scanner;

public class AppMenu {

    private Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Item");
        System.out.println("2. Update Stock");
        System.out.println("3. Sell Item");
        System.out.println("4. View Inventory");
        System.out.println("5. View Logs");
        System.out.println("6. Exit");
        
        System.out.print("Enter your choice: ");

        return scanner.nextInt();
    }

    public String getString(String msg) {
        System.out.print(msg);
        scanner.nextLine();
        return scanner.nextLine();
    }

    public int getInt(String msg) {
        System.out.print(msg);
        return scanner.nextInt();
    }
}
