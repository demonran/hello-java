package com.huawei.practicetest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 明明生成了N个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
 数据范围：  ，输入的数字大小满足

**/
public class PT02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(sc.nextLine()));
        }
        sc.close();

        numbers.stream().distinct().sorted().forEach(System.out::println);
    }


}
