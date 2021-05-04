package it.unibs.fp.mylib;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * La classe <strong>InputDati</strong> permette di leggere un determinato tipo
 * di dato inserito in input dall'utente. Permette inoltre di effettuare dei
 * controlli su questo dato
 * 
 * @author Alessandro Muscio
 * @version 1.0
 */
public class InputDati {
  /**
   * Rappresenta l'oggetto <strong>scanner</strong> utilizzato per leggere gli
   * input dell'utente
   */
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

  /**
   * Metodo che crea un oggetto di tipo scanner
   * 
   * @return Uno oggetto di tipo <code>Scanner</code>
   */
  private static Scanner creaScanner() {
    Scanner creato = new Scanner(System.in);

    creato.useDelimiter(System.getProperty("line.separator"));

    return creato;
  }

  /**
   * Verifica se il messaggio passato contiene solo caratteri alfanumerici
   * 
   * @param messaggio Il messaggio da verificare
   * @return Un <code>boolean</code> rappresentante se il messaggio è alfanumerico
   *         o no
   */
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

  /**
   * Stampa un messaggio in output e legge la stringa che l'utente mette in input.
   * Se l'input non è una stringa stampa un messaggio d'errore. Si può scegliere
   * se l'input deve essere alfanumerico o no
   * 
   * @param messaggio    Il messaggio da stampare all'utente
   * @param alfanumerico Indica se l'input debba essere alfanumerico o no
   * @return Una <code>String</code> rappresentante l'input dell'utente
   */
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

  /**
   * Stampa un messaggio in output e legge la stringa che l'utente mette in input,
   * a patto che essa non sia vuota. Se l'input non è una stringa stampa un
   * messaggio d'errore. Si può scegliere se l'input debba essere alfanumerico o
   * no
   * 
   * @param messaggio    Il messaggio da stampare all'utente
   * @param alfanumerico Indica se l'input debba essere alfanumerico o no
   * @return Una <code>String</code> rappresentante l'input dell'utente
   */
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

  /**
   * Stampa un messaggio in output e legge il <strong>carattere</strong> che
   * l'utente mette in input, a patto che esso appartenga a quelli
   * <strong>ammissibili</strong>. Se l'input è una stringa allora prende il primo
   * carattere di essa. Se il carattere letto non è tra quelli ammissibili stampa
   * a video un errore
   * 
   * @param messaggio   Il messaggio da stampare all'utente
   * @param ammissibili Contiene tutti i caratteri ammissibili
   * @return Un <code>char</code> rappresentante il carattere letto
   */
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

  /**
   * Stampa un messaggio in output e legge l'<strong>intero</strong> che l'utente
   * mette in input. Ritorna un messaggio d'errore in caso non venga letto un
   * intero
   * 
   * @param messaggio Il messaggio da stampare all'utente
   * @return Un <code>int</code> rappresentante l'intero letto
   */
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

  /**
   * Stampa un messaggio in output e legge l'<strong>intero</strong> che l'utente
   * mette in input, a patto che sia maggiore o uguale di un dato valore minimo.
   * Ritorna un messaggio d'errore in caso non venga letto un intero oppure in
   * caso l'intero sia minore di un dato minimo
   * 
   * @param messaggio Il messaggio da stampare all'utente
   * @param minimo    Rappresenta il minimo valore leggibile
   * @return Un <code>int</code> rappresentante l'intero letto
   */
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

  /**
   * Stampa un messaggio in output e legge l'<strong>intero</strong> che l'utente
   * mette in input, a patto che sia minore o uguale di un dato valore massimo.
   * Ritorna un messaggio d'errore in caso non venga letto un intero oppure in
   * caso l'intero sia maggiore di un dato massimo
   * 
   * @param messaggio Il messaggio da stampare all'utente
   * @param massimo   Rappresenta il massimo valore leggibile
   * @return Un <code>int</code> rappresentante l'intero letto
   */
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

  /**
   * Stampa un messaggio in output e legge l'<strong>intero</strong> che l'utente
   * mette in input, a patto che sia contemporaneamente maggiore o uguale di un
   * dato valore minimo e minore o uguale di un dato valore massimo. Ritorna un
   * messaggio d'errore in caso non venga letto un intero, in caso l'intero sia
   * minore di un dato minimo oppure in caso l'intero sia maggiore di un dato
   * massimo
   * 
   * @param messaggio Il messaggio da stampare all'utente
   * @param minimo    Rappresenta il minimo valore leggibile
   * @param massimo   Rappresenta il massimo valore leggibile
   * @return Un <code>int</code> rappresentante l'intero letto
   */
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

  /**
   * Stampa un messaggio in output e legge il <strong>double</strong> che l'utente
   * mette in input. Ritorna un messaggio d'errore in caso non venga letto un
   * double
   * 
   * @param messaggio Il messaggio da stampare all'utente
   * @return Un <code>double</code> rappresentante il double letto
   */
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

  /**
   * Stampa un messaggio in output e legge il <strong>double</strong> che l'utente
   * mette in input, a patto che sia maggiore o uguale di un dato valore minimo.
   * Ritorna un messaggio d'errore in caso non venga letto un double oppure in
   * caso il double sia minore di un dato minimo
   * 
   * @param messaggio Il messaggio da stampare all'utente
   * @param minimo    Rappresenta il minimo valore leggibile
   * @return Un <code>double</code> rappresentante il double letto
   */
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

  /**
   * Stampa un messaggio in output e legge il <strong>double</strong> che l'utente
   * mette in input, a patto che sia minore o uguale di un dato valore massimo.
   * Ritorna un messaggio d'errore in caso non venga letto un double oppure in
   * caso il double sia maggiore di un dato massimo
   * 
   * @param messaggio Il messaggio da stampare all'utente
   * @param massimo   Rappresenta il massimo valore leggibile
   * @return Un <code>double</code> rappresentante il double letto
   */
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

  /**
   * Stampa un messaggio in output e legge il <strong>double</strong> che l'utente
   * mette in input, a patto che sia contemporaneamente maggiore o uguale di un
   * dato valore minimo e minore o uguale di un dato valore massimo. Ritorna un
   * messaggio d'errore in caso non venga letto un double, in caso il double sia
   * minore di un dato minimo oppure in caso l'intero sia maggiore di un dato
   * massimo
   * 
   * @param messaggio Il messaggio da stampare all'utente
   * @param minimo    Rappresenta il minimo valore leggibile
   * @param massimo   Rappresenta il massimo valore leggibile
   * @return Un <code>double</code> rappresentante il double letto
   */
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

  /**
   * Stampa una domanda in output e se l'utente risponde 's' o 'S' ritorna true,
   * qualsiasi altra cosa ritorna false
   * 
   * @param domanda La domanda da stampare all'utente
   * @return Un <code>boolean</code> rappresentante ila risposta affermativa o
   *         negativa dell'utente
   */
  public static boolean leggiSiONo(String domanda) {
    domanda = domanda + "(" + RISPOSTA_SI.charAt(1) + "/" + RISPOSTA_NO.charAt(0) + ")? ";
    char valoreLetto = leggiChar(domanda, String.valueOf(RISPOSTA_SI) + String.valueOf(RISPOSTA_NO));

    if (RISPOSTA_SI.indexOf(valoreLetto) != -1)
      return true;
    else
      return false;
  }
}
