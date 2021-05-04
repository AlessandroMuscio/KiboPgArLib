package it.unibs.fp.mylib;

import java.util.Random;

/**
 * La classe <strong>EstrazioniCasuali</strong> permette di estrarre
 * pseudo-casualmente un determinato tipo di dato
 * 
 * @author Alessandro Muscio
 * @version 1.0
 */
public class EstrazioniCasuali {
  /**
   * Rappresenta l'oggetto <strong>Random</strong> che viene utilizzato per le
   * estrazioni
   */
  private static Random rand = new Random();

  /**
   * Estrae un <strong>intero</strong> casuale compreso tra un minimo valore dato
   * e un massimo valore dato
   * 
   * @param minimo  Indica il minimo valore da poter estrarre
   * @param massimo Indica il massimo valore da poter estrarre
   * @return Un <code>int</code> rappresentante il numero estratto
   */
  public static int estraiIntero(int minimo, int massimo) {
    int range = massimo + 1 - minimo;
    int casual = rand.nextInt(range);

    return casual + minimo;
  }

  /**
   * Questo metodo permette di effettuare estrazioni di interi pseudo-casuali con
   * una certa distribuzione. Una volta dati un minimo e un massimo il metodo
   * ritornerà valori compresi o uguali a questi due. Per gestire la distribuzione
   * si utilizzata l'esponente:<br>
   * - <=0 ritornerà valori casuali, quasi sempre non compresi tra il minimo e il
   * massimo<br>
   * - >0 && <1 Più il valore casuale è vicino al massimo più è probabile che
   * venga generato. Più si mette l'esponente vicino a 0 maggiore sarà la
   * possibilità di generare valori vicino al massimo<br>
   * - =1 La distribuzione, tutti i valori hanno più o meno la stessa probabilità
   * di essere generati<br>
   * - >1 Più il valore casuale è vicino al minimo più è probabile che venga
   * generato. Più si grande è l'esponente sarà la possibilità di generare valori
   * vicino al minimo<br>
   * 
   * @param minimo    Il valore minimo che è possibile generare
   * @param massimo   Il valore massimo che è possibile generare
   * @param esponente L'esponete dell'equazione
   * @return Un <code>int</code> rappresentante il valore casuale generato
   */
  public static int estraiInteroConDistribuzione(int minimo, int massimo, double esponente) {
    int range = massimo + 1 - minimo;
    double random_double = Math.pow(rand.nextDouble(), esponente);

    return (int) Math.floor(minimo + range * random_double);
  }

  /**
   * Estrae un <strong>double</strong> casuale compreso tra un minimo valore dato
   * e un massimo valore dato
   * 
   * @param minimo  Indica il minimo valore da poter estrarre
   * @param massimo Indica il massimo valore da poter estrarre
   * @return Un <code>double</code> rappresentante il numero estratto
   */
  public static double estraiDouble(double minimo, double massimo) {
    return (minimo + (massimo - minimo) * rand.nextDouble());
  }

  /**
   * Estrae un <strong>boolean</strong> casuale
   * 
   * @return Il <code>boolean</code> estratto
   */
  public static boolean estraiBoolean() {
    return rand.nextBoolean();
  }
}
