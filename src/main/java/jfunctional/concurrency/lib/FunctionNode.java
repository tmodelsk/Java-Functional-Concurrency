package jfunctional.concurrency.lib;

public interface FunctionNode<T> {

	Object calculate(final Object... params);

	Promise<T> p(Class clazz, Object... params);

	void container(PromisePool cnt);

	default boolean shouldFork() { return true; }

	default boolean shouldFork(final Object... params) { return true; }

	//T create();

}
