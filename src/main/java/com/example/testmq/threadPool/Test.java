package com.example.testmq.threadPool;

import java.util.HashMap;
import java.util.Map;

class Test implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--");
        Map map=new HashMap<>();
        map.put("stat","ewe");
    }
}