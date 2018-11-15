package cedric.heap;

import cedric.TestTool;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeftistHeapTest {

    <E> boolean dfs(LeftistHeap<E>.Node root) {
        if (root == null)
            return true;
        if (root.rightChild == null)
            return dfs(root.leftChild);
        if (root.leftChild == null)
            return false;
        if (root.leftChild.s < root.rightChild.s)
            return false;
        if (root.s != root.rightChild.s + 1)
            return false;
        return dfs(root.leftChild) && dfs(root.rightChild);
    }

    @Test
    public void simpleTest() {
        int N = 10000;
        LeftistHeap<Integer> integerLeftistHeap = new LeftistHeap<>(Integer::compareTo);
        int[] data = TestTool.getRandomIntArray(N);
        for (int i : data)
            integerLeftistHeap.add(i);
        assertTrue(dfs(integerLeftistHeap.root));
        int prev = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int cur = integerLeftistHeap.pop();
            assertTrue(prev >= cur);
            prev = cur;
        }
        assertTrue(integerLeftistHeap.isEmpty());
    }
}