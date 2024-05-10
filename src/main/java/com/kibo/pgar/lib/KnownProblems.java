package com.kibo.pgar.lib;

/**
 * <code>Class</code> for a simple implementation of some of the usual problems that you always
 * forget about and need to get on StackOverflow or GeeksForGeeks searching the algorithm even
 * though you know you have already solved them.
 * 
 * @author Alessandro Muscio (Kibo)
 */
public class KnownProblems {
	private static final String UNSUPPORTED_OP_ERR_MSG = String
			.format("%sThis class isn't instantiable!%s", AnsiColors.RED, AnsiColors.RESET);

	public KnownProblems() throws UnsupportedOperationException {
		throw new UnsupportedOperationException(KnownProblems.UNSUPPORTED_OP_ERR_MSG);
	}

	/**
	 * Finds the <strong>M</strong>aximum <strong>C</strong>ommon <strong>D</strong>ivider
	 * (<strong>MCD</strong>) between two or more integers.
	 * 
	 * @param values All the values from where to compute the MCD.
	 * 
	 * @return An <code>int</code> representing the MCD between all the values.
	 * 
	 * @throws IllegalArgumentException If <strong>less</strong> than two values are given.
	 */
	public static int mcd(int... values) throws IllegalArgumentException {
		if (values == null || values.length < 2)
			throw new IllegalArgumentException();

		int mcd = values[0];
		for (int i = 0; i < values.length; i++)
			mcd = KnownProblems.mcd(mcd, values[i]);

		return mcd;
	}

	/**
	 * Finds the <strong>M</strong>inimum <strong>C</strong>ommon <strong>M</strong>ultiplier
	 * (<strong>MCM</strong>) between two or more integers.
	 * 
	 * @param values All the values from where to compute the MCM.
	 * 
	 * @return An <code>int</code> representing the MCM between all the values.
	 * 
	 * @throws IllegalArgumentException If <strong>less</strong> than two values are given.
	 */
	public static int mcm(int... values) throws IllegalArgumentException {
		if (values == null || values.length < 2)
			throw new IllegalArgumentException();

		int mcm = values[0];
		for (int i = 0; i < values.length; i++)
			mcm = KnownProblems.mcm(mcm, values[i]);

		return mcm;
	}

	/**
	 * Counts the number of digits present in the given <code>int</code>.
	 * 
	 * @param n The <code>int</code> from which to calculate the digits.
	 * 
	 * @return An <code>int</code> representing the number of digits of <code>n</code>.
	 */
	public static int countIntegerDigits(int n) {
		return Integer.toString(n).length();
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

	/**
	 * Finds the <strong>M</strong>aximum <strong>C</strong>ommon <strong>D</strong>ivider
	 * (<strong>MCD</strong>) between two integers.
	 * 
	 * @param a The first integer to calculate the MCD from.
	 * @param b The second integer to calculate the MCD from.
	 * 
	 * @return An <code>int</code> representing the MCD between <code>a</code> and <code>b</code>.
	 */
	private static int mcd(int a, int b) {
		while (a != 0 && b != 0) {
			if (a > b)
				a %= b;
			else
				b %= a;
		}

		return a == 0 ? b : a;
	}

	/**
	 * Finds the <strong>M</strong>inimum <strong>C</strong>ommon <strong>M</strong>ultiplier
	 * (<strong>MCM</strong>) between two integers.
	 * 
	 * @param a The first integer to calculate the MCM from.
	 * @param b The second integer to calculate the MCM from.
	 * 
	 * @return An <code>int</code> representing the MCM between <code>a</code> and <code>b</code>.
	 */
	private static int mcm(int a, int b) {
		int mcd = KnownProblems.mcd(a, b);

		return (a * b) / mcd;
	}
}
