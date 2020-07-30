package com.MT;

import java.math.BigInteger;

public class MyThread extends Thread{

    BigInteger inputNumber;
    BigInteger diff;

    public MyThread(BigInteger inputNumber) {

        this.inputNumber = inputNumber;
    }


    @Override
    public void run() {

    }

    public void calc() {

        while(this.inputNumber.compareTo(BigInteger.ZERO) == 1) {
            BigInteger diff = (this.inputNumber.pow(2)).subtract((this.inputNumber.subtract(BigInteger.ONE).pow(2)));
            inputNumber = inputNumber.subtract(BigInteger.valueOf(2));
        }

    }


}
