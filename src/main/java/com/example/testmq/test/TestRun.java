package com.example.testmq.test;

public class TestRun implements Runnable {
    private  int max=90;
    private  int index =1;
    @Override
    public void run() {
        while(index<=max){
            System.out.println(Thread.currentThread()+"index"+index++);
        }
    }
}
