package cedric.heap;

import cedric.TestTool;
import org.junit.Test;

import java.util.Comparator;

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
        Comparator<Integer> comp = Integer::compareTo;
        LeftistHeap<Integer> integerLeftistHeap0 = new LeftistHeap<>(comp);
        LeftistHeap<Integer> integerLeftistHeap1 = new LeftistHeap<>(comp);
        int[] data = TestTool.getRandomIntArray(N);
        for (int i : data)
            integerLeftistHeap0.add(i);
        data = TestTool.getRandomIntArray(N);
        for (int i : data)
            integerLeftistHeap1.add(i);
        assertTrue(dfs(integerLeftistHeap0.root));
        assertTrue(dfs(integerLeftistHeap1.root));
        assertTrue(integerLeftistHeap0.merge(integerLeftistHeap1));
        assertTrue(dfs(integerLeftistHeap0.root));
        int prev = Integer.MAX_VALUE;
        for (int i = 0; i < N << 1; i++) {
            int cur = integerLeftistHeap0.pop();
            assertTrue(prev >= cur);
            prev = cur;
        }
        assertTrue(integerLeftistHeap0.isEmpty());
    }
}