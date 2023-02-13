package com.lura.leetcode;

import java.util.Arrays;

public class MedianSlidingWindow {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = k;
        double[] array = new double[n - right + 1];
        while (right <= n) {
            int[] temp = Arrays.stream(Arrays.copyOfRange(nums, left, right)).sorted().toArray();
            if (k % 2 == 0) {
                array[left] = (temp[k / 2 - 1] + temp[k / 2 ]) / 2.0;
            } else {
                array[left] = temp[k / 2 ];
            }

            left++;
            right++;
        }
        return array;

    }
}
