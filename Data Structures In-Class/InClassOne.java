public interface InClassOne<E> {
//List interface, for In Class work. <E> shows that it is a geneneric type interfac and can be any type.
    //void add(int index, E element);
    // Java does not like E, so we have to tell it that it's a generic type.
    boolean add(E element);
}
