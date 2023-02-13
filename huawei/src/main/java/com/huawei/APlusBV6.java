package com.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class APlusBV6 {
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
            int sum = 0;
            for (int i = 0; i < numberStr.length; i++) {
                sum += Integer.parseInt(numberStr[i]);
            }
            System.out.println(sum);
        });


    }
}
