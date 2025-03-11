public class lb2 {
    private double[][] matrix;

    public lb2(double a, double b, double c, double d) {
        matrix = new double[2][2];
        matrix[0][0] = a;
        matrix[0][1] = b;
        matrix[1][0] = c;
        matrix[1][1] = d;
    }

    public double determinant() {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public lb2 inverse() {
        double det = determinant();
        if (det == 0) {
            throw new ArithmeticException("cannot be inverted");
        }
        double invDet = 1 / det;
        return new lb2(matrix[1][1] * invDet, -matrix[0][1] * invDet,
                -matrix[1][0] * invDet, matrix[0][0] * invDet);
    }

    public lb2 multiply(lb2 other) {
        double a = this.matrix[0][0] * other.matrix[0][0] + this.matrix[0][1] * other.matrix[1][0];
        double b = this.matrix[0][0] * other.matrix[0][1] + this.matrix[0][1] * other.matrix[1][1];
        double c = this.matrix[1][0] * other.matrix[0][0] + this.matrix[1][1] * other.matrix[1][0];
        double d = this.matrix[1][0] * other.matrix[0][1] + this.matrix[1][1] * other.matrix[1][1];

        return new lb2(a, b, c, d);
    }

    public lb2 add(lb2 other) {
        return new lb2(matrix[0][0] + other.matrix[0][0], matrix[0][1] + other.matrix[0][1],
                matrix[1][0] + other.matrix[1][0], matrix[1][1] + other.matrix[1][1]);
    }

    public lb2 multiplyByScalar(double scalar) {
        return new lb2(matrix[0][0] * scalar, matrix[0][1] * scalar,
                matrix[1][0] * scalar, matrix[1][1] * scalar);
    }

    public void printMatrix() {
        System.out.println("[" + matrix[0][0] + " " + matrix[0][1] + "]");
        System.out.println("[" + matrix[1][0] + " " + matrix[1][1] + "]");
    }

    // New start method
    public void start() {
        System.out.println("lb2...");

        lb2 mat1 = new lb2(1, 2, 3, 4);
        lb2 mat2 = new lb2(5, 6, 7, 8);

        System.out.println("matrix 1:");
        mat1.printMatrix();
        System.out.println("matrix 2:");
        mat2.printMatrix();

        System.out.println("determinant of Matrix 1: " + mat1.determinant());

        System.out.println("inverse of Matrix 1:");
        mat1.inverse().printMatrix();

        System.out.println("matrix 1 * Matrix 2:");
        mat1.multiply(mat2).printMatrix();

        System.out.println("matrix 1 + Matrix 2:");
        mat1.add(mat2).printMatrix();

        System.out.println("matrix 1 * 2:");
        mat1.multiplyByScalar(2).printMatrix();
    }
}
