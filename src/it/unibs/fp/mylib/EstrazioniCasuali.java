package it.unibs.fp.mylib;

import java.util.Random;

public class EstrazioniCasuali {
  private static Random rand = new Random();

  public static int estraiIntero(int min, int max) {
    int range = max + 1 - min;
    int casual = rand.nextInt(range);

    return casual + min;
  }

  public static double estraiDouble(double min, double max) {
    return (min + (max - min) * rand.nextDouble());
  }

  public static boolean estraiBoolean() {
    return rand.nextBoolean();
  }
}
