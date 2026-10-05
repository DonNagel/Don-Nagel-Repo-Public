package Assignment2;
import java.util.LinkedList;
import java.util.ArrayList;

public class CheckoutLine {
    private LinkedList<Customer> line;
    private ArrayList<Customer> lineTest; //Alt type test
    // TODO: declare the field that stores your Customer records.
    // Decide: ArrayList<Customer> or LinkedList<Customer>?

    public CheckoutLine() {
        this.line = new LinkedList<Customer>();
        this.lineTest = new ArrayList<Customer>();
    }
    public void addToBack(Customer c) {
        line.addLast(c);
    }

    public void addToFront(Customer c) {
        line.addFirst(c);
   
    }
    public void addToFrontTest(Customer c) {
        lineTest.add(0, c); //Alt type test.
    }

    public Customer removeFromFront() {
        return line.removeFirst();
    }

    public Customer removeFromBack() {
        return line.removeLast();
    }

    public int size() {
        return line.size();
    }
}
