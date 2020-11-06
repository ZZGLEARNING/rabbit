package com.example.testmq.threadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPools {

    public static void main(String[] args) {
      //面向接口编程
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //创建线程
        //Runnable runnable=new Test();
        executorService.execute(new Test());
    }

}
