/*
 * Exercise 6.6 - Add two matrices of the same size
 * Lab01 - Java Environment Setup and Basics
 * Vu Anh Minh - 20194626
 */
import java.util.Scanner;

public class MatrixAddition {
    private static int readDimension(Scanner input, String prompt) {
        System.out.print(prompt);
        if (!input.hasNextInt()) {
            return -1;
        }
        return input.nextInt();
    }

    private static double[][] readMatrix(Scanner input, String name, int rows, int columns) {
        double[][] matrix = new double[rows][columns];
        System.out.println("Enter matrix " + name + " row by row:");
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (!input.hasNextDouble()) {
                    return null;
                }
                matrix[row][column] = input.nextDouble();
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows = readDimension(input, "Rows (1-20): ");
        int columns = readDimension(input, "Columns (1-20): ");
        if (rows < 1 || rows > 20 || columns < 1 || columns > 20) {
            System.out.println("Dimensions must be between 1 and 20.");
            return;
        }

        double[][] first = readMatrix(input, "A", rows, columns);
        double[][] second = readMatrix(input, "B", rows, columns);
        if (first == null || second == null) {
            System.out.println("Invalid matrix value.");
            return;
        }

        System.out.println("A + B:");
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                System.out.print((first[row][column] + second[row][column]) + " ");
            }
            System.out.println();
        }
    }
}
