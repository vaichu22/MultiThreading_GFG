package com.MT;

public class MT_OuterClass extends Thread {
    @Override
    public void run() {
        System.out.println("I am in thread : "+ currentThread().getName());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("Thread T0: "+System.currentTimeMillis());
    }
}
