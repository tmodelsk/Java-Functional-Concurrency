package jfunctional.concurrency.lib;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureDirect<T> implements Future<T> {
	@Override
	public boolean cancel(boolean b) {
		throw new RuntimeException("Not implemented!");
	}

	@Override
	public boolean isCancelled() {
		return false;
	}

	@Override
	public boolean isDone() {
		return true;
	}

	@Override
	public T get() {
		return null;
	}

	@Override
	public T get(long l, TimeUnit timeUnit) {
		throw new RuntimeException("Not implemented!");
	}
}
