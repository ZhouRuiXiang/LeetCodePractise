package com.leetcode.multi_threading_2.zero_even_odd;

/**
 * @author BlueStar
 * @date 2021/5/20 21:23
 * @Description:
 */
public class Main {
    public static void main(String[] args) {

        InSequence inSequence = new InSequence(5);
        PrintEven printEven = new PrintEven(inSequence);
        PrintOdd printOdd = new PrintOdd(inSequence);
        PrintZero printZero = new PrintZero(inSequence);

        Thread thread1 = new Thread(printOdd);
        Thread thread2 = new Thread(printEven);
        Thread thread3 = new Thread(printZero);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
