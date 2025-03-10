package com.kibo.pgar.lib;

import java.util.Random;

/**
 * <code>Class</code> that let you draw a specific data type in a
 * pseudo-random way.
 * 
 * @author Alessandro Muscio (Kibo)
 */
public class RandomDraws {
  private static final String UNSUPPORTED_OP_ERR_MSG = String
      .format("%sThis class isn't instantiable!%s", AnsiColors.RED, AnsiColors.RESET);
  private static final Random RAND = new Random();

  public RandomDraws() throws UnsupportedOperationException {
    throw new UnsupportedOperationException(RandomDraws.UNSUPPORTED_OP_ERR_MSG);
  }

  /**
   * Draws a pseudo-random <code>int</code> between a given min and max, included.
   * 
   * @param min The minimum value to draw from.
   * @param max The maximum value to draw from.
   * 
   * @return An <code>int</code> representing the drawn number.
   */
  public static int drawInteger(int min, int max) {
    int range = max + 1 - min;
    int randInt = RAND.nextInt(range);

    return randInt + min;
  }

  /**
   * Draws a pseudo-random <code>double</code> between a given min and max,
   * included.
   * 
   * @param min The minimum value to draw from.
   * @param max The maximum value to draw from.
   * 
   * @return A <code>double</code> representing the drawn number.
   */
  public static double drawDouble(double min, double max) {
    double range = max - min;
    double randDouble = range * RAND.nextDouble();

    return min + randDouble;
  }

  /**
   * Draws a pseudo-random <code>int</code> between a given min and max, included,
   * with a certain distribution. In order to distribute the values you use the
   * <i>exponent</i>:
   * <ul>
   * <li><code>exponent &#8804; 0</code>: Completely random values will be given,
   * almost always not between the given minimum and maximum values. This usage is
   * not encouraged.</li>
   * <li><code>0 &#60; exponent &#60; 1</code>: The values near the maximum have a
   * greater probability of being drawn, closer the exponent is to 0.</li>
   * <li><code>exponent = 1</code>: All the values have the same probability of
   * being drawn.</li>
   * <li><code>exponent &#62; 1</code>: The values near the minimum have a greater
   * probability of being drawn, greater exponents will increase this
   * probability.</li>
   * </ul>
   * 
   * @param min      The minimum value to draw from.
   * @param max      The maximum value to draw from.
   * @param exponent The exponent of the distribution.
   * 
   * @return An <code>int</code> representing the drawn number.
   */
  public static int drawIntegerWithDistribution(int min, int max, double exponent) {
    int range = max + 1 - min;
    double randDouble = range * Math.pow(RAND.nextDouble(), exponent);

    Double drawnNum = Math.floor(min + randDouble);

    return drawnNum.intValue();
  }

  /**
   * Draws a pseudo-random <code>boolean</code>.
   * 
   * @return The <code>boolean</code> value that was drawn.
   */
  public static boolean drawBoolean() {
    return RAND.nextBoolean();
  }
}
