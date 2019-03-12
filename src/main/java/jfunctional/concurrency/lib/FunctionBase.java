package jfunctional.concurrency.lib;

public abstract class FunctionBase<T extends FunctionBase> implements FunctionNode {

	private PromisePool container;

	@Override
	public Promise<T> p(Class clazz, Object... params) {

		return container.p(clazz, params);
	}

	@Override
	public void container(PromisePool cnt) {
		this.container = cnt;
	}

	//	public FunctionBase(Container container) {
//		this.container = container;
//	}
}
