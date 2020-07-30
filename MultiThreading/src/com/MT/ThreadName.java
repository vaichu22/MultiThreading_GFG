package com.MT;

public class ThreadName {

    public static void main(String[] args) throws InterruptedException {

        MyThread t0 = new MyThread();
        t0.start();

        System.out.println("I am in thread : "+ Thread.currentThread().getName());
        System.out.println("Main: "+System.currentTimeMillis());

    }

    public static class MyThread extends Thread {

        @Override
        public void run() {

            System.out.println("I am in 1st thread : "+ currentThread().getName());
            System.out.println("Thread T0: "+System.currentTimeMillis());
        }
    }
}
