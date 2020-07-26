package processor;

import java.util.Formatter;

public class Matrix {
    int rows;
    int columns;
    double[][] matrix;
    Matrix(int rows, int columns, double[][] matrix) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = matrix;
    }



    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Matrix() {

    }

    static void display(double A[][], int N)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.printf("%6.4f ",A[i][j]);
            System.out.println();
        }
    }


    // Function to get adjoint of A[N][N] in adj[N][N].
    static double[][] adjoint(double[][] A, double [][]adj, int N)
    {
        if (N == 1)
        {
            adj[0][0] = 1;
            return A;
        }

        // temp is used to store cofactors of A[][]
        int sign = 1;
        double [][]temp = new double[N][N];

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                // Get cofactor of A[i][j]
                getCofactor(A, temp, i, j, N);

                // sign of adj[j][i] positive if sum of row
                // and column indexes is even.
                sign = ((i + j) % 2 == 0)? 1: -1;

                // Interchanging rows and columns to get the
                // transpose of the cofactor matrix
                adj[j][i] = (sign)*(determinant(temp, N-1));
            }
        }
        return adj;
    }

    static double determinant(double A[][], int n)
    {
        double D = 0; // Initialize result

        // Base case : if matrix contains single element
        if (n == 1)
            return A[0][0];

        double [][]temp = new double[n][n]; // To store cofactors

        int sign = 1; // To store sign multiplier

        // Iterate for each element of first row
        for (int f = 0; f < n; f++)
        {
            // Getting Cofactor of A[0][f]
            getCofactor(A, temp, 0, f, n);
            D += sign * A[0][f] * determinant(temp, n - 1);

            // terms are to be added with alternate sign
            sign = -sign;
        }

        return D;
    }

    // Function to get cofactor of A[p][q] in temp[][]. n is current
// dimension of A[][]
    static void getCofactor(double[][] A, double[][] temp, int p, int q, int n)
    {
        int i = 0, j = 0;

        // Looping for each element of the matrix
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {
                // Copying into temporary matrix only those element
                // which are not in given row and column
                if (row != p && col != q)
                {
                    temp[i][j++] = A[row][col];

                    // Row is filled, so increase row index and
                    // reset col index
                    if (j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    public static boolean compareMatrices(Matrix one, Matrix two) {
        return one.rows == two.rows && one.columns == two.columns;
    }

    public static Matrix add (Matrix one, Matrix two) {
        Matrix matrixAddition = new Matrix();
        matrixAddition.matrix = new double[one.rows][one.columns];
        for (int i = 0; i < one.rows; i++) {
            for (int j = 0; j < one.columns; j++) {
                matrixAddition.matrix[i][j] = one.matrix[i][j] + two.matrix[i][j];
            }
        }
        return matrixAddition;
    }

    public Matrix multiplyByNumber (double number) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = matrix[i][j] * number;
            }
        }
        return new Matrix(rows, columns, matrix);
    }

    public static boolean compareMatricesForMultiplication(Matrix one, Matrix two) {
        return one.columns == two.rows;
    }

    public static Matrix multiplyMatrices(Matrix one, Matrix two) {
        Matrix matrixMultiplication = new Matrix();
        matrixMultiplication.matrix = new double[one.rows][two.columns];
        for (int i = 0; i < one.rows; i++) {
            for (int j = 0; j < two.columns; j++) {
                for (int k = 0; k < one.columns; k++) {
                    matrixMultiplication.matrix[i][j] += one.matrix[i][k] * two.matrix[k][j];
                }
            }
        }
        return matrixMultiplication ;
    }

    public static Matrix mainDiagonalTranspose(Matrix one) {
        Matrix matrixDiagonalTranspose = new Matrix();
        matrixDiagonalTranspose.matrix = new double[one.columns][one.rows];
        for (int i = 0; i < one.columns; i++) {
            for (int j = 0; j < one.rows; j++) {
                matrixDiagonalTranspose.matrix[i][j] = one.matrix[j][i];
            }
        }
        return matrixDiagonalTranspose;
    }

    public static Matrix verticalTranspose(Matrix one) {
        Matrix verticalTransposed = new Matrix();
        verticalTransposed.matrix = new double[one.rows][one.columns];
        for (int i = 0; i < one.rows; i++) {
            for (int j = 0; j < one.columns; j++) {
                verticalTransposed.matrix[i][j] = one.matrix[i][one.columns - 1  - j];
            }
        }
        return verticalTransposed;

    }

    public static Matrix horizontalTranspose(Matrix one) {
        Matrix horisontalTransposed = new Matrix();
        horisontalTransposed.matrix = new double[one.rows][one.columns];
        for (int i = 0; i < one.rows; i++) {
            if (one.columns >= 0)
                System.arraycopy(one.matrix[one.rows - 1 - i], 0, horisontalTransposed.matrix[i], 0, one.columns);
        }
        return horisontalTransposed;
    }

    @Override
    public  String toString() {
        StringBuilder matrixString = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrixString.append(matrix[i][j]).append(" ");
            }
            matrixString.append("\n");
        }
        return String.valueOf(matrixString);
    }
}
