package jfunctional.concurrency.functions;

import java.math.BigInteger;

public class FibonacciPlainRecursive {

	public static BigInteger fibonacci(int number) {
		if(number == 0) return BigInteger.ZERO;
		if(number == 1) return BigInteger.ONE;

		return fibonacci(number-1).add(fibonacci(number-2));
	}

}
