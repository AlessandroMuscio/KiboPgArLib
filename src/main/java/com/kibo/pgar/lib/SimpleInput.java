package com.kibo.pgar.lib;

import java.util.*;

public class SimpleInput {
    private static Scanner scanner = creaScanner();

    private final static String ERRORE_FORMATO = "Attenzione: il dato inserito non e' nel formato corretto";
    private final static String ERRORE_MINIMO = "Attenzione: e' richiesto un valore maggiore o uguale a ";
    private final static String ERRORE_STRINGA_VUOTA = "Attenzione: non hai inserito alcun carattere";
    private final static String ERRORE_STRINGA_CHAR_DIVERSA_DA_LUNGHEZZA_UNO = "Attenzione inserire solo un carattere";
    private final static String ERRORE_MASSIMO = "Attenzione: e' richiesto un valore minore o uguale a ";
    private final static String MESSAGGIO_AMMISSIBILI = "Attenzione: i caratteri ammissibili sono: ";

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
            else System.out.println(ERRORE_FORMATO);
        }
    }

    public static char readCharUpper(String message) {
        while (true) {
            System.out.printf("%s -> ", message);

            String valoreLetto = scanner.nextLine();

            if (valoreLetto.length() == 1) return  valoreLetto.charAt(0);
            else System.out.println(ERRORE_STRINGA_CHAR_DIVERSA_DA_LUNGHEZZA_UNO);
        }
    }

    public static char readCharUpper(String message, String possible) {
        while (true) {
            char valoreLetto = Character.toUpperCase(readCharUpper(message));

            if (possible.indexOf(valoreLetto) != -1) return valoreLetto;
            else System.out.printf("%s %s\n", MESSAGGIO_AMMISSIBILI, possible);
        }
    }

    public static int readInt(String message, boolean fromSting) {
        while (true) {
            System.out.printf("%s -> ", message);
            try {
                if (fromSting) return Integer.parseInt(scanner.nextLine());
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(ERRORE_MINIMO);
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
            else System.out.printf("%s %+.2f\n", ERRORE_MINIMO, min);
        }
    }

    public static int readIntMinMax(String message, int min, int max, boolean fromSting) {
        while (true) {
            int valoreLetto = readInt(message, fromSting);

            if (valoreLetto >= min && valoreLetto <= max) return valoreLetto;
            else if (valoreLetto < min) System.out.printf("%s %+.2f\n", ERRORE_MINIMO, min);
            else System.out.printf("%s %+.2f\n", ERRORE_MASSIMO, max);
        }
    }

    public static double readDuble(String message, boolean fromString) {
        while (true) {
            System.out.printf("%s -> ", message);
            try {
                if (fromString) return Double.parseDouble(scanner.nextLine());
                else return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println(ERRORE_MINIMO);
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
            else System.out.printf("%s %+.2f\n", ERRORE_MINIMO, minimo);
        }
    }

    public static boolean yesOrNo(String message) {
        String mioMessaggio = String.format("%s (%s/%s) -> ", message, YES, NO);
        char valoreLetto = readCharUpper(mioMessaggio, String.valueOf(YES) + String.valueOf(NO));

        return valoreLetto == YES;
    }
}
