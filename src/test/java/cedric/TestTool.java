package cedric;

import java.util.Random;

public class TestTool {
    static Random random = new Random();

    public static int[] getRandomIntArray(int N) {
        int[] ret = new int[N];
        for (int i = 0; i < N; i++)
            ret[i] = random.nextInt();
        return ret;
    }

    public static int getRandomInt() {
        return random.nextInt();
    }
    // end is exclusive
    public static int getRandomInt(int start, int end) {
        return random.nextInt(end - start) + start;
    }

    // end is exclusive
    public static int getRandomInt(int end) {
        return random.nextInt(end);
    }
}
