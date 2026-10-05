package Assignment2;

public class TestCases {
    public void main(String[] args) {
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
