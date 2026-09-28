/*
 * Exercise 6.2 - Write a program for input/output from keyboard
 * Lab01 - Java Environment Setup and Basics
 * Vu Anh Minh - 20194626
 */
import java.util.Scanner;

public class KeyboardInputOutput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        String name = input.nextLine().trim();
        System.out.print("Enter your age: ");
        while (!input.hasNextInt()) {
            System.out.print("Enter a whole-number age: ");
            input.next();
        }
        int age = input.nextInt();
        input.nextLine();
        System.out.print("Enter your favorite programming language: ");
        String language = input.nextLine().trim();

        System.out.println();
        System.out.println("Hello, " + (name.isEmpty() ? "student" : name) + "!");
        System.out.println("You are " + age + " years old.");
        System.out.println("You like " + (language.isEmpty() ? "programming" : language) + ".");
    }
}
