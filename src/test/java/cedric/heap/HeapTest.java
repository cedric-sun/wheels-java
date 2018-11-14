package cedric.heap;

import cedric.TestTool;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {
    @Test
    public void simpleTest() {
        int N = 10000;
        Heap<Integer> integerHeap = new Heap<>(2, Integer::compareTo);
        int[] data = TestTool.getRandomIntArray(N);
        for (int i : data)
            integerHeap.add(i);
        int prev = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int top = integerHeap.pop();
            assertTrue(prev >= top);
            prev = top;
        }
        assertTrue(integerHeap.isEmpty());
    }
}