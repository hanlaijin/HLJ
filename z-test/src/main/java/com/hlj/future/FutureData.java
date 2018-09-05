package com.hlj.future;

/**
 * Created by hanlaijin@xiaomi.com on 18-6-5.
 */
public class FutureData implements Data {

    public RealData realData;

    public boolean init = false;

    public synchronized void set(RealData realData) {
        if (init) {
            return;
        }
        this.realData = realData;
        this.init = true;
        this.notify();
    }

    @Override
    public synchronized String getData() {
        while (!init) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getData();
    }
}
