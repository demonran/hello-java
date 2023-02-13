package com.huawei.hj;

import java.util.Scanner;

public class HJ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        char character = sc.nextLine().charAt(0);
        if (character >= 'A' && character <= 'Z') {
            character += 'a' - 'A';
        }
        sc.close();

        int count = 0;

        for (char c : line.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c += 'a' - 'A';
            }
            if (character == c) {
                count++;
            }
        }

        System.out.println(count);
    }
}
