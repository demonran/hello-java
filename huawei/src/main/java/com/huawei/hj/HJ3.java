package com.huawei.hj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(sc.nextLine()));
        }
        sc.close();

       numbers.stream().distinct().sorted(((o1, o2) -> o2 - o1)).forEach(System.out::println);
    }
}
