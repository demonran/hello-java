package com.huawei.bm;

import java.util.Arrays;

public class BM97 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new BM97().solve(7, 1, new int[]{1, 2, 3, 4, 5, 6, 7})));
    }

    public int[] solve(int n, int m, int[] a) {
        m = m % n;
        reverse(a, 0, n -1);
        reverse(a, 0, m - 1);
        reverse (a,m, n - 1);

        return a;

    }

    private void reverse(int[] a, int start, int end) {
        while (start < end) {
            int tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;

            start++;
            end--;
        }

    }
}
