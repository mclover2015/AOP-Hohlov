public class lb2 {
    private double[][] matrix;

    // Constructor to initialize the 2x2 matrix
    public lb2(double a, double b, double c, double d) {
        matrix = new double[2][2];
        matrix[0][0] = a;
        matrix[0][1] = b;
        matrix[1][0] = c;
        matrix[1][1] = d;
    }

    // Method to calculate the determinant of the matrix
    public double determinant() {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    // Method to calculate the inverse of the matrix
    public lb2 inverse() {
        double det = determinant();
        if (det == 0) {
            throw new ArithmeticException("Matrix is singular and cannot be inverted");
        }
        double invDet = 1 / det;
        double a = matrix[0][0];
        double b = matrix[0][1];
        double c = matrix[1][0];
        double d = matrix[1][1];

        // Creating the inverse matrix
        return new lb2(d * invDet, -b * invDet, -c * invDet, a * invDet);
    }

    // Method to multiply the matrix by another 2x2 matrix
    public lb2 multiply(lb2 other) {
        double a = this.matrix[0][0] * other.matrix[0][0] + this.matrix[0][1] * other.matrix[1][0];
        double b = this.matrix[0][0] * other.matrix[0][1] + this.matrix[0][1] * other.matrix[1][1];
        double c = this.matrix[1][0] * other.matrix[0][0] + this.matrix[1][1] * other.matrix[1][0];
        double d = this.matrix[1][0] * other.matrix[0][1] + this.matrix[1][1] * other.matrix[1][1];

        return new lb2(a, b, c, d);
    }

    // Method to add another 2x2 matrix to this one
    public lb2 add(lb2 other) {
        double a = this.matrix[0][0] + other.matrix[0][0];
        double b = this.matrix[0][1] + other.matrix[0][1];
        double c = this.matrix[1][0] + other.matrix[1][0];
        double d = this.matrix[1][1] + other.matrix[1][1];

        return new lb2(a, b, c, d);
    }

    // Method to multiply the matrix by a scalar
    public lb2 multiplyByScalar(double scalar) {
        double a = this.matrix[0][0] * scalar;
        double b = this.matrix[0][1] * scalar;
        double c = this.matrix[1][0] * scalar;
        double d = this.matrix[1][1] * scalar;

        return new lb2(a, b, c, d);
    }

    // Method to print the matrix for easier debugging and visualization
    public void printMatrix() {
        System.out.println("[" + matrix[0][0] + " " + matrix[0][1] + "]");
        System.out.println("[" + matrix[1][0] + " " + matrix[1][1] + "]");
    }

    public static void main(String[] args) {
        // Example usage
        lb2 mat1 = new lb2(1, 2, 3, 4);
        lb2 mat2 = new lb2(5, 6, 7, 8);

        System.out.println("Matrix 1:");
        mat1.printMatrix();
        System.out.println("Matrix 2:");
        mat2.printMatrix();

        // Determinant of mat1
        System.out.println("Determinant of Matrix 1: " + mat1.determinant());

        // Inverse of mat1
        System.out.println("Inverse of Matrix 1:");
        mat1.inverse().printMatrix();

        // Matrix multiplication
        System.out.println("Matrix 1 * Matrix 2:");
        mat1.multiply(mat2).printMatrix();

        // Matrix addition
        System.out.println("Matrix 1 + Matrix 2:");
        mat1.add(mat2).printMatrix();

        // Scalar multiplication
        System.out.println("Matrix 1 * 2:");
        mat1.multiplyByScalar(2).printMatrix();
    }
}
