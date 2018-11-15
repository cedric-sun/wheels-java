package cedric.heap;

import java.util.Comparator;

//todo: unit test
public class LeftistHeap<E> {
    // could be static class?
    class Node {
        E data;
        Node leftChild, rightChild;
        int s = 1;

        public Node(E data) {
            this.data = data;
        }
    }

    Node root;
    Comparator<E> comp;
    int size;

    public LeftistHeap(Comparator<E> comp) {
        this.comp = comp;
    }

    public void add(E element) {
        Node newNode = new Node(element);
        root = mergeNode(root, newNode);
        ++size;
    }

    public E pop() {
        if (root == null)
            return null;
        E ret = root.data;
        root = mergeNode(root.leftChild, root.rightChild);
        --size;
        return ret;
    }

    public E peek() {
        if (root == null)
            return null;
        return root.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean merge(LeftistHeap<E> anotherLeftistTree) {
        // could be comp.equals() ?
        if (comp != anotherLeftistTree.comp)
            return false;
        mergeNode(root, anotherLeftistTree.root);
        size += anotherLeftistTree.size;
        return true;
    }

    // merge two Node even their outer class instance are not the same object
    private Node mergeNode(Node a, Node b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (comp.compare(a.data, b.data) < 0) {
            Node tmp = a;
            a = b;
            b = tmp;
        }
        a.rightChild = mergeNode(a.rightChild, b);
        if (a.leftChild == null) {
            a.leftChild = a.rightChild;
            a.rightChild = null;
        } else {
            if (a.leftChild.s < a.rightChild.s) {
                Node tmp = a.leftChild;
                a.leftChild = a.rightChild;
                a.rightChild = tmp;
            }
            a.s = a.rightChild.s + 1;
        }
        return a;
    }
}
