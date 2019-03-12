package jfunctional.concurrency.lib;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class PromiseThreaded implements Promise {
	@Override
	public Object v() {
		Object resObj = null;

		try {

			while(!future.isDone()) {
				Thread.sleep(50);
			}

			resObj = future.get();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} catch (ExecutionException e) {
			throw new RuntimeException(e);
		}

		return resObj;
	}

	private final FunctionNode fun;
	private final Object[] params;
	//private final AbstractExecutorService executorService;
	private final Future future;

	public PromiseThreaded(FunctionNode fun, Object[] params, Future f) {	// AbstractExecutorService executorService
		this.fun = fun;
		this.params = params;
		this.future = f;
		//this.executorService = executorService;

		//future = executorService.submit( () -> v() );	// RUN !!

//		Object obj = null;
//		try {
//			obj = future.get();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}
//
//		if(obj != null) {
//			String x = "aaa";
//		}

	}
}
