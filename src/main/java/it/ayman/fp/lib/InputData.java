package it.ayman.fp.lib;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The class <strong>InputData</strong> can read a specific data type inserted
 * in input by the user.It also allows the possibility to make controls on the
 * data inserted.
 *
 * @author Alessandro Muscio
 * @version 1.0
 */
public final class InputData {
    private static final Scanner reader = createScanner();
    private static final String COMMAND_INPUT = "> ";
    private static final String RED_ATTENTION = AnsiColors.RED + "Attention!" + AnsiColors.RESET;
    private static final String ALPHANUMERIC_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
    private static final String ALPHANUMERIC_CHARACTERS_ERROR = COMMAND_INPUT + RED_ATTENTION
            + "\nOnly alphanumeric characters are allowed.";
    private static final String EMPTY_STRING_ERROR = COMMAND_INPUT + RED_ATTENTION + "\n"
            + COMMAND_INPUT + "No characters were inserted.";
    private static final String ALLOWED_CHARACTERS_ERROR = COMMAND_INPUT + RED_ATTENTION + "\n"
            + COMMAND_INPUT + "The only allowed characters are: %s";
    private static final String INTEGER_FORMAT_ERROR = COMMAND_INPUT + RED_ATTENTION
            + "\n" + COMMAND_INPUT + "The inserted data is in a incorrect format. An integer is required.";
    private static final String DOUBLE_FORMAT_ERROR = COMMAND_INPUT + RED_ATTENTION
            + "\n" + COMMAND_INPUT + "The inserted data is in a incorrect format. A double is required.";
    private static final String MINIMUM_ERROR_INTEGER = COMMAND_INPUT + RED_ATTENTION + "\n"
            + COMMAND_INPUT + "A value greater or equal than %d is required.";
    private static final String MAXIMUM_ERROR_INTEGER = COMMAND_INPUT + RED_ATTENTION + "\n"
            + COMMAND_INPUT + "A value less or equal than %d is required.";
    private static final String MINIMUM_ERROR_DOUBLE = COMMAND_INPUT + RED_ATTENTION + "\n"
            + COMMAND_INPUT + "A value greater or equal than %.2f is required.";
    private static final String MAXIMUM_ERROR_DOUBLE = COMMAND_INPUT + RED_ATTENTION + "\n"
            + COMMAND_INPUT + "A value less or equal than %.2f is required.";
    private static final String INVALID_ANSWER = RED_ATTENTION + "The answer is invalid!";
    private InputData() {
        throw new UnsupportedOperationException();
    }

    /**
     * Methods that creates a <code>Scanner</code> object.
     *
     * @return A <code>Scanner</code> object.
     */
    private static Scanner createScanner() {
        return new Scanner(System.in);
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
                System.out.print(COMMAND_INPUT + message + " ");

                read = reader.next();
                read = read.trim();

                isAlphanumeric = hasAlphanumericCharacters(read);

                if (!isAlphanumeric)
                    System.out.println(ALPHANUMERIC_CHARACTERS_ERROR);
            } while (!isAlphanumeric);
        } else {
            System.out.print(COMMAND_INPUT + message + " ");

            read = reader.next();
            read = read.trim();
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
    public static String readNonEmptyString(String message, boolean alphanumeric) {
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
            read = readNonEmptyString(message, false);

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
     * the user, it will take the first <code>char</code> in it.
     *
     * @param message The message to print.
     * @return A <code>char</code> representing the character tha was read.
     */
    public static char readChar(String message) {
        String read;

        read = readNonEmptyString(message, false);

        return read.charAt(0);
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
        question = question + " [Y/n] ";

        String answer = readNonEmptyString(question, true).toUpperCase();

        if (answer.equals("Y") || answer.equals("YES"))
            return true;
        else if (answer.equals("N") || answer.equals("NO"))
            return false;
        else
            return readYesOrNo(INVALID_ANSWER + "\n" + question);
    }

    private static void flushReader() {
        reader.nextLine();
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
                System.out.print(COMMAND_INPUT + message + " ");

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
            read = readInteger(COMMAND_INPUT + message + " ");

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
            read = readInteger(COMMAND_INPUT + message + " ");

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
            System.out.print(COMMAND_INPUT + message + " ");

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
            read = readDouble(COMMAND_INPUT + message + " ");

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
            read = readDouble(COMMAND_INPUT + message + " ");

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
            read = readDouble(COMMAND_INPUT + message + " ");

            if (read < min)
                System.out.printf(MINIMUM_ERROR_DOUBLE + "\n", min);
            else if (read > max)
                System.out.printf(MAXIMUM_ERROR_DOUBLE + "\n", max);
            else
                isBetweenMinMax = true;
        } while (!isBetweenMinMax);

        return read;
    }
}