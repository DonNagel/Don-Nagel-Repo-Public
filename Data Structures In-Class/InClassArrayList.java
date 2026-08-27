import java.util.Arrays;

public class InClassArrayList<E> implements InClassOne<E> {
    //The class will be red until we actually implement the interface.
    private E[] data;

    public InClassArrayList() {
        data = (E[]) new Object[0];
        //Because we cannot createa generic type, we need to make it an object array and then cast it to the correct type.
    }
    
    @Override
    public boolean add(E element) {
        //1. Resize the array, it's currently size 0.
        data = Arrays.copyOf(data, data.length+1);
        //2. Insert the data.
        data[data.length-1] = element;

        return true;
    }
}
