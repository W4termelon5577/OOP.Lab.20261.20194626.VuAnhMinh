/*
 * Exercise 6.5 - Sort a numeric array, and calculate the sum and average value of array elements
 * Lab01 - Java Environment Setup and Basics
 * Vu Anh Minh - 20194626
 */
import java.util.Arrays;
import java.util.Scanner;

public class ArrayStatistics {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many numbers (1-1000)? ");
        if (!input.hasNextInt()) {
            System.out.println("Invalid count.");
            return;
        }
        int count = input.nextInt();
        if (count < 1 || count > 1000) {
            System.out.println("Count must be between 1 and 1000.");
            return;
        }

        double[] values = new double[count];
        double sum = 0.0;
        for (int i = 0; i < count; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            if (!input.hasNextDouble()) {
                System.out.println("Invalid number.");
                return;
            }
            values[i] = input.nextDouble();
            sum += values[i];
        }

        Arrays.sort(values);
        System.out.println("Sorted values: " + Arrays.toString(values));
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + (sum / count));
    }
}
