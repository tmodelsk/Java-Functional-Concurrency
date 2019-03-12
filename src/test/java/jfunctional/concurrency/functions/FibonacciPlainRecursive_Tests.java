package jfunctional.concurrency.functions;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static  jfunctional.concurrency.functions.FibonacciPlainRecursive.fibonacci;
import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciPlainRecursive_Tests {

	@Test
	public void zero_one() {
		assertThat(fibonacci(0)).isEqualTo(BigInteger.valueOf(0));
		assertThat(fibonacci(1)).isEqualTo(BigInteger.valueOf(1));
	}

	@Test
	public void two() {
		assertThat(fibonacci(2)).isEqualTo(BigInteger.valueOf(1));
	}

	@Test
	public void fib_10() {
		assertThat(fibonacci(10)).isEqualTo(BigInteger.valueOf(55));
	}

	@Test
	public void fib_20() {
		assertThat(fibonacci(20)).isEqualTo(BigInteger.valueOf(6765));
	}

	@Test
	public void fib_30() {
		assertThat(fibonacci(30)). isGreaterThan(BigInteger.valueOf(6765));
	}

	@Test
	public void fib_40() {
		assertThat(fibonacci(40)). isGreaterThan(BigInteger.valueOf(6765));
	}

	@Test
	public void fib_41() {
		assertThat(fibonacci(41)). isGreaterThan(BigInteger.valueOf(6765));
	}

	@Test
	public void fib_42() {
		assertThat(fibonacci(42)). isGreaterThan(BigInteger.valueOf(6765));
	}

	@Test
	public void fib_46() {
		assertThat(fibonacci(46)). isGreaterThan(BigInteger.valueOf(6765));
	}

    @Test
    public void fib_50() {
        assertThat(fibonacci(49)). isGreaterThan(BigInteger.valueOf(6765));
    }
}
