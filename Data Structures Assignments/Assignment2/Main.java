package Assignment2;

public class Main {
/*   public static void main(String[] args) {

        // ---- Sample data to load into the Purchase Log ----
        PurchaseItem[] sampleItems = {
            new PurchaseItem("Bread", 3.49),
            new PurchaseItem("Milk", 2.99),
            new PurchaseItem("Eggs", 4.29),
            new PurchaseItem("Coffee", 8.99),
            new PurchaseItem("Bananas", 1.29),
            new PurchaseItem("Cereal", 4.79),
            new PurchaseItem("Chicken Breast", 9.99),
            new PurchaseItem("Paper Towels", 6.49)
        };

        PurchaseLog log = new PurchaseLog();

        for (PurchaseItem item : sampleItems) {
            log.addItem(item);
        }

        System.out.println("Purchase Log loaded with " + log.itemCount() + " items.");

        // Example test call - findItemByName. Do the same for every other required method.
        PurchaseItem found = log.findItemByName("Coffee");
        System.out.println("Looked up 'Coffee', found: " +
            (found != null ? found.getName() + " $" + found.getPrice() : "NOT FOUND"));
        found = null;
        //Reset found.
        //Test Call - updatePrice().
        log.updatePrice("Milk", 1.99);
        found = log.findItemByName("Milk");
        System.out.println("Looked up 'Milk', found: " +
            (found != null ? found.getName() + " $" + found.getPrice() : "NOT FOUND"));

        //Test Call - printDailyReport().
        log.printDailyReport();

        // ---- Sample data to load into the Checkout Line ----
        Customer[] sampleCustomers = {
            new Customer("Alvarez", 12),
            new Customer("Chen", 3),
            new Customer("Patel", 27),
            new Customer("O'Brien", 1)
        };

        CheckoutLine line = new CheckoutLine();
        for (Customer c : sampleCustomers) {
            line.addToBack(c);
        }

        System.out.println("Checkout Line loaded, size = " + line.size());

        // Example test call - addToFront (O'Brien has 1 item, gets waved to the front).
        Customer express = new Customer("Nguyen", 1);
        System.out.println("Waving " + express.getName() + " to the front...");
        line.addToFront(express);

        //Move O'Brien infront of Nyugen, since he has 1 item and already in the line.
        line.addToFront(line.removeFromBack());

        System.out.println("Serving " + line.removeFromFront().getName() + " from the front of the line.");

        System.out.println("Customoer " + line.removeFromBack().getName() + " has left the back of the line.");

        System.out.println("Checkout Line size after tests: " + line.size());
    }*/

public static void main(String[] args) {
        long startTime, endTime, duration;
        // Test cases for PurchaseLog and CheckoutLine can be added here.
        //Test 1, PurchaseLogs
        PurchaseLog log = new PurchaseLog();
        CheckoutLine queue = new CheckoutLine();

        PurchaseItem[] sampleItems = {
            new PurchaseItem("Bread", 3.49),
            new PurchaseItem("Milk", 2.99),
            new PurchaseItem("Eggs", 4.29),
            new PurchaseItem("Coffee", 8.99),
            new PurchaseItem("Bananas", 1.29),
            new PurchaseItem("Cereal", 4.79),
            new PurchaseItem("Chicken Breast", 9.99),
            new PurchaseItem("Paper Towels", 6.49),
            new PurchaseItem("Bread", 3.49),
            new PurchaseItem("Milk", 2.99),
            new PurchaseItem("Eggs", 4.29),
            new PurchaseItem("Coffee", 8.99),
            new PurchaseItem("Bananas", 1.29),
            new PurchaseItem("Cereal", 4.79),
            new PurchaseItem("Chicken Breast", 9.99),
            new PurchaseItem("Paper Towels", 6.49)
        };

        for (PurchaseItem item : sampleItems) {
            log.addItem(item);
        }
        startTime = System.nanoTime();
        for (int i = 0; i < 250; i++) {
            log.findItemByName("Bread");
            log.findItemByName("Milk");
            log.findItemByName("Eggs");
            log.findItemByName("Bananas");
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Time taken for 250 ArrayList lookups: " + duration + " nanoseconds");

        startTime = System.nanoTime();
        for (int i = 0; i < 250; i++) {
            log.findItemByNameTest("Bread");
            log.findItemByNameTest("Milk");
            log.findItemByNameTest("Eggs");
            log.findItemByNameTest("Bananas");
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Time taken for 250 LinkedList lookups: " + duration + " nanoseconds");

        Customer[] sampleCustomers = {
            new Customer("Alvarez", 12),
            new Customer("Chen", 3),
            new Customer("Patel", 27),
            new Customer("O'Brien", 1)
        };
        for (Customer c : sampleCustomers) {
            queue.addToBack(c);
        }
        startTime = System.nanoTime();
        for (int i = 0; i < 250; i++) {
            queue.addToFront(sampleCustomers[0]);
            queue.addToFront(sampleCustomers[1]);
            queue.addToFront(sampleCustomers[2]);
            queue.addToFront(sampleCustomers[3]);      
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Time taken for 1000 addToFronts: " + duration + " nanoseconds");

        startTime = System.nanoTime();
        for (int i = 0; i < 250; i++) {
            queue.addToFrontTest(sampleCustomers[0]);
            queue.addToFrontTest(sampleCustomers[1]);
            queue.addToFrontTest(sampleCustomers[2]);
            queue.addToFrontTest(sampleCustomers[3]);      
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Time taken for 1000 addToFronts: " + duration + " nanoseconds");        
    }
}
