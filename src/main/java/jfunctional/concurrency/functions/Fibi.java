package jfunctional.concurrency.functions;

import jfunctional.concurrency.lib.Tuple;
import lombok.val;

import java.math.BigInteger;

public interface Fibi {


    default BigInteger calc(int number, Fibi fibiImp) {
        if(number == 0) return BigInteger.ZERO;
        if(number == 1) return BigInteger.ONE;

        val factors = getFactors(number-1, number-2);

        return factors.first.add(factors.second);
    }

    Tuple<BigInteger, BigInteger> getFactors(int numberFirst, int numberSecond);

}
