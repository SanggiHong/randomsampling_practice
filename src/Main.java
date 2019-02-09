import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final int X_MAXIMUM = 30000;
        final int Y_MAXIMUM = 30000;
        final double SAMPLING_RATIO = 0.2;

        int[] data = generatePatiallyDenseData(X_MAXIMUM, Y_MAXIMUM);

        int sample_count = (int) ((double) X_MAXIMUM * Y_MAXIMUM * SAMPLING_RATIO);
        Random xRand = new Random(System.currentTimeMillis());
        Random yRand = new Random(System.currentTimeMillis());

        int sum = 0;
        for (int i = 0; i < sample_count; i++) {
            int x = xRand.nextInt(X_MAXIMUM);
            int y = yRand.nextInt(Y_MAXIMUM);
            if (data[x] >= y)
                sum++;
        }

        int result = (int) (sum / SAMPLING_RATIO);

        System.out.println("estimate :: " + result);
        System.out.println("answer :: " + Arrays.stream(data).sum());
    }

    private static int[] generatePatiallyDenseData(int xMax, int yMax) {
        Random dataGen = new Random(System.currentTimeMillis());
        int start = dataGen.nextInt(xMax);
        int end = dataGen.nextInt(xMax);

        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        int[] data = new int[xMax];

        for (int i = start; i < end; i++) {
            data[i] = dataGen.nextInt(yMax);
        }

        return data;
    }
}
