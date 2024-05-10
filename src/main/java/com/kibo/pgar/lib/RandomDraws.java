package com.kibo.pgar.lib;

import java.util.Random;

public class RandomDraws {
	private static final String UNSUPPORTED_OP_ERR_MSG = String
			.format("%sThis class isn't instantiable!%s", AnsiColors.RED, AnsiColors.RESET);
	private static final Random RAND = new Random();

	public RandomDraws() throws UnsupportedOperationException {
		throw new UnsupportedOperationException(RandomDraws.UNSUPPORTED_OP_ERR_MSG);
	}

	public static int drawInteger(int min, int max) {
		int range = max + 1 - min;
		int randInt = RAND.nextInt(range);

		return randInt + min;
	}
}
