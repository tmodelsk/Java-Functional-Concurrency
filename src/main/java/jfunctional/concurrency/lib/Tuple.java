package jfunctional.concurrency.lib;

public class Tuple<T,S> {
    public final T first;
    public final S second;

    public Tuple(T first, S second) {
        this.first = first;
        this.second = second;
    }
}
