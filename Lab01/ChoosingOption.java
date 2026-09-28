/*
 * Exercise 6.1 - Write, compile and run the ChoosingOption program
 * Lab01 - Java Environment Setup and Basics
 * Vu Anh Minh - 20194626
 */
import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        Object[] options = {"Yes", "No", "Cancel"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Do you want to continue?",
                "Choose an option",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == 0) {
            System.out.println("You chose Yes.");
        } else if (choice == 1) {
            System.out.println("You chose No.");
        } else {
            System.out.println("You cancelled or closed the dialog.");
        }
    }
}
