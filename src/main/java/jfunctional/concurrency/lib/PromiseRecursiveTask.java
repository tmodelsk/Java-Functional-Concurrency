package jfunctional.concurrency.lib;

import java.util.concurrent.RecursiveTask;

public class PromiseRecursiveTask extends RecursiveTask<Object> implements Promise {
	@Override
	protected Object compute() {
		//return join();

		result = fun.calculate(params);

		return result;
	}

	private Object result;

	@Override
	public Object v() {
		return join();
	}

	private final FunctionNode fun;
	private final Object[] params;

	public PromiseRecursiveTask(FunctionNode fun, Object[] params) {
		this.fun = fun;
		this.params = params;

		//fork();
	}
}
