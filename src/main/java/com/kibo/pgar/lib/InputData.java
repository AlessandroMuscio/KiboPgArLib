package com.kibo.pgar.lib;

import java.util.*;

/**
* @author Mattia Tognela
 *
 * 
* Is a little class for delivering input functionality to the dev.
*
* It Was created for let me input stuff with easy in my Java project.
 */

public class InputData {
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
    private static final String INVALID_ANSWER = COMMAND_INPUT + RED_ATTENTION + "\n"
            + COMMAND_INPUT + "The answer is not valid!";


    private static Scanner createScanner() {
        return new Scanner(System.in).useDelimiter("\n");
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
        System.out.printf("%s -> ", message);
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
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @return it returns a not empty String form the method scanner.nextline().trim();
     */

    public static String readStringNotEmpty(String message) {
        while (true) {
            String lettura = readSting(message).trim();

            if (!lettura.isEmpty()) return lettura;
            else System.out.println(EMPTY_STRING_ERROR);
        }
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

    public static String readEmptyNotString(String message, boolean alphanumeric) {
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
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @return it returns character form the method scanner.nexline().atChar(0);
     */

    public static char readChar(String message) {
        while (true) {
            System.out.printf("%s -> ", message);

            String valoreLetto = reader.nextLine();

            if (valoreLetto.length() == 1) return valoreLetto.charAt(0);
            else System.out.println(ERROR_STRING_LENGHT_NOT_ONE);
        }
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
            read = readEmptyNotString(message,);

            readChar = read.charAt(0);

            if (allowed.indexOf(readChar) != -1)
                isAllowed = true;
            else
                System.out.printf(ALLOWED_CHARACTERS_ERROR + "\n", Arrays.toString(allowed.toCharArray()));
        } while (!isAllowed);

        return readChar;
    }


    /**
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @return it returns character form the list of possible characters
     */

    public static char readCharUpper(String message, String possible) {
        while (true) {
            char valoreLetto = Character.toUpperCase(readChar(message));

            if (possible.indexOf(valoreLetto) != -1) return valoreLetto;
            else System.out.printf("%s %s\n", MESSAGE_POSSIBLE_CHARACTERS, possible);
        }
    }

    /**
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     *
     * @return an int
     */

    public static int readInt(String message) {
        while (true) {
            System.out.printf("%s -> ", message);
            try {
                return reader.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(ERROR_FORMAT);
                reader.next();
            }
        }
    }

    /**
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     *
     * @return an int more or equal than 1
     */

    public static int readIntPos(String message) {
        return readIntMin(message, 1);
    }

    /**
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     *
     * @return an int more or equal than 0
     */

    public static int readIntNotNeg(String message) {
        return readIntMin(message, 0);
    }

    /**
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @param min let you define a min val under then the input is not acceptable
     *
     * @return an int more or equal than min
     */

    public static int readIntMin(String message, int min) {
        while (true) {
            int valoreLetto = readInt(message);

            if (valoreLetto >= min) return valoreLetto;
            else System.out.printf("%s %+d\n", ERROR_MIN, min);
        }
    }

    /**
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @param min let you define a min val under then the input is not acceptable
     * @param max let you define a min val over then the input is not acceptable
     *
     * @return an int between min and max
     */


    public static int readIntMinMax(String message, int min, int max) {
        while (true) {
            int valoreLetto = readInt(message);

            if (valoreLetto >= min && valoreLetto <= max) return valoreLetto;
            else if (valoreLetto < min) System.out.printf("%s %+d\n", ERROR_MIN, min);
            else System.out.printf("%s %+d\n", ERROR_MAX, max);
        }
    }

    /**
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     *
     * @return a double
     */

    public static double readDouble(String message) {
        while (true) {
            System.out.printf("%s -> ", message);
            try {
                return reader.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println(ERROR_MIN);
                reader.next();
            }
        }
    }

    /**
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     *
     * @return a double more or equal than 1
     */

    public static double readDoublePos(String message) {
        return readDoubleMin(message, 1);
    }

    /**
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     *
     * @return a double more or equal than 0
     */

    public static double readDoubleNotNeg(String message) {
        return readDoubleMin(message, 0);
    }

    /**
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @param min let you define a min val under then the input is not acceptable
     *
     * @return a double over min
     */

    public static double readDoubleMin(String message, double min) {
        while (true) {
            double valoreLetto = readDouble(message);

            if (valoreLetto >= min) return valoreLetto;
            else System.out.printf("%s %+.2f\n", ERROR_MIN, min);
        }
    }

    /**
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @param min let you define a min val under then the input is not acceptable
     * @param max let you define a min val over then the input is not acceptable
     *
     * @return a double between min and max
     */

    public static double readDoubleMinMax(String message, double min, double max) {
        while (true) {
            double valoreLetto = readDouble(message);

            if (valoreLetto >= min && valoreLetto <= max) return valoreLetto;
            else if (valoreLetto < min) System.out.printf("%s %+d\n", ERROR_MIN, min);
            else System.out.printf("%s %+d\n", ERROR_MAX, max);
        }
    }

    /**
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     *
     * @return a boolean
     */

    public static boolean yesOrNo(String message) {
        return readCharUpper(String.format("%s (%s/%s) -> ", message, YES, NO), String.format("%c%c", YES, NO)) == YES;
    }
}
