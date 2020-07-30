package com.MT;

public class MultiThreadingDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hey there!!!");

        try {
            MyThread t1 = new MyThread();
            t1.start();

        }catch(Exception e) {

            //e.printStackTrace();
            //System.out.println("Illegal Excaption from t hread T0");
        }

        //Thread.sleep(50000);
        System.out.println("I am in main thread");

    }

    private static class MyThread extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                System.out.println("I am in thread");
                //throw new IllegalArgumentException();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Heheheh");
        }

    }

}




