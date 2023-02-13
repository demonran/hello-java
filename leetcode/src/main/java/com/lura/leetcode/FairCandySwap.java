package com.lura.leetcode;

import java.util.Arrays;

public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {

        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();

        int ave = (sumA - sumB)/2;

        int[] nums = new int[2];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] - ave == B[j]) {
                    nums[0] = A[i];
                    nums[1] = B[j];
                    return nums;
                }
            }
        }
        return nums;
    }
}
