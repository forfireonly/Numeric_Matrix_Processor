package processor;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int choice;
    static double[][] createMatrix(int rows, int columns, Scanner scn) {

        double[][] matrix = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scn.nextDouble();
            }
            scn.nextLine();
        }
        return matrix;
    }

    static boolean checkChoice (Scanner scn) {
        choice = scn.nextInt();
        boolean isCorrectChoice = false;
        if (choice == 1  || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6) {
            isCorrectChoice = true;
        } else if (choice == 0) {
            System.exit(0);
        } else {
            System.out.println("Bad input!");
        }
        return isCorrectChoice;
    }

    public static void main(String[] args) {
        boolean isKeepGoing = true;

        while (isKeepGoing) {
            System.out.print("1. Add matrices\n" +
                    "2. Multiply matrix to a constant\n" +
                    "3. Multiply matrices\n" +
                    "4. Transpose matrix\n" +
                    "5. Calculate a determinant\n" +
                    "6. Inverse matrix\n" +
                    "0. Exit\n" +
                    "Your choice: ");

            Scanner scn = new Scanner(System.in);
            boolean isCorrectChoice = false;

            while (!isCorrectChoice) {
                isCorrectChoice = checkChoice(scn);
            }

            switch (choice) {
                case 1:

                    scn.nextLine();
                    System.out.print("Enter size of first matrix: ");
                    int rowsFirstMatrix = scn.nextInt();
                    int columnsFirstMatrix = scn.nextInt();
                    System.out.println("Enter first matrix:");
                    double[][] firstMatrix = createMatrix(rowsFirstMatrix, columnsFirstMatrix, scn);
                    Matrix firstMatrixObject = new Matrix(rowsFirstMatrix, columnsFirstMatrix, firstMatrix);
                    System.out.print("Enter size of second matrix: ");
                    int rowsSecondtMatrix = scn.nextInt();
                    int columnsSecondMatrix = scn.nextInt();
                    System.out.println("Enter second matrix:");
                    double [][] secondMatrix = createMatrix(rowsSecondtMatrix, columnsSecondMatrix, scn);
                    Matrix secondMatrixObject = new Matrix(rowsSecondtMatrix, columnsSecondMatrix, secondMatrix);
                    if (Matrix.compareMatrices(firstMatrixObject, secondMatrixObject)) {
                        Matrix additionMatrix = Matrix.add(firstMatrixObject, secondMatrixObject);
                        additionMatrix.rows = firstMatrixObject.rows;
                        additionMatrix.columns = firstMatrixObject.columns;
                        System.out.println("The result is:");
                        System.out.print(additionMatrix);
                    } else {
                        System.out.println("ERROR");
                    }
                    break;

                case 2:

                    rowsFirstMatrix = scn.nextInt();
                    columnsFirstMatrix = scn.nextInt();
                    firstMatrix = createMatrix(rowsFirstMatrix, columnsFirstMatrix, scn);
                    firstMatrixObject = new Matrix(rowsFirstMatrix, columnsFirstMatrix, firstMatrix);
                    double numberToMultiply = scn.nextDouble();
                    Matrix multipliedMatrix = firstMatrixObject.multiplyByNumber(numberToMultiply);
                    System.out.println("The result is:");
                    System.out.print(multipliedMatrix);
                    break;

                case 3:
                    System.out.print("Enter size of first matrix: ");
                    rowsFirstMatrix = scn.nextInt();
                    columnsFirstMatrix = scn.nextInt();
                    System.out.println("Enter first matrix:");
                    firstMatrix = createMatrix(rowsFirstMatrix, columnsFirstMatrix, scn);
                    firstMatrixObject = new Matrix(rowsFirstMatrix, columnsFirstMatrix, firstMatrix);
                    System.out.print("Enter size of second matrix: ");
                    rowsSecondtMatrix = scn.nextInt();
                    columnsSecondMatrix = scn.nextInt();
                    System.out.println("Enter second matrix:");
                    secondMatrix = createMatrix(rowsSecondtMatrix, columnsSecondMatrix, scn);
                    secondMatrixObject = new Matrix(rowsSecondtMatrix, columnsSecondMatrix, secondMatrix);
                    if (Matrix.compareMatricesForMultiplication(firstMatrixObject, secondMatrixObject)) {
                        Matrix multiplicationMatrix = Matrix.multiplyMatrices(firstMatrixObject, secondMatrixObject);
                        multiplicationMatrix.rows = firstMatrixObject.rows;
                        multiplicationMatrix.columns = secondMatrixObject.columns;
                        System.out.println("The result is:");
                        System.out.print(multiplicationMatrix);
                    } else {
                        System.out.println("ERROR");
                    }

                    break;

                case 4:

                    isCorrectChoice = false;
                    System.out.print("1. Main diagonal\n" +
                            "2. Side diagonal\n" +
                            "3. Vertical line\n" +
                            "4. Horizontal line\n" +
                            "Your choice: ");
                    do {
                        isCorrectChoice = checkChoice(scn);
                    }
                    while(!isCorrectChoice);
                    System.out.print("Enter matrix size: ");
                    rowsFirstMatrix = scn.nextInt();
                    columnsFirstMatrix = scn.nextInt();
                    System.out.print("Enter matrix: ");
                    firstMatrix = createMatrix(rowsFirstMatrix, columnsFirstMatrix, scn);
                    firstMatrixObject = new Matrix(rowsFirstMatrix, columnsFirstMatrix, firstMatrix);
                    switch (choice) {
                        case 1:
                            Matrix transposedMatrix = Matrix.mainDiagonalTranspose(firstMatrixObject);
                            transposedMatrix.rows = firstMatrixObject.columns;
                            transposedMatrix.columns = firstMatrixObject.rows;
                            System.out.println("The result: ");
                            System.out.print(transposedMatrix);
                            break;

                        case 2:
                            transposedMatrix = Matrix.horizontalTranspose(firstMatrixObject);
                            transposedMatrix.rows = firstMatrixObject.rows;
                            transposedMatrix.columns = firstMatrixObject.columns;
                            Matrix transposedSideMatrix = Matrix.mainDiagonalTranspose(transposedMatrix);
                            transposedSideMatrix.rows = transposedMatrix.columns;
                            transposedSideMatrix.columns = transposedMatrix.rows;
                            transposedMatrix = Matrix.horizontalTranspose(transposedSideMatrix);
                            transposedMatrix.rows = transposedSideMatrix.rows;
                            transposedMatrix.columns = transposedSideMatrix.columns;
                            System.out.println("The result: ");
                            System.out.print(transposedMatrix);
                            break;

                        case 3:

                            transposedMatrix = Matrix.verticalTranspose(firstMatrixObject);
                            transposedMatrix.rows = firstMatrixObject.rows;
                            transposedMatrix.columns = firstMatrixObject.columns;
                            System.out.println("The result: ");
                            System.out.print(transposedMatrix);
                            break;


                        case 4:

                            transposedMatrix = Matrix.horizontalTranspose(firstMatrixObject);
                            transposedMatrix.rows = firstMatrixObject.rows;
                            transposedMatrix.columns = firstMatrixObject.columns;
                            System.out.println("The result: ");
                            System.out.print(transposedMatrix);
                            break;

                        default:
                    }

                    break;

                case 5:
                    rowsFirstMatrix = scn.nextInt();
                    columnsFirstMatrix = scn.nextInt();
                    if (rowsFirstMatrix != columnsFirstMatrix) {
                        System.out.println("Not square matrix");
                    } else {
                        firstMatrix = createMatrix(rowsFirstMatrix, columnsFirstMatrix, scn);
                        firstMatrixObject = new Matrix(rowsFirstMatrix, columnsFirstMatrix, firstMatrix);
                        System.out.println("The result: ");
                        System.out.println(Matrix.determinant(firstMatrixObject.matrix, rowsFirstMatrix));

                    }

                    break;

                case 6:
                    System.out.print("Enter size of first matrix: ");
                    rowsFirstMatrix = scn.nextInt();
                    columnsFirstMatrix = scn.nextInt();
                    System.out.println("Enter first matrix:");
                    firstMatrix = createMatrix(rowsFirstMatrix, columnsFirstMatrix, scn);
                    InverseMatrix object = new InverseMatrix();
                    object.setN(rowsFirstMatrix);
                    double [][]adj = new double[rowsFirstMatrix][columnsFirstMatrix]; // To store adjoint of A[][]
                    double [][]inv = new double[rowsFirstMatrix][columnsFirstMatrix];
                    System.out.println("The result: ");
                    if (InverseMatrix.inverse(firstMatrix, inv))
                        InverseMatrix.display(inv);

                    break;
                default:
            }
        }
    }
}
