package jfunctional.concurrency.lib;

import lombok.val;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class PromiseThreadPool  implements PromisePool  {


	@Override
	public <T extends FunctionNode> Promise<T> p(Class<T> clazz, Object... params) {

		T fun;

		try {
			fun = clazz.newInstance();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

		fun.container(this);

		val future = executor.submit( () -> fun.calculate(params) );
		val p = new PromiseThreaded(fun, params, future);

//		try {
//			val obj = future.get();
//			if(obj != null) {
//				val os = obj.toString();
//				val oss = os;
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}

		return p;
	}

	@Override
	public <T extends FunctionNode> Object invoke(Class<T> clazz, Object... params) {
		val p = p(clazz, params);

		return p.v();
	}

	public PromiseThreadPool() {
		//executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	}

	private ThreadPoolExecutor executor;
}
