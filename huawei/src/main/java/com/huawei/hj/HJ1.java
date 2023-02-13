package com.huawei.hj;

import java.util.Scanner;

public class HJ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        sc.close();

        String[] words = line.split(" ");
        System.out.println(words[words.length - 1].length());
    }
}
