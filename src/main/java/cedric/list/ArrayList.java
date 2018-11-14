package cedric.list;

public class ArrayList<E> {
    private E[] array;
    private int size;
    public static final int DEFAULT_INIT_CAP = 0xff;  //255

    public ArrayList() {
        array = (E[]) new Object[DEFAULT_INIT_CAP];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        if (index >= size || index < 0)
            return null;
        return array[index];
    }

    public void add(E element) {
        if (size >= array.length)
            extendArray();
        array[size++] = element;
    }

    public boolean add(int index, E element) {
        if (size >= array.length)
            extendArray();
        if (index > size || index < 0)
            return false;
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        ++size;
        return true;
    }

    public boolean set(int index, E element) {
        if (index >= size || index < 0)
            return false;
        array[index] = element;
        return true;
    }

    public E remove(int index) {
        if (index >= size || index < 0)
            return null;
        E ret = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        --size;
        return ret;
    }

    private void extendArray() {
        E[] extendedArray = (E[]) new Object[array.length << 1];
        System.arraycopy(array, 0, extendedArray, 0, array.length);
        array = extendedArray;
    }
}
