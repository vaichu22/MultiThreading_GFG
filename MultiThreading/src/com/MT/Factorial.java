package com.MT;

import java.math.BigInteger;

public class Factorial {

    public static void main(String[] args) {

        MyThread obj = new MyThread();

        long start =  System.currentTimeMillis();

        //int[] arr = {5,8,2,3,6,23,120};
        int[] arr = {10000, 20000, 30000, 60000, 7700, 4000, 5000, 7000, 15000, 40000, 50000,100000};

        for(int i=0; i<arr.length;i++) {
            System.out.println(obj.factorial(arr[i]) + "\n");
        }

        System.out.println("Time taken : "+ (System.currentTimeMillis() - start));

    }

    public static class MyThread extends Thread {

//        @Override
//        public void run() {
//
//        }

        public BigInteger factorial(int num) {
            BigInteger bi = BigInteger.valueOf(1);

            for(int i=2;i<=num;i++){
                bi = bi.multiply(BigInteger.valueOf(i));
            }
            return bi;
        }
    }
}
