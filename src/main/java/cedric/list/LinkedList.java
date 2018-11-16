package cedric.list;

public class LinkedList<E> {
    class Node {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
        }
    }

    class Iterator {
        private Node curNode;

        public Iterator() {
            curNode = LinkedList.this.head;
        }

        public E next() {
            curNode = curNode.next;
            return curNode.data;
        }

        public boolean hasNext() {
            return curNode.next != null;
        }

        public void reset() {
            curNode = LinkedList.this.head;
        }
    }

    int size;
    Node head, tail;

    public LinkedList() {
        tail = head = new Node(null);
    }

    public Iterator iterator() {
        return new Iterator();
    }

    public void add(E element) {
        Node newNode = new Node(element);
        tail.next = newNode;
        tail = newNode;
        ++size;
    }

    public boolean add(int index, E element) {
        Node prevNode = nodeGet(index - 1);
        if (prevNode == null)
            return false;
        Node newNode = new Node(element);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        ++size;
        return true;
    }

    public E get(int index) {
        Node node = nodeGet(index);
        if (node == null)
            return null;
        return node.data;
    }

    public E remove(int index) {
        Node prevNode = nodeGet(index - 1);
        if (prevNode == null)
            return null;
        E ret = prevNode.next.data;
        prevNode.next = prevNode.next.next;
        return ret;
    }

    private Node nodeGet(int index) {
        if (index == -1)
            return head;
        if (index >= size || index < 0)
            return null;
        Node ret = head;
        for (int i = 0; i <= index; i++)
            ret = ret.next;
        return ret;
    }
}