package dev.legol4.moustacheshop.interfaces;

@FunctionalInterface
public interface ApiCallable<T> {
    T call() throws Exception;
}
