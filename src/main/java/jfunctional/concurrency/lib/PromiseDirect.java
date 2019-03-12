package jfunctional.concurrency.lib;

public class PromiseDirect implements Promise {
	@Override
	public Object v() {
		return fun.calculate(params);
	}

	private final FunctionNode fun;
	private final Object[] params;

	public PromiseDirect(FunctionNode fun, Object... params) {
		this.fun = fun;
		this.params = params;
	}
}
