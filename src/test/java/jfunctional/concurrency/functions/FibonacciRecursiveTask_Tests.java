package jfunctional.concurrency.functions;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;
import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciRecursiveTask_Tests {

	@Test
	public void fib_00() {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		val f = new FibonacciRecursiveTask(0);
		val res =  forkJoinPool.invoke(f);
		assertThat(res).isEqualTo(0);
	}

    @Test
    public void fib_01() {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        val f = new FibonacciRecursiveTask(1);
        val res =  forkJoinPool.invoke(f);
        assertThat(res).isEqualTo(1);
    }

    @Test
    public void fib_02() {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        val f = new FibonacciRecursiveTask(2);
        val res =  forkJoinPool.invoke(f);
        assertThat(res).isEqualTo(1);
    }

	@Test
	public void fib_10() {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		val f = new FibonacciRecursiveTask(10);

		val res =  forkJoinPool.invoke(f);

		assertThat(res).isEqualTo(55);
	}

    @Test
    public void fib_30() {
        assertThat(FibonacciRecursiveTask.fibonacci(30)). isGreaterThan(BigInteger.valueOf(6765));
    }

	@Test
	public void fib_40() {
        assertThat(FibonacciRecursiveTask.fibonacci(40)). isGreaterThan(BigInteger.valueOf(6765));
	}

	@Test
	public void fib_41() {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		val f = new FibonacciRecursiveTask(41);

		val res =  forkJoinPool.invoke(f);
		//forkJoinPool.invoke(f);

		assertThat(res).isNotNull();
		//assertThat(res).isEqualTo(55);
	}

	@Test
	public void fib_42() {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		val f = new FibonacciRecursiveTask(42);

		val res =  forkJoinPool.invoke(f);

		assertThat(res).isNotNull();
	}

    @Test
    public void fib_46() {
        assertThat(FibonacciRecursiveTask.fibonacci(46)).isGreaterThan(BigInteger.valueOf(6765));
    }

    @Test
    public void fib_50() {
        assertThat(FibonacciRecursiveTask.fibonacci(49)).isGreaterThan(BigInteger.valueOf(6765));
    }
}
