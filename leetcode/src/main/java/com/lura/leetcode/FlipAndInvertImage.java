package com.lura.leetcode;

public class FlipAndInvertImage {
    public static int[][] flipAndInvertImage(int[][] A) {
        for (int[] item: A) {
            int n = item.length;
            for (int i = 0; i < n/2; i++) {
                item[i] = item[i] ^ item[n - 1 - i];
                item[n - 1 - i] = item[i] ^ item[n - 1 - i];
                item[i] = item[i] ^ item[n - 1 - i];

            }

            for (int i = 0; i < n; i++) {
                item[i] ^= 1;
            }
        }

        return A;
    }
}
