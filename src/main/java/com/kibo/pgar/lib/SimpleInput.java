package com.kibo.pgar.lib;

import java.util.*;

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
        Scanner creato = new Scanner(System.in);
        creato.useDelimiter(System.lineSeparator());
        return creato;
    }

    public static String readSting(String message) {
        System.out.printf("%s -> ", message);
        return scanner.nextLine();
    }

    public static String readStringNotEmpthy(String message) {
        while(true) {
            String lettura = readSting(message).trim();

            if (!lettura.isEmpty()) return lettura;
            else System.out.println(ERROR_FORMAT);
        }
    }

    public static char readCharUpper(String message) {
        while (true) {
            System.out.printf("%s -> ", message);

            String valoreLetto = scanner.nextLine();

            if (valoreLetto.length() == 1) return  valoreLetto.charAt(0);
            else System.out.println(ERROR_STRING_LENGHT_NOT_ONE);
        }
    }

    public static char readCharUpper(String message, String possible) {
        while (true) {
            char valoreLetto = Character.toUpperCase(readCharUpper(message));

            if (possible.indexOf(valoreLetto) != -1) return valoreLetto;
            else System.out.printf("%s %s\n", MESSAGE_POSSIBLE_CHARACTERS, possible);
        }
    }

    public static int readInt(String message, boolean fromSting) {
        while (true) {
            System.out.printf("%s -> ", message);
            try {
                if (fromSting) return Integer.parseInt(scanner.nextLine());
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(ERROR_MIN);
                scanner.next();
            }
        }
    }

    public static int readIntPos(String message, boolean fromSting) {
        return readIntMin(message, 1, fromSting);
    }

    public static int readIntNotNeg(String message, boolean fromSting) {
        return readIntMin(message, 0,  fromSting);
    }

    public static int readIntMin(String message, int min, boolean fromSting) {
        while (true) {
            int valoreLetto = readInt(message, fromSting);

            if (valoreLetto >= min) return valoreLetto;
            else System.out.printf("%s %+.2f\n", ERROR_MIN, min);
        }
    }

    public static int readIntMinMax(String message, int min, int max, boolean fromSting) {
        while (true) {
            int valoreLetto = readInt(message, fromSting);

            if (valoreLetto >= min && valoreLetto <= max) return valoreLetto;
            else if (valoreLetto < min) System.out.printf("%s %+.2f\n", ERROR_MIN, min);
            else System.out.printf("%s %+.2f\n", ERROR_MAX, max);
        }
    }

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

    public static double readDoublePos(String message, boolean fromSting) { return readDouble(message, 1, fromSting); }

    public static double readDubleNotNeg(String message, boolean fromSting) { return readDouble(message, 0, fromSting); }

    public static double readDouble(String message, double minimo, boolean fromSting) {
        while (true) {
            double valoreLetto = readDuble(message, fromSting);

            if (valoreLetto >= minimo) return valoreLetto;
            else System.out.printf("%s %+.2f\n", ERROR_MIN, minimo);
        }
    }

    public static boolean yesOrNo(String message) {
        String mioMessaggio = String.format("%s (%s/%s) -> ", message, YES, NO);
        char valoreLetto = readCharUpper(mioMessaggio, String.valueOf(YES) + String.valueOf(NO));

        return valoreLetto == YES;
    }
}
