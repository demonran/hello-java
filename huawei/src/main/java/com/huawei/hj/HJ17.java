package com.huawei.hj;

import java.util.Scanner;

public class HJ17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        sc.close();

        String[] move = line.split(";");


        int x = 0;
        int y = 0;
        for (String s : move) {
            if (s.isEmpty()) {
                continue;
            }
            String direction = s.substring(0, 1);
            int step = 0;
            try {
                step = Integer.parseInt(s.substring(1));
                if (step > 99 || step < 0) {
                    continue;
                }
            } catch (Exception e) {
                continue;
            }

            switch (direction) {
                case "A":
                    x -= step;
                    break;
                case "D":
                    x += step;
                    break;
                case "W":
                    y += step;
                    break;
                case "S":
                    y -= step;
                    break;
                default:
                    break;
            }

        }
        System.out.println(String.format("%s,%s", x ,y));


    }
}
