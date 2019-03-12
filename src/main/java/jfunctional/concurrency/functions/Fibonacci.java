package jfunctional.concurrency.functions;

import jfunctional.concurrency.lib.FunctionBase;
import jfunctional.concurrency.lib.FunctionNode;
import lombok.val;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Fibonacci extends FunctionBase<Fibonacci> implements FunctionNode {

	//private Integer num;

	public BigInteger calculate(Integer number) {
		if(number == 0) return BigInteger.ZERO;
		if(number == 1) return BigInteger.ONE;

		val n1 = p(Fibonacci.class, number-1);
		val n2 = p(Fibonacci.class, number-2);

		return ((BigInteger)n1.v()).add((BigInteger)n2.v());
	}

	@Override
	public BigInteger calculate(Object... params) {
		return calculate((Integer)params[0]);
	}

	@Override
	public boolean shouldFork(Object... params) {
		return ((Integer)params[0] % 5) == 0 ;
	}

	public Fibonacci() {
	}
}
