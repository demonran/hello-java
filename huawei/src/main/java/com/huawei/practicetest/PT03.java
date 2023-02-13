package com.huawei.practicetest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PT03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine().substring(2);


        System.out.println(Integer.parseInt(line, 16));
    }
}
