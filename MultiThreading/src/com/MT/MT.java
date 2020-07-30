package com.MT;

import java.math.BigInteger;
import java.util.Scanner;

public class MT {

    public static BigInteger inputNumber;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Enter the value to find sum of squares of differences between even&odd Numbers: ");
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        inputNumber = new BigInteger(input);

        long start = System.currentTimeMillis();

        MyThread11 mt1 = new MyThread11();
        MyThread12 mt2 = new MyThread12();

        Thread t1= new Thread(mt1);
        Thread t2= new Thread(mt2);

        if(inputNumber.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
            t1.start();
            t2.start();

            t1.join();
            t2.join();

        } else {
            t2.start();
            t1.start();

            t2.join();
            t1.join();

        }

        if(mt1.sum.compareTo(mt2.sum) == 1) {
            System.out.println("Answer :"+ mt1.sum.subtract(mt2.sum));
        } else {
            System.out.println("Answer :"+mt2.sum.subtract(mt1.sum));
        }
        System.out.println(System.currentTimeMillis() -  start);
    }


    // Calculation of sum of squares of even numbers
    private static class MyThread11 implements Runnable{

        BigInteger input = MT.inputNumber;
        BigInteger sum = BigInteger.ZERO;

        @Override
        public void run() {
            while(input.compareTo(BigInteger.ONE) == 1) {
                sum = sum.add(input.pow(2));
                input = input.subtract(BigInteger.valueOf(2));
            }
        }
    }

    // Calculation of sum of squares of odd numbers
    private static class MyThread12 implements Runnable {

        BigInteger input1 = MT.inputNumber.subtract(BigInteger.ONE);
        BigInteger sum = BigInteger.ZERO;


        @Override
        public void run() {
            while(input1.compareTo(BigInteger.ZERO) == 1) {
                sum = sum.add(input1.pow(2));
                input1 = input1.subtract(BigInteger.valueOf(2));
            }
        }
    }

}




