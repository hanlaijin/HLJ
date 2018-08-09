package com.hlj.common.z.future;


/**
 * Created by hanlaijin@xiaomi.com on 18-6-5.
 */
public class RealData implements Data {
    @Override
    public String getData() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "等待了3s";
    }
}
