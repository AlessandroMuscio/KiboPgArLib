package com.kibo.pgar.lib;

import java.io.File;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputData {
    private static final Scanner reader = createScanner();
    private static final String UNSUPPORTED_OP_ERR_MSG = String
            .format("%sThis class isn't instantiable!%s", AnsiColors.RED, AnsiColors.RESET);

    private static final String RED_ATTENTION = PrettyStrings.prettify("Attention!", AnsiColors.RED, null, null);

    private static final String ALPHANUMERIC_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
    private static final String ALPHANUMERIC_CHARACTERS_ERROR = PrettyStrings.prettify(
            "\nOnly alphanumeric characters are allowed.", AnsiColors.RED, null, null);
    private static final String EMPTY_STRING_ERROR = PrettyStrings.prettify(
            "\nNo characters were inserted.", AnsiColors.RED, null, null);
    private static final String ALLOWED_CHARACTERS_ERROR = PrettyStrings.prettify(
            "\nThe only allowed characters are: %s", AnsiColors.RED, null, null);
    private static final String INTEGER_FORMAT_ERROR = PrettyStrings.prettify(
            "\nThe inserted data is in an incorrect format. An integer is required.", AnsiColors.RED, null, null);
    private static final String DOUBLE_FORMAT_ERROR = PrettyStrings.prettify(
            "\nThe inserted data is in an incorrect format. A double is required.", AnsiColors.RED, null, null);
    private static final String MINIMUM_ERROR_INTEGER = PrettyStrings.prettify(
            "\nA value greater or equal than %d is required.", AnsiColors.RED, null, null);
    private static final String MAXIMUM_ERROR_INTEGER = PrettyStrings.prettify(
            "\nA value less or equal than %d is required.", AnsiColors.RED, null, null);
    private static final String MINIMUM_ERROR_DOUBLE = PrettyStrings.prettify(
            "\nA value greater or equal than %.2f is required.", AnsiColors.RED, null, null);
    private static final String MAXIMUM_ERROR_DOUBLE = PrettyStrings.prettify(
            "\nA value less or equal than %.2f is required.", AnsiColors.RED, null, null);
    private static final String INVALID_ANSWER = PrettyStrings.prettify(
            "\nThe answer is not valid!", AnsiColors.RED, null, null);


    public InputData() throws UnsupportedOperationException {
        throw new UnsupportedOperationException(InputData.UNSUPPORTED_OP_ERR_MSG);
    }

    private static void flushReader() { reader.nextLine(); }

    private static Scanner createScanner() {
        // Check if the code is being executed from Eclipse
        if (isEclipseEnvironment()) {
            // If running in Eclipse, use System.lineSeparator() as the delimiter
            return new Scanner(System.in).useDelimiter(System.lineSeparator());
        } else {
            // If not running in Eclipse, use "\n" as the delimiter
            return new Scanner(System.in).useDelimiter("\n");
        }
    }

    /**
     * Determines if the code is being executed within an Eclipse environment.<br><br>
     *
     * This method checks for the presence of the <code>.project</code> file and <code>.settings</code> directory
     * in the current working directory, which are standard indicators of an Eclipse project.<br><br>
     *
     * @return <code>true</code> if the code is running in Eclipse, <code>false</code> otherwise.
     */

    private static boolean isEclipseEnvironment() {
        File projectFile = new File(".project");
        File settingsDir = new File(".settings");
        return projectFile.exists() && settingsDir.exists();
    }

    /**
     * Verifies if the given message has only alphanumeric characters.
     *
     * @param message The message to verify.
     * @return A <code>boolean</code> representing if the message is alphanumeric or
     * not.
     */

    
    private static boolean hasAlphanumericCharacters(String message) {
        char currentChar;

        for (int i = 0; i < message.length(); i++) {
            currentChar = message.charAt(i);

            if (ALPHANUMERIC_CHARACTERS.indexOf(currentChar) == -1)
                return false;
        }

        return true;
    }

    /**
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @return A <code>String</code> form the method <code>reader.nextLine()</code>;
     */

    public static String readSting(String message) {
        System.out.printf("%s ", message);
        return reader.nextLine();
    }

    /**
     * Prints <code>message</code> in the terminal and reads the text inserted by
     * the user. If it isn't a <code>String</code> an error message is printed. It's
     * also possible to select if the inserted text needs to be alphanumeric or not.
     *
     * @param message      The message to print.
     * @param alphanumeric If the input needs to be alphanumeric or not.
     * @return A <code>String</code> representing the user input.
     */

    public static String readString(String message, boolean alphanumeric) {
        boolean isAlphanumeric;
        String read;

        if (alphanumeric) {
            do {
                System.out.printf("%s ", message);

                read = reader.next().trim();

                isAlphanumeric  = hasAlphanumericCharacters(read); //AlphanumericChecker.hasAlphanumericCharacters(message);

                if (!isAlphanumeric)
                    System.out.println(ALPHANUMERIC_CHARACTERS_ERROR);
            } while (!isAlphanumeric);
        } else {
            System.out.printf("%s ", message);

            read = reader.next().trim();
        }

        return read;
    }

    /**
     * Prints <code>message</code> in the terminal and reads the text inserted by
     * the user, given that it isn't empty. If it isn't a <code>String</code> an
     * error message is printed. It's also possible to select if the inserted text
     * needs to be alphanumeric or not.
     *
     * @param message      The message to print.
     * @param alphanumeric If the input needs to be alphanumeric or not.
     * @return A <code>String</code> representing the user input.
     */

    public static String readStringNotEmpty(String message, boolean alphanumeric) {
        boolean isStringEmpty = true;
        String read;

        do {
            read = readString(message, alphanumeric);
            isStringEmpty = read.isBlank();

            if (isStringEmpty)
                System.out.println(EMPTY_STRING_ERROR);
        } while (isStringEmpty);

        return read;
    }

    /**
     * Prints <code>message</code> in the terminal and reads the text inserted by
     * the user. It will take the first <code>char</code> in it and verify if it is
     * in the <code>allowed</code> characters, if not, an error message will be
     * printed.
     *
     * @param message The message to print.
     * @param allowed All the allowed characters.
     * @return A <code>char</code> representing the character tha was read.
     */

    public static char readChar(String message, String allowed) {
        boolean isAllowed = false;
        String read;
        char readChar;

        do {
            read = readStringNotEmpty(message, false);

            readChar = read.charAt(0);

            if (allowed.indexOf(readChar) != -1)
                isAllowed = true;
            else
                System.out.printf(ALLOWED_CHARACTERS_ERROR + "\n", Arrays.toString(allowed.toCharArray()));
        } while (!isAllowed);

        return readChar;
    }

    /**
     * Prints <code>message</code> in the terminal and reads the text inserted by
     * the user. It will print an error message if the text inserted isn't an
     * integer.
     *
     * @return An <code>int</code> representing the integer that was read.
     */

    public static int readInteger(String message) {
        boolean isInteger;
        int read = 0;

        do {
            try {
                System.out.printf("%s ", message);

                read = reader.nextInt();

                isInteger = true;
            } catch (InputMismatchException e) {
                System.out.println(INTEGER_FORMAT_ERROR);

                isInteger = false;
            } finally {
                flushReader();
            }
        } while (!isInteger);

        return read;
    }

    /**
     * Prints <code>message</code> in the terminal and reads the text inserted by
     * the user. It will print an error message if the text inserted isn't an
     * integer or if the integer inserted is greater equal than <code>min</code>.
     *
     * @param message The message to print.
     * @param min     The minimum value to read.
     * @return An <code>int</code> representing the integer that was read.
     */

    public static int readIntegerWithMinimum(String message, int min) {
        boolean isAboveMin = false;
        int read;

        do {
            read = readInteger(message);

            if (read >= min)
                isAboveMin = true;
            else
                System.out.printf(MINIMUM_ERROR_INTEGER + "\n", min);
        } while (!isAboveMin);

        return read;
    }

    /**
     * Prints <code>message</code> in the terminal and reads the text inserted by
     * the user. It will print an error message if the text inserted isn't an
     * integer or if the integer inserted is less equal than <code>max</code>.
     *
     * @param message The message to print.
     * @param max     The maximum value to read.
     * @return An <code>int</code> representing the integer that was read.
     */

    public static int readIntegerWithMaximum(String message, int max) {
        boolean isBelowMax = false;
        int read;

        do {
            read = readInteger(message);

            if (read <= max)
                isBelowMax = true;
            else
                System.out.printf(MAXIMUM_ERROR_INTEGER + "\n", max);
        } while (!isBelowMax);

        return read;
    }

    /**
     * Prints <code>message</code> in the terminal and reads the text inserted by
     * the user. It will print an error message if the text inserted isn't an
     * integer or if the integer inserted isn't between or equal than
     * <code>min</code> and <code>max</code>.
     *
     * @param message The message to print.
     * @param min     The minimum value to read.
     * @param max     The maximum value to read.
     * @return An <code>int</code> representing the integer that was read.
     */

    public static int readIntegerBetween(String message, int min, int max) {
        boolean isBetweenMinMax = false;
        int read;

        do {
            read = readInteger(message);

            if (read < min)
                System.out.printf(MINIMUM_ERROR_INTEGER + "\n", min);
            else if (read > max)
                System.out.printf(MAXIMUM_ERROR_INTEGER + "\n", max);
            else
                isBetweenMinMax = true;
        } while (!isBetweenMinMax);

        return read;
    }

    /**
     * Prints <code>message</code> in the terminal and reads the text inserted by
     * the user. It will print an error message if the text inserted isn't a double.
     *
     * @param message The message to print.
     * @return A <code>double</code> representing the double that was read.
     */

    public static double readDouble(String message) {
        boolean isDouble;
        double read = Double.NaN;

        do {
            System.out.printf("%s ", message);

            try {
                read = reader.nextDouble();
                isDouble = true;
            } catch (InputMismatchException e) {
                System.out.println(DOUBLE_FORMAT_ERROR);

                isDouble = false;
            } finally {
                flushReader();
            }
        } while (!isDouble);

        return read;
    }


    /**
     * Prints <code>message</code> in the terminal and reads the text inserted by
     * the user. It will print an error message if the text inserted isn't a double
     * or if the double inserted isn't greater equal than <code>min</code>.
     *
     * @param message The message to print.
     * @param min     The minimum value to read.
     * @return A <code>double</code> representing the double that was read.
     */

    public static double readDoubleWithMinimum(String message, double min) {
        boolean isAboveMin = false;
        double read;

        do {
            read = readDouble(message);

            if (read >= min)
                isAboveMin = true;
            else
                System.out.printf(MINIMUM_ERROR_DOUBLE + "\n", min);
        } while (!isAboveMin);

        return read;
    }

    /**
     * Prints <code>message</code> in the terminal and reads the text inserted by
     * the user. It will print an error message if the text inserted isn't a double
     * or if the double inserted isn't less equal than <code>max</code>.
     *
     * @param message The message to print.
     * @param max     The maximum value to read.
     * @return An <code>double</code> representing the double that was read.
     */

    public static double readDoubleWithMaximum(String message, double max) {
        boolean isBelowMax = false;
        double read;

        do {
            read = readDouble(message);

            if (read <= max)
                isBelowMax = true;
            else
                System.out.printf(MAXIMUM_ERROR_DOUBLE + "\n", max);
        } while (!isBelowMax);

        return read;
    }

    /**
     * Prints <code>message</code> in the terminal and reads the text inserted by
     * the user. It will print an error message if the text inserted isn't an double
     * or if the double inserted isn't between or equal than <code>min</code> and
     * <code>max</code>.
     *
     * @param message The message to print.
     * @param min     The minimum value to read.
     * @param max     The maximum value to read.
     * @return An <code>double</code> representing the double that was read.
     */

    public static double readDoubleBetween(String message, double min, double max) {
        boolean isBetweenMinMax = false;
        double read;

        do {
            read = readDouble(message);

            if (read < min)
                System.out.printf(MINIMUM_ERROR_DOUBLE + "\n", min);
            else if (read > max)
                System.out.printf(MAXIMUM_ERROR_DOUBLE + "\n", max);
            else
                isBetweenMinMax = true;
        } while (!isBetweenMinMax);

        return read;
    }


    /**
     * Prints <code>question</code> in the terminal with the string "? [Y/n] "
     * added. If the user answers with 'y' or 'Y' the method will return
     * <code>true</code>, <code>false</code> otherwise.
     *
     * @param question The question to print.
     * @return A <code>boolean</code> representing the affirmative or negative
     * answer of the user.
     */

    public static boolean readYesOrNo(String question) {
        String answer = readStringNotEmpty(question + " [Y/n]", true);

        if (answer.equals("Y") || answer.equals("YES"))
            return true;
        else if (answer.equals("N") || answer.equals("NO"))
            return false;
        else {
            System.out.println(INVALID_ANSWER);
            return readYesOrNo(question);
        }
    }
}