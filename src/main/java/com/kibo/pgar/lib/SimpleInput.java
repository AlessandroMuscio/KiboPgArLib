package com.kibo.pgar.lib;

import java.util.*;

/*
* @author Mattia Tognela
*
* Is a little class for delivering input functionality to the dev.
*
* Was created for let me input stuff with easy in my Java project.
 */

public class SimpleInput {
    private static Scanner scanner = creaScanner();

    private final static String ERROR_FORMAT = "Warning the input given is not the correct format";
    private final static String ERROR_MIN = "Warning the input is lower than: ";
    private final static String ERROR_EMPTHY_STRING = "Warning the input is empty";
    private final static String ERROR_STRING_LENGHT_NOT_ONE = "Warning input one character";
    private final static String ERROR_MAX = "Warning the input is higher than: ";
    private final static String MESSAGE_POSSIBLE_CHARACTERS = "Warning the input characters only in this list: ";

    private final static char YES = 'Y';
    private final static char NO = 'N';


    private static Scanner creaScanner() {
        Scanner create = new Scanner(System.in);
        create.useDelimiter(System.lineSeparator());
        return create;
    }

    /*
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @return it returns a String form the method scanner.nexline();
     */

    public static String readSting(String message) {
        System.out.printf("%s -> ", message);
        return scanner.nextLine();
    }

    /*
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @return it returns a not empthy String form the method scanner.nexline().trim();
     */

    public static String readStringNotEmpthy(String message) {
        while (true) {
            String lettura = readSting(message).trim();

            if (!lettura.isEmpty()) return lettura;
            else System.out.println(ERROR_FORMAT);
        }
    }

    /*
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @return it returns character form the method scanner.nexline().atChar(0);
     */

    public static char readChar(String message) {
        while (true) {
            System.out.printf("%s -> ", message);

            String valoreLetto = scanner.nextLine();

            if (valoreLetto.length() == 1) return valoreLetto.charAt(0);
            else System.out.println(ERROR_STRING_LENGHT_NOT_ONE);
        }
    }

    /*
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

    /*
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @param fromSting if true it will convert an int from a String red with the method scanner.nextLine;
     *        if false it will read an int with the method scanner.nextInt;
     *
     * @return an int
     */

    public static int readInt(String message, boolean fromSting) {
        while (true) {
            System.out.printf("%s -> ", message);
            try {
                if (fromSting) return Integer.parseInt(scanner.nextLine());
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(ERROR_FORMAT);
                scanner.next();
            }
        }
    }

    /*
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @param fromSting if true it will convert an int from a String red with the method scanner.nextLine;
     *        if false it will read an int with the method scanner.nextInt;
     *
     * @return an int more or equal than 1
     */

    public static int readIntPos(String message, boolean fromSting) {
        return readIntMin(message, 1, fromSting);
    }

    /*
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @param fromSting if true it will convert an int from a String red with the method scanner.nextLine;
     *        if false it will read an int with the method scanner.nextInt;
     *
     * @return an int more or equal than 0
     */

    public static int readIntNotNeg(String message, boolean fromSting) {
        return readIntMin(message, 0, fromSting);
    }

    /*
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @param min let you define a min val under then the input is not acceptable
     * @param fromSting if true it will convert an int from a String red with the method scanner.nextLine;
     *        if false it will read an int with the method scanner.nextInt;
     *
     * @return an int more or equal than min
     */

    public static int readIntMin(String message, int min, boolean fromSting) {
        while (true) {
            int valoreLetto = readInt(message, fromSting);

            if (valoreLetto >= min) return valoreLetto;
            else System.out.printf("%s %+d\n", ERROR_MIN, min);
        }
    }

    /*
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @param min let you define a min val under then the input is not acceptable
     * @param max let you define a min val over then the input is not acceptable
     * @param fromSting if true it will convert an int from a String red with the method scanner.nextLine;
     *        if false it will read an int with the method scanner.nextInt;
     *
     * @return an int between min and max
     */


    public static int readIntMinMax(String message, int min, int max, boolean fromSting) {
        while (true) {
            int valoreLetto = readInt(message, fromSting);

            if (valoreLetto >= min && valoreLetto <= max) return valoreLetto;
            else if (valoreLetto < min) System.out.printf("%s %+d\n", ERROR_MIN, min);
            else System.out.printf("%s %+d\n", ERROR_MAX, max);
        }
    }

    /*
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @param fromSting if true it will convert a double from a String red with the method scanner.nextLine;
     *        if false it will read an int with the method scanner.nextDouble;
     *
     * @return a double
     */

    public static double readDuble(String message, boolean fromString) {
        while (true) {
            System.out.printf("%s -> ", message);
            try {
                if (fromString) return Double.parseDouble(scanner.nextLine());
                else return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println(ERROR_MIN);
                scanner.next();
            }
        }
    }

    /*
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @param fromSting if true it will convert an int from a String red with the method scanner.nextLine;
     *        if false it will read an int with the method scanner.nextInt;
     *
     * @return a double more or equal than 1
     */

    public static double readDoublePos(String message, boolean fromSting) {
        return readDoubleMin(message, 1, fromSting);
    }

    /*
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @param fromSting if true it will convert an int from a String red with the method scanner.nextLine;
     *        if false it will read an int with the method scanner.nextInt;
     *
     * @return a double more or equal than 0
     */

    public static double readDubleNotNeg(String message, boolean fromSting) {
        return readDoubleMin(message, 0, fromSting);
    }

    /*
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @param min let you define a min val under then the input is not acceptable
     * @param fromSting if true it will convert an int from a String red with the method scanner.nextLine;
     *        if false it will read an int with the method scanner.nextInt;
     *
     * @return a double over min
     */

    public static double readDoubleMin(String message, double minimo, boolean fromSting) {
        while (true) {
            double valoreLetto = readDuble(message, fromSting);

            if (valoreLetto >= minimo) return valoreLetto;
            else System.out.printf("%s %+.2f\n", ERROR_MIN, minimo);
        }
    }

    /*
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     * @param min let you define a min val under then the input is not acceptable
     * @param max let you define a min val over then the input is not acceptable
     * @param fromSting if true it will convert an int from a String red with the method scanner.nextLine;
     *        if false it will read an int with the method scanner.nextDouble;
     *
     * @return a double between min and max
     */

    public static double readDoubleMinMax(String message, double min, double max, boolean fromSting) {
        while (true) {
            double valoreLetto = readDuble(message, fromSting);

            if (valoreLetto >= min && valoreLetto <= max) return valoreLetto;
            else if (valoreLetto < min) System.out.printf("%s %+d\n", ERROR_MIN, min);
            else System.out.printf("%s %+d\n", ERROR_MAX, max);
        }
    }

    /*
     * @author Mattia Tognela
     * @param message Let you deliver a message for the user
     *
     * @return a boolean
     */

    public static boolean yesOrNo(String message) {
        return readCharUpper(String.format("%s (%s/%s) -> ", message, YES, NO), String.format("%c%c", YES, NO)) == YES;
    }
}
