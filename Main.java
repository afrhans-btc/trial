public class Main {
    public static void main(String[] args) {

        LogConfig.setupLogger();
        Inventory inventory = new Inventory();
        AppMenu menu = new AppMenu();
        IdGenerator<String> idGenerator = new IdGenerator<>();

        boolean running = true;
        

        while (running) {

            int choice = menu.showMenu();

            switch (choice) {

                case 1: 
                    String name = menu.getString("Enter item name: ");
                    int qty = menu.getInt("Enter starting quantity: ");
                    String newId = inventory.addItem(name, qty, idGenerator);
                    System.out.println("Item added with ID: " + newId);
                    break;

                case 2: 
                    String upId = menu.getString("Enter item ID: ");
                    int addQty = menu.getInt("Enter quantity to add: ");
                    inventory.updateStock(upId, addQty);
                    break;
                
                case 3: 
                    String sellId = menu.getString("Enter item ID: ");
                    int sellQty = menu.getInt("Enter quantity to sell: ");

                    try {
                        boolean success = inventory.sellItem(sellId, sellQty);
                        
                        if (success) {
                            System.out.println("Sold " + sellQty + " units successfully!");
                        }
                    } catch (OutOfStockException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 4: 
                    inventory.showInventory();
                    break;
                
                case 5: 
                    showLogs();
                    break;  

                case 6: // Exit
                    running = false;
                    System.out.println("Exiting system...");
                    break;
                
                
                    
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
    public static void showLogs() {
        System.out.println("\n===== SYSTEM LOGS =====");

        try {
            java.nio.file.Files.lines(java.nio.file.Paths.get("inventory.log"))
                .forEach(System.out::println);
        } catch (Exception e) {
        System.out.println("Log file not found or cannot be read.");
    }
}


}
