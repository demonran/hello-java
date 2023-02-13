package com.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class APlusB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> lines = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                break;
            }
            lines.add(line);
        }
        sc.close();

        lines.forEach(line -> {
            String[] numberStr = line.split(" ");
            System.out.println(Integer.parseInt(numberStr[0]) + Integer.parseInt(numberStr[1]));
        });


    }
}
