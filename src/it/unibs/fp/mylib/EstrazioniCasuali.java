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
