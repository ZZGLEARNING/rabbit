package com.example.testmq.test;

/**
 * Thread 实现了Runnable 接口
 */
public class TestThread extends Thread{
    private static int max=50;
    private static int index =1;
    private String name;

    /**
     * 关于静态变量的说明
     * 1.静态变量随着累的加载而加载，并且储存在静态变量区域
     * 2.静态变量的值是共享的，所以index的比赋值之后是被共享的所以，多个线程之间的值是相同的所以，只会被操作一次
     * @param name
     */

    public TestThread(String name){
        this.name=name;
    }

    @Override
    public void run() {
       while(index<=max){
           System.out.println("index"+index++);
       }
    }
}
