import java.util.Scanner;

public class lb1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1)
        System.out.print("Введіть довжини катетів a і b: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = Math.sqrt(a * a + b * b);
        double perimeter = a + b + c;
        double area = (a * b) / 2;
        System.out.println("Периметр: " + perimeter);
        System.out.println("Площа: " + area);

        // 2)
        System.out.print("Введіть три числа a, b, c: ");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        double z = scanner.nextDouble();
        System.out.print("Числа, які не належать [0,2]: ");
        if (x < 0 || x > 2) System.out.print(x + " ");
        if (y < 0 || y > 2) System.out.print(y + " ");
        if (z < 0 || z > 2) System.out.print(z + " ");
        System.out.println();

        // 4)
        double[] arr = new double[16];
        System.out.println("Введіть 16 чисел:");
        for (int i = 0; i < 16; i++) {
            arr[i] = scanner.nextDouble();
        }
        double maxSum = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < 8; i++) {
            double sum = arr[i] + arr[15 - i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        System.out.println("Максимальна сума: " + maxSum);

        // 3)
        System.out.print("Enter z (0 < z < 1): ");
        double z1 = scanner.nextDouble();

        System.out.print("Enter ε (0 < ε < 1): ");
        double epsilon = scanner.nextDouble();

        double sum = 0.0;
        double term;
        int k = 0;

        do {
            long factorial = 1;
            for (int i = 1; i <= k; i++) {
                factorial *= i;
            }

            term = Math.pow(-1, k) * Math.pow(z1, 2 * k + 1) / (factorial * (2 * k + 1));
            sum += term;

            k++;
        } while (Math.abs(term) >= epsilon);

        System.out.println("Approximated sum: " + sum);

        // 5)
        System.out.println(" x  |  f(x)");
        System.out.println("----------------");

        for (double xValue = 0; xValue <= 6; xValue += 0.5) {
            double result = computeFunction(xValue);
            System.out.printf("%.1f | %.6f%n", xValue, result);
        }

        scanner.close();
    }


    public static double computeFunction(double x) {
        return 1 - (Math.pow(x, 2) / 2) + (Math.pow(x, 4) / 24) - (Math.pow(x, 6) / 720);
    }
}
