/*
 * Exercise 6.4 - Display the number of days of a month, which is entered by users (both month and year)
 * Lab01 - Java Environment Setup and Basics
 * Vu Anh Minh - 20194626
 */
import java.util.Scanner;

public class DaysInMonth {
    private static final String[] FULL_NAMES = {
        "january", "february", "march", "april", "may", "june",
        "july", "august", "september", "october", "november", "december"
    };

    private static final String[] ABBREVIATIONS = {
        "jan.", "feb.", "mar.", "apr.", "may", "june",
        "july", "aug.", "sept.", "oct.", "nov.", "dec."
    };

    private static final String[] THREE_LETTERS = {
        "jan", "feb", "mar", "apr", "may", "jun",
        "jul", "aug", "sep", "oct", "nov", "dec"
    };

    private static final int[] COMMON_YEAR_DAYS = {
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    /**
     * Accepts a month as a full name, an abbreviation, three letters, or a
     * number. Returns the month number 1-12, or -1 when the text matches none.
     */
    private static int parseMonth(String text) {
        String value = text.trim().toLowerCase();
        if (value.isEmpty()) {
            return -1;
        }

        for (int i = 0; i < 12; i++) {
            if (value.equals(FULL_NAMES[i])
                    || value.equals(ABBREVIATIONS[i])
                    || value.equals(THREE_LETTERS[i])) {
                return i + 1;
            }
        }

        if (isAllDigits(value)) {
            int number = Integer.parseInt(value);
            if (number >= 1 && number <= 12) {
                return number;
            }
        }
        return -1;
    }

    /**
     * The year must be written out in full digits, so "1999" is accepted while
     * "99" as a shorthand for 1999 is not. Returns -1 for anything invalid.
     */
    private static int parseYear(String text) {
        String value = text.trim();
        if (!isAllDigits(value) || value.length() != 4) {
            return -1;
        }
        return Integer.parseInt(value);
    }

    private static boolean isAllDigits(String value) {
        if (value.isEmpty()) {
            return false;
        }
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int month;
        do {
            System.out.print("Month (name, abbreviation, or number): ");
            if (!input.hasNextLine()) {
                return;
            }
            month = parseMonth(input.nextLine());
            if (month == -1) {
                System.out.println("Invalid month. Examples: January, Jan., Jan, 1");
            }
        } while (month == -1);

        int year;
        do {
            System.out.print("Year (all digits, e.g. 1999): ");
            if (!input.hasNextLine()) {
                return;
            }
            year = parseYear(input.nextLine());
            if (year == -1) {
                System.out.println("Invalid year. Enter every digit, e.g. 1999 instead of 99.");
            }
        } while (year == -1);

        int days = COMMON_YEAR_DAYS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            days = 29;
        }

        System.out.println(FULL_NAMES[month - 1].substring(0, 1).toUpperCase()
                + FULL_NAMES[month - 1].substring(1)
                + " " + year + " has " + days + " days.");
    }
}
