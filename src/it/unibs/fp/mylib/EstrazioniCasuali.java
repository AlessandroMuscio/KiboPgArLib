package it.unibs.fp.mylib;

import java.util.Random;

public class EstrazioniCasuali {
  private static Random rand = new Random();

  /**
   * Estrae un <strong>intero</strong> casuale compreso tra il <em>minimo</em> e
   * il <em>massimo</em>
   * 
   * @param min Indica il <em>minimo</em> numero da poter estrarre
   * @param max Indica il <em>massimo</em> numero da poter estrarre
   * @return Un <code>int</code> rappresentante il numero estratto
   */
  public static int estraiIntero(int min, int max) {
    int range = max + 1 - min;
    int casual = rand.nextInt(range);

    return casual + min;
  }

  /**
   * Estrae un <strong>double</strong> casuale compreso tra il <em>minimo</em> e
   * il <em>massimo</em>
   * 
   * @param min Indica il <em>minimo</em> numero da poter estrarre
   * @param max Indica il <em>massimo</em> numero da poter estrarre
   * @return Un <code>double</code> rappresentante il numero estratto
   */
  public static double estraiDouble(double min, double max) {
    return (min + (max - min) * rand.nextDouble());
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
