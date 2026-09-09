import java.util.Arrays;

public class InClassArrayList<E> implements InClassOne<E> {
    //The class will be red until we actually implement the interface.
    private E[] data;

    public InClassArrayList() {
        data = (E[]) new Object[0];
        //Because we cannot createa generic type, we need to make it an object array and then cast it to the correct type.
    }
    @Override
    public void add(int index, E element) {
            if (index > size()) { // Check for valid index. We can add it to the last size index because we can add the extra length needed.
                throw new IndexOutOfBoundsException();
            }
            // Resize the array.
            data = Arrays.copyOf(data, data.length+1);
            //Copy data by shifting elements to the right. Makes room for the new element. 
            for (int i = data.length -1; i > index; i--) {
                data[i] = data[i-1];
            }
            // Insert the element
            data[index] = element;
    }
    @Override
    public boolean add(E element) { // O(n)
        //1. Resize the array, it's currently size 0. O(n).
        data = Arrays.copyOf(data, data.length+1);
        //2. Insert the data. O(1).
        data[data.length-1] = element;

        return true;
    }
    @Override
    public E set(int index, E element) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        //Store the previous data.
        E previous = data[index];
        //Set.
        data[index] = element;
        //Return old
        return previous;
    }
    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size(); i++) {
            if(data[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public E get(int index) {
        return data[index];
    }
    public boolean contains(Object o) {
        for(int i = 0; i < size(); i++) {
            if(data[i].equals(o)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int lastIndexOf(Object o) {
        for(int i = size()-1; i>=0; i--) {
            if(data[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if(index > size()-1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        //Save the value
        E value = data[index];
        //Shift elements
        for(int i = index; i < size()-1;i++) {
            data[i] = data[i+1];
        }
        //Resize
        data = Arrays.copyOf(data, data.length-1);
        return value;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if(index == -1) {
            return false;
        }else {
            remove(index);
            return true;
        }
    }

    @Override
    public int size() { //O(1).
        return data.length;
    }
}
