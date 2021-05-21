package com.leetcode.multi_threading.print_in_sequence;

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
        Thread thread1 = new Thread(printOdd);
        Thread thread2 = new Thread(printEven);

        thread1.start();
        thread2.start();

    }
}
