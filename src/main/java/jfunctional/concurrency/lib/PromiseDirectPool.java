package jfunctional.concurrency.lib;

import lombok.val;

public class PromiseDirectPool implements PromisePool {

	public <T extends FunctionNode> Promise<T> p(Class<T> clazz, Object... params)  {

		T fun;

		try {
			fun = clazz.newInstance();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

		fun.container(this);

		return new PromiseDirect(fun, params);
	}

	@Override
	public <T extends FunctionNode> Object invoke(Class<T> clazz, Object... params) {
		val p = p(clazz, params);

		return p.v();
	}

}
