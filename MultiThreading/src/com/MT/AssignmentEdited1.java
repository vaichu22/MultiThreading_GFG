package com.MT;

import java.math.BigInteger;
import java.util.Scanner;

public class AssignmentEdited1 {

    public static BigInteger inputNumber;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("Enter the value : ");
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        inputNumber = new BigInteger(input);

        MyThread1 mt1 = new MyThread1();
        MyThread2 mt2 = new MyThread2();

        Thread t1= new Thread(mt1);
        Thread t2= new Thread(mt2);


        t1.start();
        t2.start();

        t1.join();
        t2.join();


        if(mt1.sum.compareTo(mt2.sum) == 1) {
            System.out.println("ans is :"+ mt1.sum.subtract(mt2.sum));
        } else {
            System.out.println("ans is :"+mt2.sum.subtract(mt1.sum));
        }
        //System.out.println("ans is :"+ mt1.sum.subtract(mt2.sum));
        System.out.println(System.currentTimeMillis() -  start);
    }

    private static class MyThread1 implements Runnable{

        BigInteger input = AssignmentEdited1.inputNumber;
        BigInteger sum = BigInteger.ZERO;

        @Override
        public void run() {
            while(input.compareTo(BigInteger.ZERO) == 1) {

                if(input.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
                    sum = sum.add(input.pow(2));
                }
                input = input.subtract(BigInteger.valueOf(1));
            }
        }
    }

    private static class MyThread2 implements Runnable {

        BigInteger input = AssignmentEdited1.inputNumber;
        BigInteger sum = BigInteger.ZERO;


        @Override
        public void run() {
            while(input.compareTo(BigInteger.ZERO) == 1) {

                if(!input.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
                    sum = sum.add(input.pow(2));
                }
                input = input.subtract(BigInteger.valueOf(1));
            }
        }
    }

}



