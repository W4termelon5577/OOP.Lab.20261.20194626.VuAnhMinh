/*
 * Exercise 2.2.5 - Calculate sum, difference, product, and quotient of 2 double numbers entered by users
 * Lab01 - Java Environment Setup and Basics
 * Vu Anh Minh - 20194626
 */
import java.util.Scanner;

public class ArithmeticTwoDoubles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        if (!input.hasNextDouble()) {
            System.out.println("Invalid first number.");
            return;
        }
        double first = input.nextDouble();
        if (!input.hasNextDouble()) {
            System.out.println("Invalid second number.");
            return;
        }
        double second = input.nextDouble();

        System.out.println("Sum = " + (first + second));
        System.out.println("Difference = " + (first - second));
        System.out.println("Product = " + (first * second));
        if (second == 0.0) {
            System.out.println("Quotient = undefined (division by zero)");
        } else {
            System.out.println("Quotient = " + (first / second));
        }
    }
}
