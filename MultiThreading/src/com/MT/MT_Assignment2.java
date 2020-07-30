package com.MT;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class MT_Assignment2 extends Thread{

    public static void main(String[] args) throws InterruptedException {
        long start =  System.currentTimeMillis();

        System.out.println("Enter the value : ");
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        BigInteger inputNumber = new BigInteger(input);
        BigInteger sum = BigInteger.ZERO;
        int arrSize;

        int integerValue = inputNumber.intValue();
        System.out.println("int is : "+integerValue);

        if(integerValue%2 == 0) {
            arrSize = integerValue/2;
        }
        else {
            arrSize = integerValue/2 +1;
        }

        System.out.println(arrSize);
        MyThread threads[] = new MyThread[arrSize];

        for(int i=0; i<threads.length;i++) {
            threads[i] = new MyThread(inputNumber);
            threads[i].start();
            inputNumber = inputNumber.subtract(BigInteger.valueOf(2));
        }

        System.out.println("Heyy");
        for(int i=0; i<threads.length;i++) {

            sum = sum.add(threads[i].diff);
            threads[i].join();
        }
        System.out.println("sum is : "+sum);
        System.out.println(System.currentTimeMillis() -  start);


    }

    public static class MyThread extends Thread{

        BigInteger inputNumber;
        BigInteger diff;

        public MyThread(BigInteger inputNumber) {

            this.inputNumber = inputNumber;
        }


        @Override
        public void run() {
            if(this.inputNumber.compareTo(BigInteger.ZERO) == 1) {
                diff = (this.inputNumber.pow(2)).subtract((this.inputNumber.subtract(BigInteger.ONE).pow(2)));
            }
        }

//        public void calc() {
//
//            if(this.inputNumber.compareTo(BigInteger.ZERO) == 1) {
//                diff = (this.inputNumber.pow(2)).subtract((this.inputNumber.subtract(BigInteger.ONE).pow(2)));
//            }
//
//        }


    }



}


//  for(int i=0;i<threads.length;i++){
//        threads[i] = new MyThread(inputNumber);
//        threads[i].start();
//        inputNumber = inputNumber.subtract(BigInteger.valueOf(2));
//        }
//
//        System.out.println(threads.length);
//        for(int i=0;i<threads.length;i++){
//
//        sum = sum.add(threads[i].diff);
//        threads[i].join();
//        }


//for(int i=0; i<=threads.length;i++) {
//
//        if(i == threads.length) {
//        MyThread obj = new MyThread(inputNumber);
//        obj.join();
//        sum = sum.add(obj.diff);
//        }
//
//        MyThread obj = new MyThread(inputNumber);
//        obj.start();
//        inputNumber.subtract(BigInteger.valueOf(2));
//
//
//        }
