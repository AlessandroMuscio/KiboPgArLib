package it.kibo.fp.lib;

import java.util.Random;

/**
 * The class <strong>RandomDraws</strong> lets you draw a specific data tipe in
 * a pseudo-random way.
 *
 * @author Alessandro Muscio
 * @version 1.0
 */
public final class RandomDraws {
  /**
   * Represents the <code>Random</code> object that will be used for the draws.
   */
  private static final Random rand = new Random();

  private RandomDraws() {
    throw new UnsupportedOperationException();
  }

  /**
   * Draws a random <code>int</code> between given minimum and maximum values.
   *
   * @param minimum The minimum value to draw.
   * @param maximum The maximum value to draw.
   * 
   * @return An <code>int</code> representing the drawn number.
   */
  public static int drawInteger(int minimum, int maximum) {
    int range = maximum + 1 - minimum;
    int casual = rand.nextInt(range);

    return casual + minimum;
  }

  /**
   * Draws a random <code>double</code> between given minimum and maximum values.
   *
   * @param minimum The minimum value to draw.
   * @param maximum The maximum value to draw.
   * 
   * @return A <code>double</code> representing the drawn number.
   */
  public static double drawDouble(double minimum, double maximum) {
    double range = maximum - minimum;

    return minimum + range * rand.nextDouble();
  }

  /**
   * Draws a random <code>int</code> between given minimum and maximum values,
   * with a certain distribution. In order to distribute the values you use the
   * <i>exponent</i>:
   * <ul>
   * <li><i>exponent</i> <span>&#8804;</span> 0: Completely random values will be
   * given, almost always not between the given minimum and maximum values. This
   * usage is not encouraged.</li>
   * <li>0 <span>&#60;</span> <i>exponent</i> <span>&#60;</span> 1: The values
   * near the maximum have a greater probability of being drawn, closer the
   * <i>exponent</i> is to 0.</li>
   * <li><i>exponent</i> <span>&#61;</span> 1: All the values have the same
   * probability of being drawn.</li>
   * <li><i>exponent</i> <span>&#8805;</span> 1: The values near the minimum have
   * a greater probability of being drawn, greater <i>exponents</i> will increase
   * this probability.</li>
   * </ul>
   *
   * @param minimum  The minimum value to draw.
   * @param maximum  The maximum value to draw.
   * @param exponent The exponent of the distribution.
   * 
   * @return An <code>int</code> representing the drawn number.
   */
  public static int drawIntegerWithDistribution(int minimum, int maximum, double exponent) {
    int range = maximum + 1 - minimum;
    double random_double = Math.pow(rand.nextDouble(), exponent);

    return (int) Math.floor(minimum + range * random_double);
  }

  /**
   * Draws a random <code>boolean</code>.
   *
   * @return The drawn <code>boolean</code>.
   */
  public static boolean estraiBoolean() {
    return rand.nextBoolean();
  }
}