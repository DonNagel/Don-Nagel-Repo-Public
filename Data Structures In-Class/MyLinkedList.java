public class MyLinkedList<E> implements InClassOne<E> {
    private Node<E> head;
    //Make sure to document & keep track of what length is when adding/removing.
    private int length;

    public MyLinkedList() {
        head = null;
        length = 0;
    }

    @Override
    public boolean add(E element) {
        if (head == null) {
            Node<E> node = new Node<>(element);
            this.head = node;
            length++;
            return true;
        } else {
            Node<E> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            Node<E> node = new Node<>(element);
            currentNode.next = node;
            length++;
            return true;
        }
    }

    @Override
        public int indexOf(Object o) {
        Node<E> currentNode = head;
        int index = 0;
        while(currentNode != null) {
            if(currentNode.data.equals(o)) {
                return index;
            }
            else {
                currentNode = currentNode.next;
                index++;
            }

        }
        return -1;
    }


    public int size() {
        return length;
    }

    private class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
}
