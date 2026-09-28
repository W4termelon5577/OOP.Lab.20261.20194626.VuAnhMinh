/*
 * Exercise 6.3 - Display a triangle with a height of n stars, n is entered by users
 * Lab01 - Java Environment Setup and Basics
 * Vu Anh Minh - 20194626
 */
import java.util.Scanner;

public class StarTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Number of rows (1-100): ");
        while (!input.hasNextInt()) {
            System.out.print("Please enter a whole number (1-100): ");
            input.next();
        }
        int rows = input.nextInt();
        while (rows < 1 || rows > 100) {
            System.out.print("Rows must be between 1 and 100. Try again: ");
            while (!input.hasNextInt()) {
                System.out.print("Please enter a whole number (1-100): ");
                input.next();
            }
            rows = input.nextInt();
        }

        for (int row = 1; row <= rows; row++) {
            for (int space = 0; space < rows - row; space++) {
                System.out.print(" ");
            }
            for (int star = 0; star < 2 * row - 1; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
