package com.MT;

public class OddEven {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable1();
        Thread t = new Thread(r);
        Runnable r2 = new Runnable2();
        Thread t2 = new Thread(r2);
        t.start();
        t2.start();

        t.join();
        t2.join();
    }
}

class Runnable2 implements Runnable{
    public void run(){
        System.out.println(System.currentTimeMillis());
        for(int i=0;i<1100;i+=2) {
            System.out.println(i);
        }
    }
}

class Runnable1 implements Runnable{
    public void run(){
        System.out.println(System.currentTimeMillis());
        for(int i=1;i<=1100;i+=2) {
            System.out.println(i);
        }
    }
}
