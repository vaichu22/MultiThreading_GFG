package com.MT;

public class MT_Runnable {

    //MT_Runnable mtr = new MT_Runnable();
    //MyThread t1 = new MyThread();

    public static void main(String[] args) {
        MT_Runnable mtr = new MT_Runnable();
        MyThread t1 = mtr.new MyThread();
        Thread o = new Thread(t1);
        o.start();
        System.out.println("I am in thread :" +Thread.currentThread().getName());


    }

    public class MyThread implements Runnable {

        @Override
        public void run() {
            System.out.println("I am in thread :" +Thread.currentThread().getName());
        }
    }
}
