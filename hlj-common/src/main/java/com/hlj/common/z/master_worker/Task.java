package com.hlj.common.z.master_worker;

import lombok.Data;

import java.util.Random;

/**
 * Created by hanlaijin@xiaomi.com on 18-6-7.
 */
@Data
public class Task {
    private Integer id;
    private Integer price;

    public Task(int id, int price) {
        this.id = id;
        this.price = price;
    }

    public static void main(String[] args) {
        Master master = new Master(Runtime.getRuntime().availableProcessors()); //8
        Random random = new Random();
        for (int i = 0; i < 64; i++) {
            Task task = new Task(i, random.nextInt(500));
            master.submit(task);
        }
        long start = System.currentTimeMillis();
        master.execute();
        while(true){
            if(master.isComplete()){
                long end  = System.currentTimeMillis() - start;
                int ret = master.getResult();
                System.out.println("计算结果:"+ret+",执行耗时:"+end);
                break;
            }
        }
    }
}
