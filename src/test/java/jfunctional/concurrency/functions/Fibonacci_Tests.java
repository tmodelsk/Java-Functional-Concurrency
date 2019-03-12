package jfunctional.concurrency.functions;

import jfunctional.concurrency.lib.ConcurrencyMode;
import jfunctional.concurrency.lib.FunctionalContainer;
import lombok.val;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class Fibonacci_Tests {

	private FunctionalContainer createContainer() {
        val cnt = new FunctionalContainer();
		
		cnt.concurrencyMode(ConcurrencyMode.RecursiveTask);
		
		return cnt;
	}
	
	@Test
	public void zero() {
		val cont = createContainer();
		Object resObj = cont.invoke(Fibonacci.class, 0);

		assertThat(resObj).isNotNull();
		val res = (BigInteger)resObj;
		assertThat(res).isEqualTo(0);
	}

	@Test
	public void one() {
		val cont = createContainer();

		val res = (BigInteger)cont.invoke(Fibonacci.class, 1);

		assertThat(res).isEqualTo(1);
	}

	@Test
	public void two() {
		val cont = createContainer();

		val res = (BigInteger) cont.invoke(Fibonacci.class, 2);
		assertThat(res).isEqualTo(1);
	}

	@Test
	public void fib_03() {
		val cont = createContainer();
		Object resObj = cont.invoke(Fibonacci.class, 3);

		assertThat(resObj).isNotNull();
		val res = (BigInteger)resObj;
		assertThat(res).isEqualTo(2);
	}

	@Test
	public void fib_04() {
		val cont = createContainer();
		Object resObj = cont.invoke(Fibonacci.class, 4);

		assertThat(resObj).isNotNull();

		val res = (BigInteger)resObj;
		assertThat(res).isEqualTo(3);
	}

	@Test
	public void fib_05() {
		val cont = createContainer();
		Object resObj = cont.invoke(Fibonacci.class, 5);

		assertThat(resObj).isNotNull();

		val res = (BigInteger)resObj;
		assertThat(res).isEqualTo(5);
	}

	@Test
	public void fib_10() {
		val cont = createContainer();
		Object resObj = cont.invoke(Fibonacci.class, 10);

		assertThat(resObj).isNotNull();

		val res = (BigInteger)resObj;
		assertThat(res).isEqualTo(55);
	}

	@Test
	public void fib_20() {
		val cont = createContainer();
		Object resObj = cont.invoke(Fibonacci.class, 20);
		assertThat(resObj).isNotNull();

		val res = (BigInteger)resObj;
		assertThat(res).isEqualTo(6765);
	}

	@Test
	public void fib_30() {
		val cont = createContainer();
		Object resObj = cont.invoke(Fibonacci.class, 30);
		assertThat(resObj).isNotNull();

		val res = (BigInteger)resObj;
		assertThat(res).isGreaterThan(BigInteger.valueOf(6765));
	}

	@Test
	public void fib_40() {
		val cont = createContainer();
		Object resObj = cont.invoke(Fibonacci.class, 40);
		assertThat(resObj).isNotNull();

		val res = (BigInteger)resObj;
		assertThat(res).isGreaterThan(BigInteger.valueOf(6765));
	}

	@Test
	public void fib_41() {
		val cont = createContainer();
		Object resObj = cont.invoke(Fibonacci.class, 41);
		assertThat(resObj).isNotNull();

		val res = (BigInteger)resObj;
		assertThat(res).isGreaterThan(BigInteger.valueOf(6765));
	}

	@Test
	public void fib_42() {
		val cont = createContainer();
		Object resObj = cont.invoke(Fibonacci.class, 42);
		assertThat(resObj).isNotNull();

		val res = (BigInteger)resObj;
		assertThat(res).isGreaterThan(BigInteger.valueOf(6765));
	}

	@Test @Disabled
	public void fib_50() {
		val cont = createContainer();
		val p = cont.p(Fibonacci.class, 50);

		Object resObj = p.v();
		assertThat(resObj).isNotNull();

		val res = (BigInteger)resObj;
		assertThat(res).isGreaterThan(BigInteger.valueOf(6765));
	}
}
