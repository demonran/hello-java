package com.lura.leetcode;

public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int ret = 0;
        int startIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 1) {
                ret = Math.max(ret, i - startIndex);
                startIndex = i+1;
            }
        }

        return  Math.max(ret, n - startIndex);
    }


    public int findMaxConsecutiveOnes2(int[] nums) {
        int n = nums.length;
        int ret = 0;
        int startIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                startIndex = i;
            }else {
                ret = Math.max(ret, i - startIndex);
            }
        }
        return  ret;
    }
}
