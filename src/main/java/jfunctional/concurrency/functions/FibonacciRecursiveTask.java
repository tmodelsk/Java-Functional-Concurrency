package jfunctional.concurrency.functions;

import lombok.val;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FibonacciRecursiveTask extends RecursiveTask<BigInteger> {
    private static final ForkJoinPool forkJoinPool = new ForkJoinPool();
    private final Integer numberForTask;

    public static BigInteger fibonacci(int number) {
        return forkJoinPool.invoke(new FibonacciRecursiveTask(number));
    }

    @Override
    protected BigInteger compute() {
        return compute(numberForTask);
    }

    public BigInteger compute(int number) {
        if (number == 0) return BigInteger.ZERO;
        if (number == 1) return BigInteger.ONE;

        int arg1 = number-1;
        int arg2 = number-2;

        return executeRecursiveStep(arg1, arg2);
    }

    private BigInteger computeRecursiveOperation(BigInteger value1, BigInteger value2) {
        return value1.add(value2);
    }

    private BigInteger executeRecursiveStep(int arg1, int arg2) {
        if (numberForTask > 35)
            return computeForking(arg1, arg2);
        else
            return computeSingleThread(arg1, arg2);
    }

    BigInteger computeForking(int arg1, int arg2) {
        val n1 = new FibonacciRecursiveTask(arg1);
        n1.fork();

        val n2 = new FibonacciRecursiveTask(arg2);
        n2.fork();

        return computeRecursiveOperation(n1.join(), n2.join());
    }

    BigInteger computeSingleThread(int arg1, int arg2) {
        return computeRecursiveOperation(compute(arg1), compute(arg2));
    }

    public FibonacciRecursiveTask(Integer numberForTask) {
        this.numberForTask = numberForTask;
    }
}
