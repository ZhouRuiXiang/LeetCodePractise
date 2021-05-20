package com.leetcode.array.intersection_of_two_arrays;

import java.lang.annotation.Inherited;
import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/**
 * @author BlueStar
 * @date 2021/5/18 19:40
 * @Description: Intersection of  two arrays
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 1, 5};
        int[] arr2 = {2, 1, 3, 5};
        int[] intersection = intersection(arr1, arr2);

        System.out.println(Arrays.toString(intersection));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        // 降低时间复杂度 遍历那个长度短的 然后通过查找算法 找到所有相交的数
//        ArrayList<Integer> list = new ArrayList<>();
        // hashSet去重
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        set1.removeIf(integer -> !set2.contains(integer));
        Iterator<Integer> it = set1.iterator();
//        while (it.hasNext()) {
//            if (!set2.contains(it.next())) {
//                it.remove();
//            }
//        }

        Integer[] integers = set1.toArray(new Integer[]{});
        int[] ints = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            ints[i] = integers[i];
        }

        return ints;


        //        for (int num : set1) {
//            if (!set2.contains(num)){
//                set1.removeIf(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) {
//
//                        return integer.equals(num);
//                    }
//                });
//            }
//        }
    }
}
