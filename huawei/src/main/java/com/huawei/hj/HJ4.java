package com.huawei.hj;

import java.util.Scanner;

public class HJ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        sc.close();

        int len = line.length();

        int count = len / 8;

        for (int i = 0; i < count; i++) {
            String str = line.substring(8 * i, 8 * i + 8);
            System.out.println(str);
        }

        if (len % 8 != 0) {
            String str = line.substring(count * 8);
            StringBuilder supplement = new StringBuilder();
            for (int j = 0; j < 8 - str.length(); j++) {
                supplement.append("0");
            }
            System.out.println(str + supplement);
        }

    }
}
