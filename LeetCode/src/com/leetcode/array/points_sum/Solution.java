package com.leetcode.array.points_sum;

import java.util.*;
import java.util.function.Predicate;

/**
 * @author BlueStar
 * @date 2021/6/8 8:39
 * @Description: 在一个数组中，求解数组和
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 * <p>
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 * <p>
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 * <p>
 * 输入：ops = ["5","2","C","D","+"]
 * 输出：30
 * 解释：
 * "5" - 记录加 5 ，记录现在是 [5]
 * "2" - 记录加 2 ，记录现在是 [5, 2]
 * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5].
 * "D" - 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
 * "+" - 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
 * 所有得分的总和 5 + 10 + 15 = 30
 */
@SuppressWarnings("all")
public class Solution {
    public static void main(String[] args) {
        String[] strArr = {"1"};
        int sum = calPoints(strArr);
        System.out.println(sum);
    }

    public static int calPoints(String[] ops) {
        int sum = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (String op : ops) {
            if ("C".equals(op)) {
                list.remove(list.size() - 1);
            } else if ("D".equals(op)) {
                list.add(list.get(list.size() - 1) * 2);
            } else if ("+".equals(op)) {
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
            } else {
                list.add(Integer.parseInt(op));
            }
        }
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }
    public static int calPoints2(String[] ops) {
        // 优化空间复杂度 不使用集合 换用两个变量存储数组前面的两个数
        /*
             尝试用两个变量代替集合 失败
             原因："C".equals(ops[i]) 删除前一个元素时，
             prev = prev2 当时 prev2无法再找到其前一个元素了
             如果使用三个变量的情况， prev3 = prev2
             则遍历开始时，需要有如下条件
                int i = 2
             满足上条件时，则ops[0] ops[1] 必须满足为整数
             所以不满足题意
         */

//        int sum = 0;
//        int prev = 0, prev2 = Integer.parseInt(ops[0]);
//        for (int i = 1; i < ops.length; i++) {
//            if ("C".equals(ops[i])) {
//
//                prev = prev2;
//                sum -= prev;
//            } else if ("D".equals(ops[i])) {
//                prev = 2 * prev2;
//                sum += prev;
//            } else if ("+".equals(ops[i])) {
//                prev = prev2 + prev;
//                sum += prev;
//            } else {
//                prev = Integer.parseInt(ops[i]);
//                sum += prev;
//        }
//        }

        return 0;
    }
}
