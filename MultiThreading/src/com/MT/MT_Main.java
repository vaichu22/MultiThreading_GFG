package com.MT;

public class MT_Main {

    public static void main(String[] args) {

        MT_OuterClass mt = new MT_OuterClass();
        mt.start();

        System.out.println("I am in thread : "+ Thread.currentThread().getName());
        System.out.println("Main :"+System.currentTimeMillis());
    }
}
