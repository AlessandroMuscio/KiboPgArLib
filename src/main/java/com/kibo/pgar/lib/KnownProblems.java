package com.kibo.pgar.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <code>Class</code> for a simple implementation of some of the usual problems that you always
 * forget about and need to get on StackOverflow or GeeksForGeeks searching the algorithm even
 * though you know you have already solved them.
 * 
 * @author Alessandro Muscio (Kibo)
 */
public class KnownProblems {
  private static final String UNSUPPORTED_OP_ERR_MSG = String.format("%sThis class isn't instantiable!%s",
      AnsiColors.RED, AnsiColors.RESET);

  public KnownProblems() throws UnsupportedOperationException {
    throw new UnsupportedOperationException(KnownProblems.UNSUPPORTED_OP_ERR_MSG);
  }

  /**
   * Finds the <strong>G</strong>reatest <strong>C</strong>ommon <strong>D</strong>ivider
   * (<strong>MCD</strong>) between two or more integers.
   * 
   * @param values All the values from where to compute the MCD.
   * 
   * @return An <code>int</code> representing the MCD between all the values.
   * 
   * @throws IllegalArgumentException If <strong>less</strong> than two values are given.
   */
  public static int gcd(int... values) throws IllegalArgumentException {
    if (values == null || values.length < 2)
      throw new IllegalArgumentException();

    int mcd = values[0];
    for (int i = 0; i < values.length; i++)
      mcd = KnownProblems.gcd(mcd, values[i]);

    return mcd;
  }

  /**
   * Finds the <strong>L</strong>east <strong>C</strong>ommon <strong>M</strong>ultiplier
   * (<strong>MCM</strong>) between two or more integers.
   * 
   * @param values All the values from where to compute the MCM.
   * 
   * @return An <code>int</code> representing the MCM between all the values.
   * 
   * @throws IllegalArgumentException If <strong>less</strong> than two values are given.
   */
  public static int lcm(int... values) throws IllegalArgumentException {
    if (values == null || values.length < 2)
      throw new IllegalArgumentException();

    int mcm = values[0];
    for (int i = 0; i < values.length; i++)
      mcm = KnownProblems.lcm(mcm, values[i]);

    return mcm;
  }

  /**
   * Counts the number of digits present in the given <code>int</code>.
   * 
   * @param n The <code>int</code> from which to calculate the digits.
   * 
   * @return An <code>int</code> representing the number of digits of <code>n</code>.
   */
  public static int countIntegerDigits(long n) {
    n = Math.abs(n);
    return Long.toString(n).length();
  }

  /**
   * Counts the number of decimal digits present in the given <code>double</code>.
   * 
   * @param n The <code>double</code> from which to calculate the decimal digits.
   * 
   * @return An <code>int</code> representing the number of decimals digits of <code>n</code>.
   */
  public static int countDecimalDigits(double n) {
    String stringifiedN = Double.toString(n);
    int numIntDigits = stringifiedN.indexOf('.') + 1;

    return stringifiedN.length() - numIntDigits;
  }

  // """Finds the prime numbers from 2 to `n` using the Sieve of Eratosthenes algorithm. This
  // algorithm greatly decreases in speed the more we increase `n`, but it's still the simplest
  // way of finding prime numbers.

  // Params
  // ------
  // - `n` -> The limit of the sieve where to search for prime numbers.

  // Returns
  // -------
  // A list of integers representing the prime numbers frm 2 to `n`.
  // """

  /**
   * Finds the prime numbers from 2 to <code>n</code> using the Sieve of Eratosthenes algorithm. It is
   * still the simplest and most understandable known algorithm for finding prime numbers even though
   * its complexity is <code>O(N * log(log(N)))</code>.
   * 
   * @param n The limit of the sieve where to search for prime numbers.
   * 
   * @return A list of integers representing the prime numbers frm 2 to <code>n</code>.
   */
  public static List<Integer> sieveOfEratosthenes(int n) {
    List<Integer> primes = new ArrayList<>();
    Set<Integer> sieve = IntStream.rangeClosed(2, n).boxed().collect(Collectors.toSet());

    while (!sieve.isEmpty()) {
      int prime = Collections.min(sieve);
      primes.add(prime);

      IntStream.iterate(prime, i -> i <= n, i -> i + prime).forEach(sieve::remove);
    }

    return primes;
  }

  /**
   * Finds the prime numbers from 2 to <code>n</code> using the Sieve of Atkin algorithm. It is
   * absolutely not the most intuitive way of finding prime numbers <strong>but</strong>, it is a
   * great improvement in speed having a complexity of <code>O(N * log(N))</code>.<br>
   * <a href="https://shorturl.at/tsDxn">Here</a> a very detailed explanation of how this sieve works.
   * 
   * @param limit The limit of the sieve where to search for prime numbers.
   * 
   * @return A list of integers representing the prime numbers frm 2 to <code>limit</code>.
   */
  public static List<Integer> sieveOfAtkin(int limit) {
    List<Integer> primes = new ArrayList<>(List.of(2, 3, 5));
    boolean[] sieve = new boolean[limit + 1];
    int constraint = (int) (Math.sqrt(limit) + 1);

    for (int x = 1; x < constraint; x++) {
      for (int y = 1; y < constraint; y++) {
        int n = (int) (4 * Math.pow(x, 2) + Math.pow(y, 2));
        int r = n % 12;
        if (n <= limit && List.of(1, 5).contains(r))
          sieve[n] = !sieve[n];

        n = (int) (3 * Math.pow(x, 2) + Math.pow(y, 2));
        r = n % 12;
        if (n <= limit && r == 7)
          sieve[n] = !sieve[n];

        n = (int) (3 * Math.pow(x, 2) - Math.pow(y, 2));
        r = n % 12;
        if (x > y && n <= limit && r == 11)
          sieve[n] = !sieve[n];
      }
    }

    constraint -= 1;
    for (int x = 5; x < constraint; x++) {
      if (!sieve[x])
        continue;

      int xSquared = (int) Math.pow(x, 2);
      for (int y = xSquared; y <= limit; y += xSquared)
        sieve[y] = false;
    }

    for (int i = 7; i <= limit; i++) {
      if (!sieve[i])
        continue;

      primes.add(i);
    }

    return primes;
  }

  /**
   * Finds the <strong>G</strong>reatest <strong>C</strong>ommon <strong>D</strong>ivider
   * (<strong>MCD</strong>) between two integers.
   * 
   * @param a The first integer to calculate the MCD from.
   * @param b The second integer to calculate the MCD from.
   * 
   * @return An <code>int</code> representing the MCD between <code>a</code> and <code>b</code>.
   */
  private static int gcd(int a, int b) {
    while (a != 0 && b != 0) {
      if (a > b)
        a %= b;
      else
        b %= a;
    }

    return a == 0 ? b : a;
  }

  /**
   * Finds the <strong>L</strong>east <strong>C</strong>ommon <strong>M</strong>ultiplier
   * (<strong>MCM</strong>) between two integers.
   * 
   * @param a The first integer to calculate the MCM from.
   * @param b The second integer to calculate the MCM from.
   * 
   * @return An <code>int</code> representing the MCM between <code>a</code> and <code>b</code>.
   */
  private static int lcm(int a, int b) {
    int mcd = KnownProblems.gcd(a, b);

    return (a * b) / mcd;
  }
}
