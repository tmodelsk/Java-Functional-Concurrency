package jfunctional.concurrency.functions;

import jfunctional.concurrency.lib.FunctionBase;
import jfunctional.concurrency.lib.FunctionNode;
import lombok.val;

import java.math.BigInteger;

public class Factorial extends FunctionBase<Factorial> implements FunctionNode {

//	public BigInteger calculate(Object params) {
//		return calculate((Integer)params);
//	}

	public Factorial create() {
		return null;
	}

	public BigInteger calculate(Integer num) {

		if(num == 0) return BigInteger.ONE;
		if(num == 1) return BigInteger.ONE;

		val p = p(Factorial.class, num-1);

		val res = (BigInteger)p.v();
		//res = res.multiply(BigInteger.valueOf(num));

		return res;
	}

	@Override
	public Object calculate(Object... params) {
		return calculate((Integer)params[0]);
	}

//	public Factorial(Container container) {
//		super(container);
//	}
}
