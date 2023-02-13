package com.huawei.practicetest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
 小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
 数据范围：输入的正整数满足

 注意：本题存在多组输入。输入的 0 表示输入结束，并不用输出结果。
 return f(n-2)+1;
**/
public class PT01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Integer> numbers = new ArrayList<>();
        numbers.add(n);
        while (n != 0) {
            n = Integer.parseInt(sc.nextLine());
            if (n >= 1 && n <= 100) {
                numbers.add(n);
            }
        }
        numbers.forEach(number -> calc(number, 0));
    }

    private static void calc(int n, int j) {
        int m = n / 3;

        if (n  == 2) {
            m++;
            n -= 3;
        }
        n = m + n % 3;
        if (m == 0) {
            System.out.println(j);
        } else {
            j += m;
            calc(n, j);
        }
    }
}
