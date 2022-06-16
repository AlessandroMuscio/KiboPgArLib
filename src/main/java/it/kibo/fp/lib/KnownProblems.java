package it.kibo.fp.lib;

/**
 * The class <strong>KnownProblems</strong> has the implementation of some of
 * the usual problem that you always forget and need to go watch the solution on
 * StackOverflow even though you know you've already solved them.
 *
 * @author Alessandro Muscio
 * @version 1.0
 */
public final class KnownProblems {
  private KnownProblems() {
    throw new UnsupportedOperationException();
  }

  /**
   * Finds the <strong>MCD</strong> (Maximum Common Divider) between two numbers.
   *
   * @param a The first number to calculate the MCD.
   * @param b The first number to calculate the MCD.
   * 
   * @return An <code>int</code> representing the MCD between <code>a</code> e
   *         <code>b</code>.
   */
  public static int MCD(int a, int b) {
    while (a != 0 && b != 0) {
      if (a > b)
        a %= b;
      else
        b %= a;
    }

    return a == 0 ? b : a;
  }

  /**
   * Finds the <strong>MCD</strong> (Maximum Common Divider) between an
   * <code>array</code> of numbers.
   *
   * @param values The values used to find the MCD.
   * 
   * @return An <code>int</code> representing the MCD between all the values. If
   *         values is null or is an empty array <code>-1</code> will be given.
   */
  public static int MCD(int[] values) {
    if (values == null || values.length == 0)
      return -1;

    int mcd = values[0];

    for (int i = 1; i < values.length; i++)
      mcd = MCD(mcd, values[i]);

    return mcd;
  }

  /**
   * Finds the <strong>MCM</strong> (Minimum Common Multiplier) between two
   * numbers.
   *
   * @param a The first number to calculate the MCM.
   * @param b The first number to calculate the MCM.
   * 
   * @return An <code>int</code> representing the MCM between <code>a</code> e
   *         <code>b</code>.
   */
  public static int MCM(int a, int b) {
    int mcd = MCD(a, b);

    return (a * b) / mcd;
  }

  /**
   * Finds the <strong>MCM</strong> (Minimum Common Multiplier) between an
   * <code>array</code> of numbers.
   *
   * @param values The values used to find the MCM.
   * 
   * @return An <code>int</code> representing the MCM between all the values. If
   *         values is null or is an empty array <code>-1</code> will be given.
   */
  public static int MCM(int[] values) {
    if (values == null || values.length == 0)
      return -1;

    int mcm = values[0];

    for (int i = 1; i < values.length; i++)
      mcm = MCM(mcm, values[i]);

    return mcm;
  }

  /**
   * Counts the number of digits of an integer.
   * 
   * @param n The number to calculate the digits.
   * 
   * @return An <code>int</code> representing the number of digits of n.
   */
  public static int countIntegerDigits(int n) {
    return Integer.toString(n).length();
  }

  /**
   * Counts the number of decimal digits in a <code>double</code>.
   * 
   * @param n The number to calculate the decimal digits.
   * @return An <code>int</code> representing the number of decimal digits of n.
   */
  public static int countDecimalDigits(double n) {
    String nString = Double.toString(n);
    int integerPlaces = nString.indexOf('.') + 1;

    return nString.length() - integerPlaces;
  }
}