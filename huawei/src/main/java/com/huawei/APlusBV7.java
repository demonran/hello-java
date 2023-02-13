package com.huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class APlusBV7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        String lines = sc.nextLine();
        sc.close();

        String[] str = lines.split(" ");

        List<String> words = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            words.add(str[i]);
        }

        String result = words.stream().sorted(Comparator.naturalOrder())
                              .collect(Collectors.joining(" "));

        System.out.println(result);

    }
}
