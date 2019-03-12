package jfunctional.concurrency.lib;

import java.util.concurrent.ForkJoinPool;

public class FunctionalContainer {

	public <T extends FunctionNode> Promise<T> p(Class<T> clazz, Object... params)  {

		return promisePool.p(clazz, params);
	}

	public <T extends FunctionNode> Object invoke(Class<T> clazz, Object... params) {
		return promisePool.invoke(clazz, params);
	}

	private PromisePool promisePool;

	private ConcurrencyMode concurrencyMode = null;
	public void concurrencyMode(ConcurrencyMode concurrencyMode) {
		this.concurrencyMode = concurrencyMode;

		switch (concurrencyMode) {

			case SINGLE_THREADED:
				promisePool = new PromiseDirectPool();
				break;
			case CONCURRENT:
				//throw new RuntimeException("Not implemented for:"+concurrencyMode);
				promisePool = new PromiseThreadPool();
				break;
			case RecursiveTask:
				promisePool = new PromiseRecursiveTaskPool();
				break;
			default:
				throw new RuntimeException("Not implemented for:"+concurrencyMode);
		}
	}

	public FunctionalContainer() {
		concurrencyMode(ConcurrencyMode.SINGLE_THREADED);
	}
}
