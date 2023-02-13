package com.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class APlusBV5 {
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
            int numberCount = Integer.parseInt(numberStr[0]);
            int sum = 0;
            for (int i = 1; i <= numberCount; i++) {
                sum += Integer.parseInt(numberStr[i]);
            }
            System.out.println(sum);
        });


    }
}
