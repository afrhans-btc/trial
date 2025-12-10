

import java.util.HashMap;

import java.util.logging.Logger;

public class Inventory {

    private static final Logger logger = Logger.getLogger(Inventory.class.getName());
    private HashMap<String, Item> items = new HashMap<>();

    public String addItem(String name, int quantity, IdGenerator<String> idGen) {
        String id = idGen.generateId("ITEM");
        Item item = new Item(id, name, quantity);
        items.put(id, item);

        logger.info("Added item: " + item);
        checkLowStock(item);
        return id;
    }

    public void updateStock(String id, int qty) {
        Item item = items.get(id);
        if (item != null) {
            item.setQuantity(item.getQuantity() + qty);
            logger.info("Stock updated: " + item);
            checkLowStock(item);
        } else {
            logger.warning("No item found with ID: " + id);
        }
    }

    public boolean sellItem(String id, int qty) throws OutOfStockException {
        Item item = items.get(id);

        if (item == null) {
            System.out.println("Item not found!");
            return false;
        }

        if (item.getQuantity() < qty) {
            throw new OutOfStockException(
                "Only " + item.getQuantity() + " units available, but tried to sell " + qty);
        }
        
        item.setQuantity(item.getQuantity() - qty);
        logger.info("Sold " + qty + " units of: " + item.getName());
        checkLowStock(item);
        return true;
    }


    public void showInventory() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }

        for (Item item : items.values()) {
            System.out.println(item);
        }
    }
    public void checkLowStock(Item item){
        if(item.getQuantity() < 5){
            System.out.println("Warning: Low stock for item: " + item);
            logger.warning("Low stock for item: " + item);
        }
    }
    

    public boolean exists(String id) {
        return items.containsKey(id);
    }
}
