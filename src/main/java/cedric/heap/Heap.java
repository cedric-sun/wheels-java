package cedric.heap;

import cedric.list.ArrayList;

import java.util.Comparator;

public class Heap<E> {
    Comparator<E> comp;
    ArrayList<E> heapArray;
    int K;

    public Heap(int K, Comparator<E> comp) {
        this.K = K;
        this.comp = comp;
        heapArray = new ArrayList<>();
    }

    public void add(E element) {
        heapArray.add(element);
        siftUp(heapArray.size() - 1);
    }

    public E pop() {
        if (heapArray.isEmpty())
            return null;
        E ret = heapArray.get(0);
        heapArray.set(0, heapArray.get(heapArray.size() - 1));
        heapArray.remove(heapArray.size() - 1);
        siftDown(0);
        return ret;
    }

    public E peek() {
        if (heapArray.isEmpty())
            return null;
        return heapArray.get(0);
    }

    public boolean isEmpty() {
        return heapArray.isEmpty();
    }

    public int size() {
        return heapArray.size();
    }

    private void siftDown(int root) {
        while (true) {
            int maxIdx = root;
            for (int i = 0; i < K; i++) {
                int child = child(root, i);
                if (child >= heapArray.size())
                    break;
                if (comp.compare(heapArray.get(child), heapArray.get(maxIdx)) > 0)
                    maxIdx = child;
            }
            if (maxIdx != root) {
                swap(maxIdx, root);
                root = maxIdx;
            } else {
                break;
            }
        }
    }

    private void siftUp(int node) {
        int parent = parent(node);
        while (parent >= 0 && comp.compare(heapArray.get(node), heapArray.get(parent)) > 0) {
            swap(node, parent);
            node = parent;
            parent = parent(node);
        }
    }

    private void swap(int i, int j) {
        E tmp = heapArray.get(i);
        heapArray.set(i, heapArray.get(j));
        heapArray.set(j, tmp);
    }

    private int parent(int node) {
        return Math.floorDiv(node - 1, K);
    }

    private int child(int root, int i) {
        return root * K + i + 1;
    }
}
