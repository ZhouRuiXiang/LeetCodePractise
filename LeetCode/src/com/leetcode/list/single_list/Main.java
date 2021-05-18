package com.leetcode.list.single_list;


public class Main {
    public static void main(String[] args) {
        SingleList<Integer> list = new SingleList<>();

        list.add(5, 0);
        list.add(1, 1);
        list.add(2, 1);
        list.add(3, 1);
        list.add(4, 1);

        System.out.println(list);
        System.out.println(list.get(4));
        System.out.println(list);




    }
}
