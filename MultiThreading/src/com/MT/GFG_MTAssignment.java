package com.MT;

import java.math.BigInteger;
import java.util.Scanner;

public class GFG_MTAssignment {

    public static BigInteger inputNumber;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Enter the value to find sum of squares of differences between even&odd Numbers: ");
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        inputNumber = new BigInteger(input);

        long start = System.currentTimeMillis();

        EvenNumbers evenNumberObj = new EvenNumbers();
        OddNumbers oddNumberObj = new OddNumbers();

        Thread evenNumberThread= new Thread(evenNumberObj);
        Thread oddNumberThread= new Thread(oddNumberObj);

        if(inputNumber.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
            evenNumberThread.start();
            oddNumberThread.start();

            evenNumberThread.join();
            oddNumberThread.join();

        } else {
            oddNumberThread.start();
            evenNumberThread.start();

            oddNumberThread.join();
            evenNumberThread.join();

        }

        if(evenNumberObj.sum.compareTo(oddNumberObj.sum) == 1) {
            System.out.println("Answer :"+ evenNumberObj.sum.subtract(oddNumberObj.sum));
        } else {
            System.out.println("Answer :"+oddNumberObj.sum.subtract(evenNumberObj.sum));
        }
        System.out.println(System.currentTimeMillis() -  start);
    }


    // Calculation of sum of squares of even numbers
    private static class EvenNumbers implements Runnable{

        BigInteger input = GFG_MTAssignment.inputNumber;
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
    private static class OddNumbers implements Runnable {

        BigInteger input1 = GFG_MTAssignment.inputNumber.subtract(BigInteger.ONE);
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


