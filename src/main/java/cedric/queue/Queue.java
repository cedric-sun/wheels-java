package cedric.queue;

public interface Queue<E> {
    boolean isEmpty();

    int size();

    void pushBack(E element);

    E pop();

    E peek();
}
