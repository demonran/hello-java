package com.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class APlusBV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        List<String> lines = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            String line = sc.nextLine();
            lines.add(line);
        }
        sc.close();

        lines.forEach(line -> {
            String[] numberStr = line.split(" ");
            System.out.println(Integer.parseInt(numberStr[0]) + Integer.parseInt(numberStr[1]));
        });


    }
}
