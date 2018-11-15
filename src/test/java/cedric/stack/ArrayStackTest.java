package cedric.stack;

import cedric.TestTool;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackTest {

    @Test
    public void simpleTest() {
        int N = 19000;
        Stack<Integer> stringStack = new ArrayStack<>();
        int[] data = TestTool.getRandomIntArray(N);
        for (int i : data)
            stringStack.push(i);
        for (int i = N - 1; i >= 0; i--)
            assertEquals(data[i],(int)stringStack.pop());
        assertTrue(stringStack.isEmpty());
    }
}