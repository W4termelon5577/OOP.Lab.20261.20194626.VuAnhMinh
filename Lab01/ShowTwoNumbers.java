/*
 * Exercise 2.2.4 - Show two entered numbers and their sum
 * Lab01 - Java Environment Setup and Basics
 * Vu Anh Minh - 20194626
 */
import javax.swing.JOptionPane;

public class ShowTwoNumbers {
    public static void main(String[] args) {
        String firstText = JOptionPane.showInputDialog(null, "Enter the first number:");
        if (firstText == null) {
            System.exit(0);
        }
        String secondText = JOptionPane.showInputDialog(null, "Enter the second number:");
        if (secondText == null) {
            System.exit(0);
        }

        try {
            int first = Integer.parseInt(firstText.trim());
            int second = Integer.parseInt(secondText.trim());
            JOptionPane.showMessageDialog(null,
                    "First number: " + first
                    + "\nSecond number: " + second
                    + "\nSum: " + (first + second));
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Please enter whole numbers only.");
        }
        System.exit(0);
    }
}
