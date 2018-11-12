package com.hlj.rpc.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by hanlaijin@xiaomi.com on 18-9-10.
 */
public class RpcHandler implements InvocationHandler {

    Class<?> clazz;

    public RpcHandler(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ObjectInputStream inputStream;
        ObjectOutputStream outputStream;
        Socket socket;
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress("localhost", 13345));
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeUTF(clazz.getName());
            outputStream.writeUTF(method.getName());
            outputStream.writeObject(method.getParameterTypes());
            outputStream.writeObject(args);
            inputStream = new ObjectInputStream(socket.getInputStream());
            return inputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
        }
        return null;
    }
}
