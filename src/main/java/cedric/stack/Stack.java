package cedric.stack;

public interface Stack<E> {
    void push(E element);

    E pop();

    int size();

    boolean isEmpty();
}
