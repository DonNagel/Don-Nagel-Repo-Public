public interface InClassOne<E> {
//List interface, for In Class work. <E> shows that it is a geneneric type interfac and can be any type.
    //void add(int index, E element);
    // Java does not like E, so we have to tell it that it's a generic type.
    boolean add(E element);

    void add(int index, E element);

    boolean contains(Object o);

    E set(int index, E element);

    int indexOf(Object o);

    E get(int index);

    int lastIndexOf(Object o);

    E remove(int index);
    boolean remove(Object o);

    int size();
}
