package com.MT;

import java.math.BigInteger;
import java.util.Scanner;

public class MT_Modify {

    public static void main(String[] args) throws InterruptedException {


        System.out.println("Enter the value : ");
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        BigInteger inputNumber = new BigInteger(input);
        BigInteger diff = BigInteger.ZERO;

        int arrSize = 2;

        MyThread threads[] = new MyThread[arrSize];

//        for (int i = 0; i < threads.length; i++) {
//            threads[i] = new MT_Assignment2.MyThread(inputNumber);
//            threads[i].start();
//            inputNumber = inputNumber.subtract(BigInteger.valueOf(2));
//
//
//        }
        long start = System.currentTimeMillis();
        while(inputNumber.compareTo(BigInteger.ZERO) == 1) {

            if(inputNumber.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
                threads[0] = new MyThread(inputNumber);

            } else {
                threads[1] = new MyThread(inputNumber);
                //threads[1].start();
            }
            inputNumber = inputNumber.subtract(BigInteger.ONE);

        }
        threads[0].start();
        threads[1].start();

        threads[0].join();
        threads[1].join();
        System.out.println("ans is : "+ threads[0].sum.subtract(threads[1].sum));


//        System.out.println("Heyy");
//        for (int i = 0; i < threads.length; i++) {
//
//            sum = sum.add(threads[i].diff);
//            threads[i].join();
//        }
        //System.out.println("sum is : " + diff);
        System.out.println(System.currentTimeMillis() - start);


    }

    public static class MyThread extends Thread {

        BigInteger inputNumber;
        BigInteger sum = BigInteger.ZERO;

        public MyThread(BigInteger inputNumber) {

            this.inputNumber = inputNumber;
        }


        @Override
        public void run() {
            if (this.inputNumber.compareTo(BigInteger.ZERO) == 1) {
                sum = sum.add(this.inputNumber.pow(2));
            }
        }
    }
}
