package com.filichkin.blog.completable.future.recursion;


import java.util.concurrent.CompletableFuture;

public class TestCompletableFuture {
    public static void main(String[] args) {
//        increment(1); // StackOverFlow
        incrementCF(1).join();// Works fine
    }

    public static CompletableFuture<Long> incrementCF(long l){
        return CompletableFuture.supplyAsync(() -> {
            long a=l+1;
            System.out.println(a);
            return a;
        }).thenCompose(x->incrementCF(x));
    }

    public static long increment(long l){
        long a=l+1;
        System.out.println(a);
        return increment(a);
    }
}