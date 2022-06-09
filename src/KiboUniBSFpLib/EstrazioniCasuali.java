package KiboUniBSFpLib;

import java.util.Random;

/**
 * La classe <strong>EstrazioniCasuali</strong> permette di estrarre pseudo-casualmente un determinato tipo di dato.
 *
 * @author Alessandro Muscio
 * @version 1.0
 */
public class EstrazioniCasuali {
  /**
   * Rappresenta l'oggetto <code>Random</code> che viene utilizzato per le estrazioni.
   */
  private static final Random rand = new Random();

  /**
   * Estrae un <code>int</code> casuale compreso tra un minimo valore dato e un massimo valore dato.
   *
   * @param minimo  Indica il minimo valore da poter estrarre.
   * @param massimo Indica il massimo valore da poter estrarre.
   * @return Un <code>int</code> rappresentante il numero estratto.
   */
  public static int estraiIntero(int minimo, int massimo) {
    int range = massimo + 1 - minimo;
    int casual = rand.nextInt(range);

    return casual + minimo;
  }

  /**
   * Estrae un <code>double</code> casuale compreso tra un minimo valore dato e un massimo valore dato.
   *
   * @param minimo  Indica il minimo valore da poter estrarre.
   * @param massimo Indica il massimo valore da poter estrarre.
   * @return Un <code>double</code> rappresentante il numero estratto.
   */
  public static double estraiDouble(double minimo, double massimo) {
    return (massimo * rand.nextDouble());
  }

  /**
   * Questo metodo permette di effettuare estrazioni d'interi pseudo-casuali con una certa distribuzione: una volta dati un minimo e un massimo il metodo ritornerà valori compresi o uguali a questi due.
   * Per gestire la distribuzione si utilizzata un'esponente:
   * <ul>
   *   <li><=0: Ritornerà valori casuali, quasi sempre non compresi tra il minimo e il massimo;</li>
   *   <li>>0 e contemporaneamente <1: Più il valore casuale è vicino al massimo più è probabile che venga generato. Più si mette l'esponente vicino a zero maggiore sarà la possibilità di generare valori vicino al massimo;</li>
   *   <li>=1: Tutti i valori hanno più o meno la stessa probabilità di essere generati;</li>
   *   <li>>1: Più il valore casuale è vicino al minimo più è probabile che venga generato. Più è grande l'esponente, più sarà la possibilità di generare valori vicino al minimo.</li>
   * </ul>
   *
   * @param minimo    Il valore minimo che è possibile generare.
   * @param massimo   Il valore massimo che è possibile generare.
   * @param esponente L'esponete dell'equazione.
   * @return Un <code>int</code> rappresentante il valore casuale generato.
   */
  public static int estraiInteroConDistribuzione(int minimo, int massimo, double esponente) {
    int range = massimo + 1 - minimo;
    double random_double = Math.pow(rand.nextDouble(), esponente);

    return (int) Math.floor(minimo + range * random_double);
  }

  /**
   * Estrae un <code>boolean</code> casuale.
   *
   * @return Il <code>boolean</code> estratto.
   */
  public static boolean estraiBoolean() {
    return rand.nextBoolean();
  }
}
