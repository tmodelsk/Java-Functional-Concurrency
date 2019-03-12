package jfunctional.concurrency.functions;

import jfunctional.concurrency.lib.FunctionalContainer;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class Integral_Tests {

	@Test
	public void zero() {
		val cont = new FunctionalContainer();

		val p = cont.p(Factorial.class, 0);

		Object resObj = p.v();

		assertThat(resObj).isNotNull();

		val res = (BigInteger)resObj;
		assertThat(res).isEqualTo(1);
	}

	@Test
	public void one() {
		val cont = new FunctionalContainer();

		val p = cont.p(Factorial.class, 1);

		Object resObj = p.v();

		assertThat(resObj).isNotNull();

		val res = (BigInteger)resObj;
		assertThat(res).isEqualTo(1);
	}

	@Test
	public void factorial_10() {
		val cont = new FunctionalContainer();

		val p = cont.p(Factorial.class, 10);

		Object resObj = p.v();

		assertThat(resObj).isNotNull();

		val res = (BigInteger)resObj;
		assertThat(res).isEqualTo(3628800);
	}

	@Test
	public void factorial_100() {
		val cont = new FunctionalContainer();

		val p = cont.p(Factorial.class, 100);

		Object resObj = p.v();

		assertThat(resObj).isNotNull();

		val res = (BigInteger)resObj;

		val tenTo157 = BigInteger.valueOf(10).pow(157);

		assertThat(res).isGreaterThan(tenTo157);
	}

	@Test
	public void factorial_1000() {
		val cont = new FunctionalContainer();

		val p = cont.p(Factorial.class, 1000);

		Object resObj = p.v();

		assertThat(resObj).isNotNull();

		val res = (BigInteger)resObj;

		val tenTo157 = BigInteger.valueOf(10).pow(157);

		assertThat(res).isGreaterThan(tenTo157);
	}

	@Test
	public void factorial_2000() {
		val cont = new FunctionalContainer();

		val p = cont.p(Factorial.class, 2000);

		Object resObj = p.v();

		assertThat(resObj).isNotNull();

		val res = (BigInteger)resObj;

		val tenTo157 = BigInteger.valueOf(10).pow(157);

		assertThat(res).isGreaterThan(tenTo157);
	}
}
