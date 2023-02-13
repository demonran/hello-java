package com.lura.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindShortestSubArray {
    public static int findShortestSubArray(int[] nums) {

        Map<Integer, int[]> map = new HashMap<>();
        int minWindow = 0, maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] pairs = map.get(nums[i]);
            if (pairs == null) {
                pairs = new int[]{i, 1};
                map.put(nums[i], pairs);
            }else {
                pairs[1]++;
            }

            if (maxCount < pairs[1]) {
                maxCount = pairs[1];
                minWindow = i - pairs[0] + 1;
            } else if (maxCount == pairs[1]) {
                minWindow = Math.min(minWindow, i - pairs[0] + 1);
            }
        }
        return minWindow;

    }
}
