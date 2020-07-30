package com.MT;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class MT_Assignment1 extends Thread{

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Enter the value : ");
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        BigInteger inputNumber = new BigInteger(input);
        BigInteger sum = BigInteger.ZERO;


        ArrayList<MyThread> list = new ArrayList<>();
        //int integerValue = inputNumber.intValue();
        long start =  System.currentTimeMillis();

        for (BigInteger bi = inputNumber;
             bi.compareTo(BigInteger.ZERO) == 1;
             bi = bi.subtract(BigInteger.valueOf(2))) {

            MyThread obj = new MyThread(bi);
            list.add(obj);
            obj.start();
        }

        for(MyThread mt : list) {
            sum = sum.add(mt.diff);
            mt.join();
        }



        System.out.println("sum : "+sum);
        System.out.println(System.currentTimeMillis() -  start);
    }

    private static class MyThread extends Thread{

        BigInteger inputNumber;
        BigInteger diff;

        public MyThread(BigInteger inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            calc();
        }

        public void calc() {
            diff = (this.inputNumber.pow(2)).subtract((this.inputNumber.subtract(BigInteger.ONE).pow(2)));
        }
    }


}


// sum = sum.add(threads[i].diff);
//            threads[i].join();

//        int noOfDigits = inputNumber.toString().length();
//        int arrSize;
//        if(noOfDigits%2 == 0)
//            arrSize = noOfDigits/2;
//        else
//            arrSize = noOfDigits/2 +1;

//        MyThread threads[] = new MyThread[arrSize];
//
//        for(int i=0; i<threads.length;i++) {
//            MyThread obj = new MyThread(inputNumber);
//            threads[i].start();
//            inputNumber.subtract(BigInteger.valueOf(2));
//        }


//        System.out.println("heyy");
//                System.out.println(list.size());
