/*
 * Exercise 2.2.6 - Solve a linear equation, a system of two linear equations, and a quadratic equation
 * Lab01 - Java Environment Setup and Basics
 * Vu Anh Minh - 20194626
 */
import java.util.Scanner;

public class EquationSolver {
    private static final double EPS = 1e-10;

    private static boolean zero(double value, double scale) {
        return Math.abs(value) <= EPS * Math.max(1.0, scale);
    }

    private static double read(Scanner input, String prompt) {
        System.out.print(prompt);
        while (!input.hasNextDouble()) {
            System.out.print("Please enter a valid number: ");
            input.next();
        }
        return input.nextDouble();
    }

    private static void solveLinear(Scanner input) {
        double a = read(input, "a = ");
        double b = read(input, "b = ");
        if (zero(a, 1.0)) {
            System.out.println(zero(b, 1.0) ? "Every real number is a solution." : "No solution.");
        } else {
            System.out.println("x = " + (-b / a));
        }
    }

    private static void solveSystem(Scanner input) {
        System.out.println("Solve: a*x + b*y = c and d*x + e*y = f");
        double a = read(input, "a = ");
        double b = read(input, "b = ");
        double c = read(input, "c = ");
        double d = read(input, "d = ");
        double e = read(input, "e = ");
        double f = read(input, "f = ");

        double determinant = a * e - b * d;
        double scale = Math.max(Math.abs(a * e), Math.abs(b * d));
        if (!zero(determinant, scale)) {
            System.out.println("x = " + ((c * e - b * f) / determinant));
            System.out.println("y = " + ((a * f - c * d) / determinant));
            return;
        }

        double minor1 = a * f - c * d;
        double minor2 = b * f - c * e;
        boolean consistent = zero(minor1, Math.max(Math.abs(a * f), Math.abs(c * d)))
                && zero(minor2, Math.max(Math.abs(b * f), Math.abs(c * e)));
        System.out.println(consistent ? "Infinitely many solutions." : "No solution.");
    }

    private static void solveQuadratic(Scanner input) {
        double a = read(input, "a = ");
        double b = read(input, "b = ");
        double c = read(input, "c = ");

        if (zero(a, 1.0)) {
            if (zero(b, 1.0)) {
                System.out.println(zero(c, 1.0) ? "Every real number is a solution." : "No solution.");
            } else {
                System.out.println("This is linear: x = " + (-c / b));
            }
            return;
        }

        double discriminant = b * b - 4.0 * a * c;
        double scale = Math.max(b * b, Math.abs(4.0 * a * c));
        if (zero(discriminant, scale)) {
            System.out.println("One real root: x = " + (-b / (2.0 * a)));
        } else if (discriminant > 0.0) {
            double root = Math.sqrt(discriminant);
            System.out.println("x1 = " + ((-b + root) / (2.0 * a)));
            System.out.println("x2 = " + ((-b - root) / (2.0 * a)));
        } else {
            System.out.println("No real roots.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Equation Solver");
        System.out.println("1. Linear equation a*x + b = 0");
        System.out.println("2. Two equations in x and y");
        System.out.println("3. Quadratic equation a*x^2 + b*x + c = 0");
        System.out.print("Choose 1, 2, or 3: ");
        if (!input.hasNextInt()) {
            System.out.println("Invalid choice.");
            return;
        }
        int choice = input.nextInt();
        switch (choice) {
            case 1: solveLinear(input); break;
            case 2: solveSystem(input); break;
            case 3: solveQuadratic(input); break;
            default: System.out.println("Invalid choice.");
        }
    }
}
