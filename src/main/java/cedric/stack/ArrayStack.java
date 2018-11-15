package cedric.stack;

import cedric.list.ArrayList;

public class ArrayStack<E> implements Stack<E> {
    ArrayList<E> stackArrayList;

    public ArrayStack() {
        stackArrayList = new ArrayList<>();
    }

    @Override
    public void push(E element) {
        stackArrayList.add(element);
    }

    @Override
    public E pop() {
        return stackArrayList.remove(stackArrayList.size() - 1);
    }

    @Override
    public int size() {
        return stackArrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return stackArrayList.isEmpty();
    }
}
