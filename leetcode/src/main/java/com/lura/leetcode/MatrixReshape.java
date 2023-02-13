package com.lura.leetcode;

public class MatrixReshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums[0].length;
        int total = n * nums.length;
        if (r * c != total) {
            return nums;
        }

        int[][] ret = new int[r][c];

        for (int i = 0; i < total; i++) {
            ret[i/c][i%c] = nums[i/n][i%n];
        }
        return ret;
    }
}
