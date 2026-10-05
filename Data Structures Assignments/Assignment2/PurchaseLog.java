package Assignment2;
import java.util.ArrayList;
import java.util.LinkedList;

public class PurchaseLog {
    //chosen type
    private ArrayList<PurchaseItem> log;

    //Test alt/type
    private LinkedList<PurchaseItem> logtest;

    //Constructor!
    public PurchaseLog() {
        this.log = new ArrayList<PurchaseItem>();
        this.logtest = new LinkedList<PurchaseItem>();
    }

    public void addItem(PurchaseItem item) { //O(n) worst case due to resizing.
        //Uses ArrayList's add() method. It automatically resizes the array if needed.
        this.log.add(item);
    }

    public PurchaseItem findItemByName(String name) { //O(n) because the amount of time spent depends on length.
        PurchaseItem found = null;
        for (PurchaseItem item : log) {
            if (item.getName().equals(name)) {
                found = item;
                break;
            }
        }
        //Returns null if  the item is not found in the log else, returns the found item.
        return found;
    }

    public PurchaseItem findItemByNameTest(String name ){
        PurchaseItem found = null;
        for (PurchaseItem item : logtest) {
            if (item.getName().equals(name)) {
                found = item;
                break;
        }
    }
        return found;
    }

    public void updatePrice(String name, double newPrice) { //O(n) because the amount of time spent depends on length.
        for (PurchaseItem item : log) {
            if (item.getName().equals(name)) {
                item.setPrice(newPrice);
                break;
            }
        }
    }

    public void printDailyReport() { //O(n) complexity due to iterating through the whole loop.
        int totalCount = itemCount();
        double totalRevenue = 0.0;
        //For each item in the log, the name is stored in
        PurchaseItem bestSeller = null;

        System.out.println("Daily Report:");
        for (PurchaseItem item : log) {
            totalRevenue += item.getPrice();
            if (bestSeller == null || item.getPrice() > bestSeller.getPrice()) {
                bestSeller = item;
            }
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total Count: " + totalCount);
        System.out.println("Total Revenue: $" + totalRevenue);
        System.out.println("Best Seller: " + (bestSeller != null ? bestSeller.getName() : "None"));
    }

    public int itemCount() {
        return log.size();
    }
}
