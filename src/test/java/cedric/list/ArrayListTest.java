package cedric.list;

import cedric.TestTool;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {

    public ArrayList<Integer> getRandomIntegerArrayList(int N) {
        int[] data = TestTool.getRandomIntArray(N);
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (int i : data)
            integerArrayList.add(i);
        return integerArrayList;
    }

    @Test
    public void size() {
        int N = 10000;
        ArrayList<Integer> tmp = getRandomIntegerArrayList(N);
        assertEquals(tmp.size(), N);
    }

    @Test
    public void get() {
        int N = 10000;
        int[] data = TestTool.getRandomIntArray(N);
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (int i : data)
            integerArrayList.add(i);
        for (int i = 0; i < 100; i++) {
            int randomIndex = TestTool.getRandomInt(N);
            assertEquals(data[randomIndex], (int) integerArrayList.get(randomIndex));
        }
    }

    @Test
    public void remove() {
        int N = 10000;
        ArrayList<Integer> integerArrayList = getRandomIntegerArrayList(N);
        for (int i = 0; i < 100; i++) {
            int randomIndex = TestTool.getRandomInt(N - i);
            assertTrue(integerArrayList.remove(randomIndex));
        }
    }

    @Test
    public void isEmpty() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        assertTrue(stringArrayList.isEmpty());
    }

    @Test
    public void addTail() {
        int N = 10000;
        ArrayList<Integer> integerArrayList = getRandomIntegerArrayList(10000);
        for (int i = 0; i < 100; i++) {
            int randomValue = TestTool.getRandomInt();
            integerArrayList.add(randomValue);
            assertEquals((int) integerArrayList.get(integerArrayList.size() - 1), randomValue);
        }
    }

    @Test
    public void addArbitraryPos() {
        int N = 10000;
        ArrayList<Integer> integerArrayList = getRandomIntegerArrayList(10000);
        for (int i = 0; i < 100; i++) {
            int randomIndex = TestTool.getRandomInt(N + i - 1); // make sure the last element is not changed
            int randomValue = TestTool.getRandomInt();
            int oldLast = integerArrayList.get(integerArrayList.size() - 1);
            integerArrayList.add(randomIndex, randomValue);
            assertEquals((int) integerArrayList.get(randomIndex), randomValue);
            assertEquals(integerArrayList.size(), N + i + 1);
            int nowLast = integerArrayList.get(integerArrayList.size() - 1);
            assertEquals(oldLast, nowLast);
        }
    }

    @Test
    public void set() {
        int N = 10000;
        ArrayList<Integer> integerArrayList = getRandomIntegerArrayList(N);
        for (int i = 0; i < 100; i++) {
            int randomIndex = TestTool.getRandomInt(N);
            int randomValue = TestTool.getRandomInt();
            integerArrayList.set(randomIndex, randomValue);
            assertEquals((int) integerArrayList.get(randomIndex), randomValue);
        }
    }
}