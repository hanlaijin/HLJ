package com.hlj.common.dtos.thrift;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;

import javax.annotation.Nullable;

public class CallbackFuture<V> extends AbstractFuture<V> implements ListenableFuture<V> {

    public static <V> CallbackFuture<V> create() {
        return new CallbackFuture<V>();
    }

    @Override
    public boolean set(@Nullable V value) {
        return super.set(value);
    }
}