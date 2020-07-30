package com.MT;

//import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.math.BigInteger;
import java.util.Scanner;

public class Assignment {

    public static void main(String[] args) {

        long start =  System.currentTimeMillis();
        System.out.println("Enter the value : ");
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();


        BigInteger ans = calc(input);
        System.out.println(ans);
        System.out.println(System.currentTimeMillis() -  start);


    }


    public static BigInteger calc(String input) {

        BigInteger inputNumber = new BigInteger(input);
        BigInteger sum = BigInteger.ZERO;
        while(inputNumber.compareTo(BigInteger.ZERO) == 1) {
            BigInteger diff = (inputNumber.pow(2)).subtract((inputNumber.subtract(BigInteger.ONE).pow(2)));
            //long diff= (long) ((Math.pow(inputNumber,2)) - (Math.pow(inputNumber-1 , 2)));
            //sum+=diff;
            sum = sum.add(diff);
            inputNumber = inputNumber.subtract(BigInteger.valueOf(2));
        }
        return sum;
    }
}



//int inputNumberCopy = inputNumber;
//int sum = 0;

//recursiom
//        if(inputNumber < 1) {
//            return 0;
//        }
//
//            long diff= (long) ((Math.pow(inputNumber,2)) - (Math.pow(inputNumber-1 , 2)));
//
//
//            return diff + calc(inputNumber-=2);

// ------

//return (inputNumberCopy%2 == 0) ? sum : sum+1;

//(100^2 - 99^2)+ (98^2 - 97^2)+ ....(2^2- 1^2)

//sum+= ((Math.pow(calc(inputNumber), 2)) - (Math.pow(calc(inputNumber-1), 2)));

//for loop
//        int sum = 0;
//        while(inputNumber > 0 ) {
//            long diff= (long) ((Math.pow(inputNumber,2)) - (Math.pow(inputNumber-1 , 2)));
//            sum+=diff;
//            inputNumber-=2;
//        }
//        return sum;
