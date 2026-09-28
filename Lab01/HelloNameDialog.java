/*
 * Exercise 2.2.3 - Write, compile the first input dialog Java application
 * Lab01 - Java Environment Setup and Basics
 * Vu Anh Minh - 20194626
 */
import javax.swing.JOptionPane;

public class HelloNameDialog {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(null, "What is your name?");
        if (name == null) {
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Hello, " + name + "!");
        System.exit(0);
    }
}
