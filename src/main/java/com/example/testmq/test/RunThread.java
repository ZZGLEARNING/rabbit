package com.example.testmq.test;

public class RunThread {
    public static void main(String[] args) {

//        TestThread t1=new TestThread("t1");
//        t1.start();
//        TestThread t2=new TestThread("t2");
//        t2.start();
//        TestThread t3=new TestThread("t3");
//        t3.start();
        TestRun testRun=new TestRun();
        Thread t1=new Thread(testRun,"yi");
        t1.start();
        Thread t2=new Thread(testRun,"y2");
        t2.start();
        Thread t3=new Thread(testRun,"y3");
        t3.start();
    }


}
