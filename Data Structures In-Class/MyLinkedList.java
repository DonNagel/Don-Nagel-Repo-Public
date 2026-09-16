public class MyLinkedList<E> implements InClassOne<E> {
    private Node<E> head;
    private Node<E> tail;
    //Make sure to document & keep track of what length is when adding/removing.
    private int length;

    public MyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    @Override
    public boolean add(E element) {
        if (head == null) {
            Node<E> node = new Node<>(element);
            this.head = node;
            this.tail = node;
            length++;
            return true;
        } else {
            //Node<E> currentNode = head;
            //while (currentNode.next != null) {
            //    currentNode = currentNode.next;
            //}
            Node<E> node = new Node<>(element);
            //currentNode.next = node;
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
    @Override 
    public E remove(int index) {
        E returnVal = null;
        if(index == 0) {
            if(head != null) {
                returnVal = head.data;
                head = head.next;
                //Head is moved from the old node to the next node.
                length--;
                head.prev.next = null;
                //Old node is disconnected from moving to the new node.
                head.prev = null;
                //New head node now no longer points to the old node.
            }
        } else if (index == size()-1) {
            // Implementation for removing the last node
            returnVal = tail.data;
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        } else if (index > 0 && index < size()-1) {
            Node<E> currentNode = head;
            //Iterate to the node before the one to remove.
            //Store the data from the node to remove.
            //node.next; = node.next.next; removes the removed node from the next chain.
            //From ^ we can also remove the nodeToBeRemoved's pointer.
            //node.next.prev = node;
            for(int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
                //Sets us to the node right before the nodeToBeRemoved.
            }
            returnVal = currentNode.next.data;
            currentNode.next = currentNode.next.next;
            currentNode.next.prev.next = null;
            currentNode.next.prev.prev = null;
            currentNode.next.prev = currentNode;


        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        length--;
        return returnVal;
    }


    public int size() {
        return length;
    }

    private class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}
