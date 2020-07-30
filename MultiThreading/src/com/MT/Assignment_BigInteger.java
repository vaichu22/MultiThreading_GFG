package com.MT;

import java.math.BigInteger;
import java.util.Scanner;

public class Assignment_BigInteger {

    public static void main(String[] args) {
        long start =  System.currentTimeMillis();

        Scanner sc = new Scanner(System.in);
        //System.out.println("ENter teh valuse");
        //String input = sc.nextLine();

        MyThread mt = new MyThread("123456");
        System.out.println("hghghg"+ mt.calc());

        System.out.println(System.currentTimeMillis() -  start);


    }

    public static class MyThread{

        String inputValue;

        public MyThread(String inputValue) {
            this.inputValue= inputValue;
        }


        public BigInteger calc() {

            BigInteger bi1 = new BigInteger(this.inputValue);


            if (bi1.compareTo(BigInteger.ONE) == -1) {
                return BigInteger.ZERO;
            }

            System.out.println(bi1);
            BigInteger decByOne = bi1.subtract(BigInteger.ONE);
            String decByOneString = decByOne.toString();
            BigInteger bi2 = new BigInteger(decByOneString);

            BigInteger diff = (bi1.pow(2)).subtract((bi2.pow(2)));

            BigInteger decByTwo = bi1.subtract(BigInteger.valueOf(2));
            this.inputValue = decByTwo.toString();

            BigInteger valv = calc().add(diff);
            return valv;

            //return diff.add(calc());
            //return diff;

        }

    }



    }



//    BigInteger bi = BigInteger.valueOf(inputNumber);
//
//        if(inputNumber < 1) {
//        return BigInteger.valueOf(0);
//        }

        //BigInteger diff= ((BigInteger.valueOf(inputNumber).pow(2)).subtract((BigInteger.valueOf(inputNumber -1).pow(2))));
        //BigInteger diff = b1.pow(2).subtract(b2.pow(2));
//        BigInteger diff = (BigInteger.valueOf(inputNumber).multiply(BigInteger.valueOf(inputNumber))).subtract
//                ((BigInteger.valueOf(inputNumber-1).multiply(BigInteger.valueOf(inputNumber-1))));

//        BigInteger diff = bi.multiply(bi);
//        System.out.println(diff);
//        --inputNumber;
//        BigInteger diff1 = bi.multiply(bi);
//        System.out.println(diff1);
//
//        BigInteger diff3 = diff.subtract(diff);

        //return diff3.add((calc(inputNumber-=2)));