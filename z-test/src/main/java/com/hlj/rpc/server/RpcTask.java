package com.hlj.rpc.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by hanlaijin@xiaomi.com on 18-9-5.
 */
public class RpcTask implements Runnable {
    private ServerSocket serverSocket;

    public RpcTask(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        ObjectInputStream inputStream;
        ObjectOutputStream outputStream;
        Socket socket;
        try {
            socket = serverSocket.accept();
            System.out.println("a client connect");
            inputStream = new ObjectInputStream(socket.getInputStream());
            String interfaceName = inputStream.readUTF();
            Class<?> service = Class.forName(interfaceName);
            String methodName = inputStream.readUTF();
            Class<?>[] parameterTypes = (Class<?>[]) inputStream.readObject();
            Object[] arguments = (Object[]) inputStream.readObject();
            Method method = service.getMethod(methodName, parameterTypes);
            Object result = method.invoke(service.newInstance(), arguments);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
        }
    }
}
