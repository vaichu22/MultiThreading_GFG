package com.MT;

import java.math.BigInteger;

public class MT_Factorial {

    public static void main(String[] args) throws InterruptedException {

        //MyThread obj = new MyThread();
        //MyThread threads = null;
        //int[] arr = {5,8,2,3,6,23,120};
        int[] arr = {10000, 20000, 30000, 60000, 7700, 4000, 5000, 7000, 15000, 40000, 50000, 100000};
        long start =  System.currentTimeMillis();

        MyThread threads[] = new MyThread[arr.length];  //[obj1, obj2]  obj1.


        for(int i=0;i<threads.length;i++) {
            threads[i] = new MyThread(arr[i]);
            threads[i].start();
        }

        for(int i=0; i<threads.length;i++) {
            threads[i].join();
            System.out.println(threads[i].bi);
        }

        System.out.println("Time taken : "+ (System.currentTimeMillis() - start));

    }

    public static class MyThread extends Thread {
        int num;
        BigInteger bi;
        public MyThread(int num) {

            this.num = num;
            //bi = BigInteger.valueOf(1);
        }

        @Override
        public void run() {

            factorial(this.num);
        }

        public void factorial(int num) {
            bi = BigInteger.valueOf(1);

            for(int i=2;i<=num;i++){
                bi = bi.multiply(BigInteger.valueOf(i));
            }
            //return bi;
        }
    }
}

