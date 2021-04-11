package it.unibs.fp.mylib;

import java.util.Scanner;
import java.util.InputMismatchException;

public class InputDati {
  private static Scanner lettore = creaScanner();

  private final static String CARATTERI_ALFANUMERICI = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  private final static String ERRORE_CARATTERI_ALFANUMERICI = "ATTENZIONE: sono accettati solo caratteri alfanumerici";
  private final static String ERRORE_STRINGA_VUOTA = "ATTENZIONE: non hai inserito alcun carattere";
  private final static String MESSAGGIO_AMMISSIBILI = "ATTENZIONE: i caratteri ammissibili sono: ";
  private final static String ERRORE_FORMATO_INTERO = "ATTENZIONE: il dato inserito non e' nel formato corretto. Inserire un intero";
  private final static String ERRORE_FORMATO_DOUBLE = "ATTENZIONE: il dato inserito non e' nel formato corretto. Inserire un double";
  private final static String ERRORE_MINIMO = "ATTENZIONE: e' richiesto un valore maggiore o uguale a ";
  private final static String ERRORE_MASSIMO = "ATTENZIONE: e' richiesto un valore minore o uguale a ";

  private final static String RISPOSTA_SI = "sS";
  private final static String RISPOSTA_NO = "nN";

  private static Scanner creaScanner() {
    Scanner creato = new Scanner(System.in);

    creato.useDelimiter(System.getProperty("line.separator"));

    return creato;
  }

  private static boolean contieneCaratteriAlfanumerici(String messaggio) {
    int i;
    char current_char;

    for (i = 0; i < messaggio.length(); i++) {
      current_char = messaggio.charAt(i);

      if (CARATTERI_ALFANUMERICI.indexOf(current_char) == -1)
        return false;
    }

    return true;
  }

  public static String leggiStringa(String messaggio, boolean alfanumerico) {
    boolean is_alfanumerico;
    String lettura;

    if (alfanumerico) {
      do {
        System.out.print(messaggio);
        lettura = lettore.next();
        lettura.trim();
        is_alfanumerico = contieneCaratteriAlfanumerici(lettura);

        if (!is_alfanumerico)
          System.out.println(ERRORE_CARATTERI_ALFANUMERICI);
      } while (!is_alfanumerico);
    } else {
      System.out.print(messaggio);
      lettura = lettore.next();
      lettura.trim();
    }

    return lettura;
  }

  public static String leggiStringaNonVuota(String messaggio, boolean alfanumerico) {
    boolean finito = false;
    String lettura = null;

    do {
      lettura = leggiStringa(messaggio, alfanumerico);
      if (lettura.length() > 0)
        finito = true;
      else
        System.out.println(ERRORE_STRINGA_VUOTA);
    } while (!finito);

    return lettura;
  }

  public static char leggiChar(String messaggio, String ammissibili) {
    boolean finito = false;
    char valoreLetto = '\0';

    do {
      System.out.print(messaggio);
      String lettura = lettore.next();

      if (lettura.length() > 0) {
        valoreLetto = lettura.charAt(0);
        if (ammissibili.indexOf(valoreLetto) != -1)
          finito = true;
        else
          System.out.println(MESSAGGIO_AMMISSIBILI + ammissibili);
      } else {
        System.out.println(ERRORE_STRINGA_VUOTA);
      }
    } while (!finito);

    return valoreLetto;
  }

  public static int leggiIntero(String messaggio) {
    boolean finito = false;
    int valoreLetto = 0;

    do {
      System.out.print(messaggio);
      try {
        valoreLetto = lettore.nextInt();
        finito = true;
      } catch (InputMismatchException e) {
        System.out.println(ERRORE_FORMATO_INTERO);
        String daButtare = lettore.next();
      }
    } while (!finito);

    return valoreLetto;
  }

  public static int leggiInteroConMinimo(String messaggio, int minimo) {
    boolean finito = false;
    int valoreLetto = 0;

    do {
      valoreLetto = leggiIntero(messaggio);
      if (valoreLetto >= minimo)
        finito = true;
      else
        System.out.println(ERRORE_MINIMO + minimo);
    } while (!finito);

    return valoreLetto;
  }

  public static int leggiInteroConMassimo(String messaggio, int massimo) {
    boolean finito = false;
    int valoreLetto = 0;

    do {
      valoreLetto = leggiIntero(messaggio);
      if (valoreLetto <= massimo)
        finito = true;
      else
        System.out.println(ERRORE_MASSIMO + massimo);
    } while (!finito);

    return valoreLetto;
  }

  public static int leggiInteroCompreso(String messaggio, int minimo, int massimo) {
    boolean finito = false;
    int valoreLetto = 0;

    do {
      valoreLetto = leggiIntero(messaggio);
      if (valoreLetto >= minimo && valoreLetto <= massimo)
        finito = true;
      else if (valoreLetto < minimo)
        System.out.println(ERRORE_MINIMO + minimo);
      else
        System.out.println(ERRORE_MASSIMO + massimo);
    } while (!finito);

    return valoreLetto;
  }

  public static double leggiDouble(String messaggio) {
    boolean finito = false;
    double valoreLetto = 0;

    do {
      System.out.print(messaggio);
      try {
        valoreLetto = lettore.nextDouble();
        finito = true;
      } catch (InputMismatchException e) {
        System.out.println(ERRORE_FORMATO_DOUBLE);
        String daButtare = lettore.next();
      }
    } while (!finito);

    return valoreLetto;
  }

  public static double leggiDoubleConMinimo(String messaggio, double minimo) {
    boolean finito = false;
    double valoreLetto = 0;

    do {
      valoreLetto = leggiDouble(messaggio);
      if (valoreLetto >= minimo)
        finito = true;
      else
        System.out.println(ERRORE_MINIMO + minimo);
    } while (!finito);

    return valoreLetto;
  }

  public static double leggiDoubleConMassimo(String messaggio, double massimo) {
    boolean finito = false;
    double valoreLetto = 0;

    do {
      valoreLetto = leggiDouble(messaggio);
      if (valoreLetto <= massimo)
        finito = true;
      else
        System.out.println(ERRORE_MASSIMO + massimo);
    } while (!finito);

    return valoreLetto;
  }

  public static double leggiDoubleCompreso(String messaggio, double minimo, double massimo) {
    boolean finito = false;
    double valoreLetto = 0;

    do {
      valoreLetto = leggiDouble(messaggio);
      if (valoreLetto >= minimo && valoreLetto <= massimo)
        finito = true;
      else if (valoreLetto < minimo)
        System.out.println(ERRORE_MINIMO + minimo);
      else
        System.out.println(ERRORE_MASSIMO + massimo);
    } while (!finito);

    return valoreLetto;
  }

  public static boolean leggiSiONo(String messaggio) {
    messaggio = messaggio + "(" + RISPOSTA_SI.charAt(1) + "/" + RISPOSTA_NO.charAt(0) + ")? ";
    char valoreLetto = leggiChar(messaggio, String.valueOf(RISPOSTA_SI) + String.valueOf(RISPOSTA_NO));

    if (RISPOSTA_SI.indexOf(valoreLetto) != -1)
      return true;
    else
      return false;
  }
}
