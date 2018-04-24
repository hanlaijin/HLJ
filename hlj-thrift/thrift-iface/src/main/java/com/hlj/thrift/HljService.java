package com.hlj.thrift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("HljService")
public interface HljService
{
    @ThriftService("HljService")
    public interface Async
    {
        @ThriftMethod(value = "ping")
        ListenableFuture<String> ping();

        @ThriftMethod(value = "getUserFromDB")
        ListenableFuture<User> getUserFromDB(
            @ThriftField(value=1, name="mobile", requiredness=Requiredness.NONE) final String mobile
        );

        @ThriftMethod(value = "saveUserToRedis")
        ListenableFuture<Boolean> saveUserToRedis(
            @ThriftField(value=1, name="user", requiredness=Requiredness.NONE) final User user
        );

        @ThriftMethod(value = "getUserFromRedis")
        ListenableFuture<User> getUserFromRedis(
            @ThriftField(value=1, name="mobile", requiredness=Requiredness.NONE) final String mobile
        );
    }
    @ThriftMethod(value = "ping")
    String ping() throws org.apache.thrift.TException;

    @ThriftMethod(value = "getUserFromDB")
    User getUserFromDB(
        @ThriftField(value=1, name="mobile", requiredness=Requiredness.NONE) final String mobile
    ) throws org.apache.thrift.TException;

    @ThriftMethod(value = "saveUserToRedis")
    boolean saveUserToRedis(
        @ThriftField(value=1, name="user", requiredness=Requiredness.NONE) final User user
    ) throws org.apache.thrift.TException;

    @ThriftMethod(value = "getUserFromRedis")
    User getUserFromRedis(
        @ThriftField(value=1, name="mobile", requiredness=Requiredness.NONE) final String mobile
    ) throws org.apache.thrift.TException;
}