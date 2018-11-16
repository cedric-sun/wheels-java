package cedric.list;

import cedric.TestTool;
import com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void addAndIterator() {
        int N = 10000;
        int[] data = TestTool.getRandomIntArray(N);
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        for (int i : data)
            integerLinkedList.add(i);
        LinkedList<Integer>.Iterator it = integerLinkedList.iterator();
        int i = 0;
        while (it.hasNext()) {
            assertEquals(data[i++], (int) it.next());
        }
        assertEquals(10000, i);
    }


    @Test
    public void addMiddle() {
        int N = 10000;
        int[] data = TestTool.getRandomIntArray(N);
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        for (int i : data)
            integerLinkedList.add(i);
        for (int i = N - 1; i >= 0; i--)
            assertTrue(integerLinkedList.add(0, data[i]));
        LinkedList<Integer>.Iterator it0 = integerLinkedList.iterator();
        LinkedList<Integer>.Iterator itMid = integerLinkedList.iterator();
        for (int i = 0; i < N; i++)
            itMid.next();
        for (int i = 0; i < N; i++)
            assertEquals(it0.next(), itMid.next());
    }

    @Test
    public void get() {
        int N = 10000;
        int[] data = TestTool.getRandomIntArray(N);
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        for (int i : data)
            integerLinkedList.add(i);
        for (int i = 0; i < N; i++)
            assertEquals(data[i], (int) integerLinkedList.get(i));
    }

    @Test
    public void remove() {
        int N = 10000;
        int[] data = TestTool.getRandomIntArray(N);
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        for (int i : data)
            integerLinkedList.add(i);
        for (int i = 0; i < N; i++)
            assertEquals(data[i], (int) integerLinkedList.remove(0));
    }
}