package com.huawei;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberCombination {

    public static void main(String[] args) {
        String[] numbers = new Scanner(System.in).nextLine().split(",");

        String maxNumber = Stream.of(numbers).sorted((o1, o2) -> {
                                     int len = Math.min(o1.length(), o2.length());
                                     for (int i = 0; i < len; i++) {
                                         if (o1.charAt(i) != o2.charAt(i)) {
                                             return o2.charAt(i) - o1.charAt(i);
                                         }
                                     }
                                     return o1.length() > o2.length() ? o1.charAt(0) - o1.charAt(len): o2.charAt(len) - o2.charAt(0);
                                 })

                                 .collect(Collectors.joining());

        System.out.println(maxNumber);
    }
}
