package KiboUniBSFpLib;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * La classe <strong>InputDati</strong> permette di leggere un determinato tipo di dato inserito in ingresso dall'utente. Permette inoltre di effettuare dei controlli sul dato.
 *
 * @author Alessandro Muscio
 * @version 1.0
 */
public class InputDati {
  /**
   * Rappresenta l'oggetto <code>Scanner</code> utilizzato per leggere i dati in ingresso dell'utente.
   */
  private static final Scanner lettore = creaScanner();

  private final static String CARATTERI_ALFANUMERICI = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
  private final static String ERRORE_CARATTERI_ALFANUMERICI = "ATTENZIONE: sono accettati solo caratteri alfanumerici";
  private final static String ERRORE_STRINGA_VUOTA = "ATTENZIONE: non hai inserito alcun carattere";
  private final static String MESSAGGIO_AMMISSIBILI = "ATTENZIONE: i caratteri ammissibili sono: ";
  private final static String ERRORE_FORMATO_INTERO = "ATTENZIONE: il dato inserito non è nel formato corretto. Inserire un intero";
  private final static String ERRORE_FORMATO_DOUBLE = "ATTENZIONE: il dato inserito non è nel formato corretto. Inserire un double";
  private final static String ERRORE_MINIMO = "ATTENZIONE: è richiesto un valore maggiore o uguale a ";
  private final static String ERRORE_MASSIMO = "ATTENZIONE: è richiesto un valore minore o uguale a ";
  private final static String RISPOSTA_SI = "sS";
  private final static String RISPOSTA_NO = "nN";

  /**
   * Metodo che crea un oggetto di tipo <code>Scanner</code> inizializzando l'attributo <code>lettore</code>.
   *
   * @return Uno oggetto di tipo <code>Scanner</code>.
   */
  private static Scanner creaScanner() {
    Scanner scanner = new Scanner(System.in);

    return scanner;
  }

  /**
   * Verifica se il messaggio passato contiene solo caratteri alfanumerici.
   *
   * @param messaggio Il messaggio da verificare.
   * @return Un <code>boolean</code> rappresentante se il messaggio è alfanumerico o no.
   */
  private static boolean contieneCaratteriAlfanumerici(String messaggio) {
    char currentChar;

    for (int i = 0; i < messaggio.length(); i++) {
      currentChar = messaggio.charAt(i);

      if (CARATTERI_ALFANUMERICI.indexOf(currentChar) == -1)
        return false;
    }

    return true;
  }

  /**
   * Stampa un messaggio in uscita e legge la stringa che l'utente mette in ingresso. Se essa non è una <code>String</code> stampa un messaggio d'errore. È possibile scegliere se la stringa in ingresso deve essere alfanumerica oppure no.
   *
   * @param messaggio    Il messaggio da stampare all'utente.
   * @param alfanumerico Indica se l'ingresso debba essere alfanumerico o no.
   * @return Una <code>String</code> rappresentante l'ingresso dell'utente
   */
  public static String leggiStringa(String messaggio, boolean alfanumerico) {
    boolean isAlfanumerico;
    String lettura;

    if (alfanumerico) {
      do {
        System.out.print(messaggio);
        lettura = lettore.next();
        lettura = lettura.trim();
        isAlfanumerico = contieneCaratteriAlfanumerici(lettura);

        if (!isAlfanumerico)
          System.out.println(ERRORE_CARATTERI_ALFANUMERICI);
      } while (!isAlfanumerico);
    } else {
      System.out.print(messaggio);
      lettura = lettore.next();
      lettura = lettura.trim();
    }

    return lettura;
  }

  /**
   * Stampa un messaggio in uscita e legge la stringa che l'utente mette in ingresso, a patto che essa non sia vuota. Se l'ingresso non è una <code>String</code> stampa un messaggio d'errore. Si può scegliere se l'ingresso debba essere alfanumerico o no.
   *
   * @param messaggio    Il messaggio da stampare all'utente.
   * @param alfanumerico Indica se l'ingresso debba essere alfanumerico o no.
   * @return Una <code>String</code> rappresentante l'ingresso dell'utente.
   */
  public static String leggiStringaNonVuota(String messaggio, boolean alfanumerico) {
    boolean isStringaVuota = false;
    String lettura;

    do {
      lettura = leggiStringa(messaggio, alfanumerico);

      if (lettura.length() > 0)
        System.out.println(ERRORE_STRINGA_VUOTA);
      else
        isStringaVuota = true;
    } while (isStringaVuota);

    return lettura;
  }

  /**
   * Stampa un messaggio in uscita e legge il <code>char</code> che l'utente mette in ingresso, a patto che esso appartenga a quelli <strong>ammissibili</strong>. Se l'ingresso è una <code>String</code> allora prende il primo carattere di essa. Se il carattere letto non è tra quelli ammissibili stampa a video un errore.
   *
   * @param messaggio   Il messaggio da stampare all'utente.
   * @param ammissibili Contiene tutti i caratteri ammissibili.
   * @return Un <code>char</code> rappresentante il carattere letto.
   */
  public static char leggiChar(String messaggio, String ammissibili) {
    boolean isAmmissibile = false;
    char carattereLetto = '\0';

    do {
      System.out.print(messaggio);
      String lettura = lettore.next();

      if (lettura.length() > 0) {
        carattereLetto = lettura.charAt(0);

        if (ammissibili.indexOf(carattereLetto) != -1)
          isAmmissibile = true;
        else
          System.out.println(MESSAGGIO_AMMISSIBILI + ammissibili);
      } else {
        System.out.println(ERRORE_STRINGA_VUOTA);
      }
    } while (!isAmmissibile);

    return carattereLetto;
  }

  /**
   * Stampa un messaggio in uscita e legge l'<code>int</code> che l'utente mette in ingresso. Ritorna un messaggio d'errore in caso non venga letto un intero.
   *
   * @param messaggio Il messaggio da stampare all'utente.
   * @return Un <code>int</code> rappresentante l'intero letto.
   */
  public static int leggiIntero(String messaggio) {
    boolean isIntero = false;
    int lettura = 0;

    do {
      System.out.print(messaggio);

      try {
        lettura = lettore.nextInt();
        isIntero = true;
      } catch (InputMismatchException e) {
        System.out.println(ERRORE_FORMATO_INTERO);
        String daButtare = lettore.next();
      }
    } while (!isIntero);

    return lettura;
  }

  /**
   * Stampa un messaggio in uscita e legge l'<strong>intero</strong> che l'utente mette in ingresso, a patto che sia maggiore o uguale di un dato valore minimo. Ritorna un messaggio d'errore in caso non venga letto un intero oppure in caso l'intero sia minore di un dato minimo.
   *
   * @param messaggio Il messaggio da stampare all'utente.
   * @param minimo    Rappresenta il minimo valore leggibile.
   * @return Un <code>int</code> rappresentante l'intero letto.
   */
  public static int leggiInteroConMinimo(String messaggio, int minimo) {
    boolean isSopraMinimo = false;
    int lettura;

    do {
      lettura = leggiIntero(messaggio);

      if (lettura >= minimo)
        isSopraMinimo = true;
      else
        System.out.println(ERRORE_MINIMO + minimo);
    } while (!isSopraMinimo);

    return lettura;
  }

  /**
   * Stampa un messaggio in uscita e legge l'<code>int</code> che l'utente mette in ingresso, a patto che sia minore o uguale di un dato valore massimo. Ritorna un messaggio d'errore in caso non venga letto un intero oppure in caso l'intero sia maggiore di un dato massimo.
   *
   * @param messaggio Il messaggio da stampare all'utente.
   * @param massimo   Rappresenta il massimo valore leggibile.
   * @return Un <code>int</code> rappresentante l'intero letto.
   */
  public static int leggiInteroConMassimo(String messaggio, int massimo) {
    boolean isSottoMassimo = false;
    int lettura;

    do {
      lettura = leggiIntero(messaggio);

      if (lettura <= massimo)
        isSottoMassimo = true;
      else
        System.out.println(ERRORE_MASSIMO + massimo);
    } while (!isSottoMassimo);

    return lettura;
  }

  /**
   * Stampa un messaggio in uscita e legge l'<code>int</code> che l'utente mette in ingresso, a patto che sia contemporaneamente maggiore o uguale di un dato valore minimo e minore o uguale di un dato valore massimo. Ritorna un messaggio d'errore in caso non venga letto un intero, in caso l'intero sia minore di un dato minimo oppure in caso l'intero sia maggiore di un dato massimo.
   *
   * @param messaggio Il messaggio da stampare all'utente.
   * @param minimo    Rappresenta il minimo valore leggibile.
   * @param massimo   Rappresenta il massimo valore leggibile.
   * @return Un <code>int</code> rappresentante l'intero letto.
   */
  public static int leggiInteroCompreso(String messaggio, int minimo, int massimo) {
    boolean isTraMinimoEMassimo = false;
    int lettura;

    do {
      lettura = leggiIntero(messaggio);

      if (lettura >= minimo && lettura <= massimo)
        isTraMinimoEMassimo = true;
      else if (lettura < minimo)
        System.out.println(ERRORE_MINIMO + minimo);
      else
        System.out.println(ERRORE_MASSIMO + massimo);
    } while (!isTraMinimoEMassimo);

    return lettura;
  }

  /**
   * Stampa un messaggio in uscita e legge il <code>double</code> che l'utente mette in ingresso. Ritorna un messaggio d'errore in caso non venga letto un double.
   *
   * @param messaggio Il messaggio da stampare all'utente.
   * @return Un <code>double</code> rappresentante il double letto.
   */
  public static double leggiDouble(String messaggio) {
    boolean isDouble = false;
    double lettura = Double.NaN;

    do {
      System.out.print(messaggio);

      try {
        lettura = lettore.nextDouble();
        isDouble = true;
      } catch (InputMismatchException e) {
        System.out.println(ERRORE_FORMATO_DOUBLE);
        String daButtare = lettore.next();
      }
    } while (!isDouble);

    return lettura;
  }

  /**
   * Stampa un messaggio in uscita e legge il <code>double</code> che l'utente mette in ingresso, a patto che sia maggiore o uguale di un dato valore minimo. Ritorna un messaggio d'errore in caso non venga letto un double oppure in caso il double sia minore di un dato minimo.
   *
   * @param messaggio Il messaggio da stampare all'utente.
   * @param minimo    Rappresenta il minimo valore leggibile.
   * @return Un <code>double</code> rappresentante il double letto.
   */
  public static double leggiDoubleConMinimo(String messaggio, double minimo) {
    boolean isSopraMinimo = false;
    double lettura;

    do {
      lettura = leggiDouble(messaggio);

      if (lettura >= minimo)
        isSopraMinimo = true;
      else
        System.out.println(ERRORE_MINIMO + minimo);
    } while (!isSopraMinimo);

    return lettura;
  }

  /**
   * Stampa un messaggio in uscita e legge il <code>double</code> che l'utente mette in ingresso, a patto che sia minore o uguale di un dato valore massimo. Ritorna un messaggio d'errore in caso non venga letto un double oppure in caso il double sia maggiore di un dato massimo.
   *
   * @param messaggio Il messaggio da stampare all'utente.
   * @param massimo   Rappresenta il massimo valore leggibile.
   * @return Un <code>double</code> rappresentante il double letto.
   */
  public static double leggiDoubleConMassimo(String messaggio, double massimo) {
    boolean isSottoMassimo = false;
    double lettura;

    do {
      lettura = leggiDouble(messaggio);

      if (lettura <= massimo)
        isSottoMassimo = true;
      else
        System.out.println(ERRORE_MASSIMO + massimo);
    } while (!isSottoMassimo);

    return lettura;
  }

  /**
   * Stampa un messaggio in uscita e legge il <code>double</code> che l'utente mette in ingresso, a patto che sia contemporaneamente maggiore o uguale di un dato valore minimo e minore o uguale di un dato valore massimo. Ritorna un messaggio d'errore in caso non venga letto un double, in caso il double sia minore di un dato minimo oppure in caso l'intero sia maggiore di un dato massimo.
   *
   * @param messaggio Il messaggio da stampare all'utente.
   * @param minimo    Rappresenta il minimo valore leggibile.
   * @param massimo   Rappresenta il massimo valore leggibile.
   * @return Un <code>double</code> rappresentante il double letto.
   */
  public static double leggiDoubleCompreso(String messaggio, double minimo, double massimo) {
    boolean isTraMinimoEMassimo = false;
    double lettura;

    do {
      lettura = leggiDouble(messaggio);

      if (lettura >= minimo && lettura <= massimo)
        isTraMinimoEMassimo = true;
      else if (lettura < minimo)
        System.out.println(ERRORE_MINIMO + minimo);
      else
        System.out.println(ERRORE_MASSIMO + massimo);
    } while (!isTraMinimoEMassimo);

    return lettura;
  }

  /**
   * Stampa una domanda in output e se l'utente risponde 's' o 'S' ritorna true, qualsiasi altra cosa ritorna false.
   *
   * @param domanda La domanda da stampare all'utente.
   * @return Un <code>boolean</code> rappresentante la risposta affermativa o negativa dell'utente.
   */
  public static boolean leggiSiONo(String domanda) {
    domanda = domanda + "? [" + RISPOSTA_SI.charAt(1) + "/" + RISPOSTA_NO.charAt(0) + "] ";
    char valoreLetto = leggiChar(domanda, RISPOSTA_SI + RISPOSTA_NO);

    return (RISPOSTA_SI.indexOf(valoreLetto) != -1);
  }
}
