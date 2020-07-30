package com.MT;

import java.math.BigInteger;
import java.util.Scanner;

public class NewAssignment {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Enter the value : ");
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        BigInteger inputNumber = new BigInteger(input);

        Runnable r = new MyThread1();
        //MyThread1 obj1 = new MyThread1(inputNumber);
        Thread t = new Thread(r);
        Runnable r2 = new MyThread2();
        Thread t2 = new Thread(r2);
        t.start();
        t2.start();

        t.join();
        t2.join();
    }

}

class MyThread1 implements Runnable{
    NewAssignment na = new NewAssignment();

    public void run(){

    }
}

class MyThread2 implements Runnable{
    public void run(){
        System.out.println(System.currentTimeMillis());
        for(int i=1;i<=1100;i+=2) {
            System.out.println(i);
        }
    }
}
