package cedric.queue;

public interface Deque<E> {
    boolean isEmpty();

    int size();

    void pushBack(E element);

    void pushFront(E element);

    E popFront();

    E peekFront();

    E popBack();

    E peekBack();
}
