package jfunctional.concurrency.lib;

import lombok.val;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

public class PromiseRecursiveTaskPool implements PromisePool {

	private static int activeThreadsCountMax = 0;
	private static int poolSizeMax = 0;
	private static long queuedTaskCountMax = 0;

	@Override
	public <T extends FunctionNode> Promise<T> p(Class<T> clazz, Object... params) {

		val fjp = forkJoinPool;	// ForkJoinPool.commonPool()

		//val activeThreadsCount = fjp.getActiveThreadCount();
		//val poolSize = fjp.getPoolSize();
		//val queuedTaskCount = fjp.getQueuedTaskCount();

		//activeThreadsCountMax = Math.max(activeThreadsCount, activeThreadsCountMax);
		//poolSizeMax = Math.max(poolSize, poolSizeMax);
		//queuedTaskCountMax = Math.max(queuedTaskCount, queuedTaskCountMax);

//		System.out.println(String.format("activeThreadsCount=%s  poolSize=%s queuedTaskCount=%s  params=%s",
//				activeThreadsCount, poolSize, queuedTaskCount, params[0]));

		T fun;

		try {
			fun = clazz.newInstance();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

		fun.container(this);

		Promise p;
		if( fun.shouldFork(params) ) {	// activeThreadsCount < 5 queuedTaskCount < 3
			val prt = new PromiseRecursiveTask(fun, params);
			prt.fork();
			p = prt;
		}
		else {
			p = new PromiseDirect(fun, params);
		}

		return p;
	}

	private final ForkJoinPool forkJoinPool = new ForkJoinPool(8);

	@Override
	public <T extends FunctionNode> Object invoke(Class<T> clazz, Object... params) {

		T fun;

		try {
			fun = clazz.newInstance();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

		fun.container(this);

		val p = new PromiseRecursiveTask(fun, params);

		val res = forkJoinPool.invoke(p);

		System.out.println(String.format("activeThreadsCount=%s  poolSize=%s queuedTaskCount=%s ",
				activeThreadsCountMax, poolSizeMax, queuedTaskCountMax));

		return res;
	}
}
