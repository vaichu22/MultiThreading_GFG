package com.MT;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class AssignmentEdited {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("Enter the value : ");
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        BigInteger inputNumber = new BigInteger(input);

        MyThread1 mt1 = new MyThread1(inputNumber);
        MyThread2 mt2 = new MyThread2(inputNumber);


        mt1.start();
        mt2.start();

        mt1.join();
        mt2.join();

        if(mt1.sum.compareTo(mt2.sum) == 1) {
            System.out.println("ans is :"+ mt1.sum.subtract(mt2.sum));
        } else {
            System.out.println("ans is :"+mt2.sum.subtract(mt1.sum));
        }
        //System.out.println("ans is :"+ mt1.sum.subtract(mt2.sum));
        System.out.println(System.currentTimeMillis() -  start);
    }

    private static class MyThread1 extends Thread{

        BigInteger inputNumber;
        BigInteger sum = BigInteger.ZERO;

        public MyThread1(BigInteger inputNumber) {

            this.inputNumber = inputNumber;
        }
        @Override
        public void run() {
            while(this.inputNumber.compareTo(BigInteger.ZERO) == 1) {

                if(this.inputNumber.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
                    sum = sum.add(this.inputNumber.pow(2));
                }
                this.inputNumber = this.inputNumber.subtract(BigInteger.valueOf(1));
            }
        }
    }

    private static class MyThread2 extends Thread {

        BigInteger inputNumber;
        BigInteger sum = BigInteger.ZERO;

        public MyThread2(BigInteger inputNumber) {

            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            while(this.inputNumber.compareTo(BigInteger.ZERO) == 1) {

                if(!this.inputNumber.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
                    sum = sum.add(this.inputNumber.pow(2));
                }
                this.inputNumber = this.inputNumber.subtract(BigInteger.valueOf(1));
            }
        }
    }

}


//    public void run() {
//        for (BigInteger bi = this.inputNumber;
//             bi.compareTo(BigInteger.ZERO) == 1;
//             bi = bi.subtract(BigInteger.valueOf(1))) {
//
//            if(bi.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
//                sum = sum.add(bi.pow(2));
//            }
//
//        }
//    }