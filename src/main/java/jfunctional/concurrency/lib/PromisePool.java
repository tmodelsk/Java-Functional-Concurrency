package jfunctional.concurrency.lib;

public interface PromisePool {

	<T extends FunctionNode> Promise<T> p(Class<T> clazz, Object... params);


	<T extends FunctionNode> Object invoke(Class<T> clazz, Object... params);
}
