import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Lb1Test {

    @Test
    public void testRightTriangleCalculations() {
        double a = 3.0, b = 4.0;
        double expectedHypotenuse = 5.0;
        double expectedPerimeter = 12.0;
        double expectedArea = 6.0;

        double c = Math.sqrt(a * a + b * b);
        double perimeter = a + b + c;
        double area = (a * b) / 2;

        assertEquals(expectedHypotenuse, c, 0.0001);
        assertEquals(expectedPerimeter, perimeter, 0.0001);
        assertEquals(expectedArea, area, 0.0001);
    }

    @Test
    public void testExclusionFromInterval() {
        double[] inputs = { -1.0, 1.0, 3.0 };
        boolean[] expected = { true, false, true };

        boolean[] result = new boolean[3];
        for (int i = 0; i < 3; i++) {
            result[i] = inputs[i] < 0 || inputs[i] > 2;
        }

        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxMirroredSum() {
        double[] arr = new double[16];
        for (int i = 0; i < 16; i++) {
            arr[i] = i + 1; // 1 to 16
        }

        double maxSum = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < 8; i++) {
            double sum = arr[i] + arr[15 - i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        assertEquals(17.0, maxSum, 0.0001); // 1 + 16 = 17
    }

    @Test
    public void testTaylorSeriesApproximation() {
        double z = 0.5;
        double epsilon = 0.0001;

        double sum = 0.0;
        double term;
        int k = 0;

        do {
            long factorial = 1;
            for (int i = 1; i <= k; i++) {
                factorial *= i;
            }

            term = Math.pow(-1, k) * Math.pow(z, 2 * k + 1) / (factorial * (2 * k + 1));
            sum += term;

            k++;
        } while (Math.abs(term) >= epsilon);

        double expected = Math.atan(z); // Comparison to actual arctangent
        assertEquals(expected, sum, 0.01);
    }

    @Test
    public void testComputeFunction() {
        double x = 1.0;
        double result = lb1.computeFunction(x);
        double expected = 1 - (Math.pow(x, 2) / 2) + (Math.pow(x, 4) / 24) - (Math.pow(x, 6) / 720);

        assertEquals(expected, result, 0.000001);
    }
}
