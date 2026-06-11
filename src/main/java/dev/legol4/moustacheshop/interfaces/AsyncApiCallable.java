package dev.legol4.moustacheshop.interfaces;

import java.util.concurrent.CompletableFuture;

@FunctionalInterface
public interface AsyncApiCallable<T> {
    CompletableFuture<T> call();
}
